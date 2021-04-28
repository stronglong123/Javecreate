package com.common.generate.javacreate.utils;

import org.springframework.stereotype.Component;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.hankcs.hanlp.seg.common.Term;

/**
 * @author xialei
 * @date 2021/1/16 17:58
 */
@Component
public class NewsSummaryUtil {

    //保留关键词数量
    int N = 50;

    //关键词间的距离阀值
    int CLUSTER_THRESHOLD = 5;

    //前top-n句子
    int TOP_SENTENCES = 10;

    //最大边缘相关阀值
    double λ = 0.4;

    //句子得分使用方法
    final Set<String> styleSet = new HashSet<String>();

    //停用词列表
    Set<String> stopWords = new HashSet<String>();

    //句子编号及分词列表
    Map<Integer, List<String>> sentSegmentWords = null;

    public NewsSummaryUtil() {
//        this.loadStopWords("D:\\work\\Solr\\solr-python\\CNstopwords.txt");
        styleSet.add("meanstd");
        styleSet.add("default");
        styleSet.add("MMR");
    }

    /**
     * 加载停词
     *
     * @param path
     */
    private void loadStopWords(String path) {
        BufferedReader br = null;
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "utf-8");
            br = new BufferedReader(reader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stopWords.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author：sks
     * @Description：利用正则将文本拆分成句子
     * @Date：
     */
    private List<String> SplitSentences(String text) {
        List<String> sentences = new ArrayList<String>();
        String regEx = "[!?。！？.]";
        Pattern p = Pattern.compile(regEx);
        String[] sents = p.split(text);
        Matcher m = p.matcher(text);

        int sentsLen = sents.length;
        if (sentsLen > 0) {  //把每个句子的末尾标点符号加上
            int index = 0;
            while (index < sentsLen) {
                if (m.find()) {
                    sents[index] += m.group();
                }
                index++;
            }
        }
        for (String sentence : sents) {
            //文章从网页上拷贝过来后遗留下来的没有处理掉的html的标志
            sentence = sentence.replaceAll("(&rdquo;|&ldquo;|&mdash;|&lsquo;|&rsquo;|&middot;|&quot;|&darr;|&bull;)", "");
            sentences.add(sentence.trim());
        }
        return sentences;
    }

    /**
     * 这里使用IK进行分词
     *
     * @param text
     * @return
     */
    private List<String> IKSegment(String text) {
        List<String> wordList = new ArrayList<String>();
        Reader reader = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(reader, true);
        Lexeme lex = null;
        try {
            while ((lex = ik.next()) != null) {
                String word = lex.getLexemeText();
                if (word.equals("nbsp") || this.stopWords.contains(word)) {
                    continue;
                }
                if (word.length() > 1 && word != "\t") {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }


    /**
     * 每个句子得分  (keywordsLen*keywordsLen/totalWordsLen)
     *
     * @param sentences 分句
     * @param topnWords keywords top-n关键词
     * @return
     */
    private Map<Integer, Double> scoreSentences(List<String> sentences, List<String> topnWords) {
        Map<Integer, Double> scoresMap = new LinkedHashMap<Integer, Double>();//句子编号，得分
        sentSegmentWords = new HashMap<Integer, List<String>>();
        int sentence_idx = -1;//句子编号
        for (String sentence : sentences) {
            sentence_idx += 1;
            List<String> words = this.IKSegment(sentence);//对每个句子分词
//            List<String> words= HanLP.segment(sentence);
            sentSegmentWords.put(sentence_idx, words);
            List<Integer> word_idx = new ArrayList<Integer>();//每个关词键在本句子中的位置
            for (String word : topnWords) {
                if (words.contains(word)) {
                    word_idx.add(words.indexOf(word));
                } else{
                    continue;
                }
            }
            if (word_idx.size() == 0){
                continue;
            }
            Collections.sort(word_idx);
            //对于两个连续的单词，利用单词位置索引，通过距离阀值计算一个族
            List<List<Integer>> clusters = new ArrayList<List<Integer>>();//根据本句中的关键词的距离存放多个词族
            List<Integer> cluster = new ArrayList<Integer>();
            cluster.add(word_idx.get(0));
            int i = 1;
            while (i < word_idx.size()) {
                if ((word_idx.get(i) - word_idx.get(i - 1)) < this.CLUSTER_THRESHOLD)
                    cluster.add(word_idx.get(i));
                else {
                    clusters.add(cluster);
                    cluster = new ArrayList<Integer>();
                    cluster.add(word_idx.get(i));
                }
                i += 1;
            }
            clusters.add(cluster);
            //对每个词族打分，选择最高得分作为本句的得分
            double max_cluster_score = 0.0;
            for (List<Integer> clu : clusters) {
                int keywordsLen = clu.size();//关键词个数
                int totalWordsLen = clu.get(keywordsLen - 1) - clu.get(0) + 1;//总的词数
                double score = 1.0 * keywordsLen * keywordsLen / totalWordsLen;
                if (score > max_cluster_score) {
                    max_cluster_score = score;
                }
            }
            scoresMap.put(sentence_idx, max_cluster_score);
        }
        return scoresMap;
    }


    /**
     * @Author：sks
     * @Description：利用均值方差自动文摘
     * @Date：
     */
    public String SummaryMeanstdTxt(String text) {
        //将文本拆分成句子列表
        List<String> sentencesList = this.SplitSentences(text);

        //利用IK分词组件将文本分词，返回分词列表
        List<String> words = this.IKSegment(text);
//        List<Term> words1= HanLP.segment(text);

        //统计分词频率
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer val = wordsMap.get(word);
            wordsMap.put(word, val == null ? 1 : val + 1);

        }


        //使用优先队列自动排序
        Queue<Map.Entry<String, Integer>> wordsQueue = new PriorityQueue<Map.Entry<String, Integer>>(wordsMap.size(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        wordsQueue.addAll(wordsMap.entrySet());

        if (N > wordsMap.size()) {
            N = wordsQueue.size();
        }

        //取前N个频次最高的词存在wordsList
        List<String> wordsList = new ArrayList<String>(N);//top-n关键词
        for (int i = 0; i < N; i++) {
            Entry<String, Integer> entry = wordsQueue.poll();
            wordsList.add(entry.getKey());
        }

        //利用频次关键字，给句子打分，并对打分后句子列表依据得分大小降序排序
        Map<Integer, Double> scoresLinkedMap = scoreSentences(sentencesList, wordsList);//返回的得分,从第一句开始,句子编号的自然顺序


        //approach1,利用均值和标准差过滤非重要句子
        Map<Integer, String> keySentence = new LinkedHashMap<Integer, String>();

        //句子得分均值
        double sentenceMean = 0.0;
        for (double value : scoresLinkedMap.values()) {
            sentenceMean += value;
        }
        sentenceMean /= scoresLinkedMap.size();

        //句子得分标准差
        double sentenceStd = 0.0;
        for (Double score : scoresLinkedMap.values()) {
            sentenceStd += Math.pow((score - sentenceMean), 2);
        }
        sentenceStd = Math.sqrt(sentenceStd / scoresLinkedMap.size());

        for (Map.Entry<Integer, Double> entry : scoresLinkedMap.entrySet()) {
            //过滤低分句子
            if (entry.getValue() > (sentenceMean + 0.5 * sentenceStd)) {
                keySentence.put(entry.getKey(), sentencesList.get(entry.getKey()));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index : keySentence.keySet()) {
            sb.append(keySentence.get(index));
        }
        return sb.toString();
    }

    /**
     * @Author：sks
     * @Description：默认返回排序得分top-n句子
     * @Date：
     */
    public String SummaryTopNTxt(String text) {
        //将文本拆分成句子列表
        List<String> sentencesList = this.SplitSentences(text);

        //利用IK分词组件将文本分词，返回分词列表
        List<String> words = this.IKSegment(text);
//        List<Term> words1= HanLP.segment(text);

        //统计分词频率
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer val = wordsMap.get(word);
            wordsMap.put(word, val == null ? 1 : val + 1);

        }


        //使用优先队列自动排序
        Queue<Map.Entry<String, Integer>> wordsQueue = new PriorityQueue<Map.Entry<String, Integer>>(wordsMap.size(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        wordsQueue.addAll(wordsMap.entrySet());

        if (N > wordsMap.size()) {
            N = wordsQueue.size();
        }

        //取前N个频次最高的词存在wordsList
        List<String> wordsList = new ArrayList<String>(N);//top-n关键词
        for (int i = 0; i < N; i++) {
            Entry<String, Integer> entry = wordsQueue.poll();
            wordsList.add(entry.getKey());
        }

        //利用频次关键字，给句子打分，并对打分后句子列表依据得分大小降序排序
        Map<Integer, Double> scoresLinkedMap = scoreSentences(sentencesList, wordsList);//返回的得分,从第一句开始,句子编号的自然顺序
        List<Map.Entry<Integer, Double>> sortedSentList = new ArrayList<Map.Entry<Integer, Double>>(scoresLinkedMap.entrySet());//按得分从高到底排序好的句子，句子编号与得分
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(sortedSentList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
                return o2.getValue().equals(o1.getValue()) ? 0 :
                        (o2.getValue() > o1.getValue() ? 1 : -1);
            }

        });

        //approach2,默认返回排序得分top-n句子
        Map<Integer, String> keySentence = new TreeMap<Integer, String>();
        int count = 0;
        for (Map.Entry<Integer, Double> entry : sortedSentList) {
            count++;
            keySentence.put(entry.getKey(), sentencesList.get(entry.getKey()));
            if (count == this.TOP_SENTENCES) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index : keySentence.keySet()) {
            sb.append(keySentence.get(index));
        }
        return sb.toString();
    }

    /**
     * @Author：sks
     * @Description：利用最大边缘相关自动文摘
     * @Date：
     */
    public String SummaryMMRNTxt(String text) {
        //将文本拆分成句子列表
        List<String> sentencesList = this.SplitSentences(text);

        //利用IK分词组件将文本分词，返回分词列表
        List<String> words = this.IKSegment(text);
//        List<Term> words1= HanLP.segment(text);

        //统计分词频率
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer val = wordsMap.get(word);
            wordsMap.put(word, val == null ? 1 : val + 1);

        }


        //使用优先队列自动排序
        Queue<Map.Entry<String, Integer>> wordsQueue = new PriorityQueue<Map.Entry<String, Integer>>(wordsMap.size(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        wordsQueue.addAll(wordsMap.entrySet());

        if (N > wordsMap.size()) {
            N = wordsQueue.size();
        }

        //取前N个频次最高的词存在wordsList
        List<String> wordsList = new ArrayList<String>(N);//top-n关键词
        for (int i = 0; i < N; i++) {
            Entry<String, Integer> entry = wordsQueue.poll();
            wordsList.add(entry.getKey());
        }

        //利用频次关键字，给句子打分，并对打分后句子列表依据得分大小降序排序
        Map<Integer, Double> scoresLinkedMap = scoreSentences(sentencesList, wordsList);//返回的得分,从第一句开始,句子编号的自然顺序
        List<Map.Entry<Integer, Double>> sortedSentList = new ArrayList<Map.Entry<Integer, Double>>(scoresLinkedMap.entrySet());//按得分从高到底排序好的句子，句子编号与得分
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(sortedSentList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
                return o2.getValue().equals(o1.getValue()) ? 0 :
                        (o2.getValue() > o1.getValue() ? 1 : -1);
            }

        });

        //approach3,利用最大边缘相关，返回前top-n句子
        if (sentencesList.size() == 2) {
            return sentencesList.get(0) + sentencesList.get(1);
        } else if (sentencesList.size() == 1) {
            return sentencesList.get(0);
        }
        Map<Integer, String> keySentence = new TreeMap<Integer, String>();
        int count = 0;
        Map<Integer, Double> MMR_SentScore = MMR(sortedSentList);
        for (Map.Entry<Integer, Double> entry : MMR_SentScore.entrySet()) {
            count++;
            int sentIndex = entry.getKey();
            String sentence = sentencesList.get(sentIndex);
            keySentence.put(sentIndex, sentence);
            if (count == this.TOP_SENTENCES) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int index : keySentence.keySet()) {
            sb.append(keySentence.get(index));
        }
        return sb.toString();
    }

    /**
     * 计算文本摘要
     *
     * @param text
     * @param style(meanstd,default,MMR)
     * @return
     */
    public String summarize(String text, String style) {
        try {
            if (!styleSet.contains(style) || text.trim().equals("")) {
                throw new IllegalArgumentException("方法 summarize(String text,String style)中text不能为空，style必须是meanstd、default或者MMR");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }

        //将文本拆分成句子列表
        List<String> sentencesList = this.SplitSentences(text);

        //利用IK分词组件将文本分词，返回分词列表
        List<String> words = this.IKSegment(text);
//        List<Term> words1= HanLP.segment(text);

        //统计分词频率
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer val = wordsMap.get(word);
            wordsMap.put(word, val == null ? 1 : val + 1);

        }


        //使用优先队列自动排序
        Queue<Map.Entry<String, Integer>> wordsQueue = new PriorityQueue<Map.Entry<String, Integer>>(wordsMap.size(), new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1,
                               Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        wordsQueue.addAll(wordsMap.entrySet());

        if (N > wordsMap.size()) {
            N = wordsQueue.size();
        }

        //取前N个频次最高的词存在wordsList
        List<String> wordsList = new ArrayList<String>(N);//top-n关键词
        for (int i = 0; i < N; i++) {
            Entry<String, Integer> entry = wordsQueue.poll();
            wordsList.add(entry.getKey());
        }

        //利用频次关键字，给句子打分，并对打分后句子列表依据得分大小降序排序
        Map<Integer, Double> scoresLinkedMap = scoreSentences(sentencesList, wordsList);//返回的得分,从第一句开始,句子编号的自然顺序


        Map<Integer, String> keySentence = null;

        //approach1,利用均值和标准差过滤非重要句子
        if (style.equals("meanstd")) {
            keySentence = new LinkedHashMap<Integer, String>();

            //句子得分均值
            double sentenceMean = 0.0;
            for (double value : scoresLinkedMap.values()) {
                sentenceMean += value;
            }
            sentenceMean /= scoresLinkedMap.size();

            //句子得分标准差
            double sentenceStd = 0.0;
            for (Double score : scoresLinkedMap.values()) {
                sentenceStd += Math.pow((score - sentenceMean), 2);
            }
            sentenceStd = Math.sqrt(sentenceStd / scoresLinkedMap.size());

            for (Map.Entry<Integer, Double> entry : scoresLinkedMap.entrySet()) {
                //过滤低分句子
                if (entry.getValue() > (sentenceMean + 0.5 * sentenceStd)) {
                    keySentence.put(entry.getKey(), sentencesList.get(entry.getKey()));
                }
            }
        }

        List<Map.Entry<Integer, Double>> sortedSentList = new ArrayList<Map.Entry<Integer, Double>>(scoresLinkedMap.entrySet());//按得分从高到底排序好的句子，句子编号与得分
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(sortedSentList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
                return o2.getValue().equals(o1.getValue()) ? 0 :
                        (o2.getValue() > o1.getValue() ? 1 : -1);
            }

        });

        //approach2,默认返回排序得分top-n句子
        if (style.equals("default")) {
            keySentence = new TreeMap<Integer, String>();
            int count = 0;
            for (Map.Entry<Integer, Double> entry : sortedSentList) {
                count++;
                keySentence.put(entry.getKey(), sentencesList.get(entry.getKey()));
                if (count == this.TOP_SENTENCES) {
                    break;
                }
            }
        }

        //approach3,利用最大边缘相关，返回前top-n句子
        if (style.equals("MMR")) {
            if (sentencesList.size() == 2) {
                return sentencesList.get(0) + sentencesList.get(1);
            } else if (sentencesList.size() == 1) {
                return sentencesList.get(0);
            }
            keySentence = new TreeMap<Integer, String>();
            int count = 0;
            Map<Integer, Double> MMR_SentScore = MMR(sortedSentList);
            for (Map.Entry<Integer, Double> entry : MMR_SentScore.entrySet()) {
                count++;
                int sentIndex = entry.getKey();
                String sentence = sentencesList.get(sentIndex);
                keySentence.put(sentIndex, sentence);
                if (count == this.TOP_SENTENCES) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int index : keySentence.keySet()) {
            sb.append(keySentence.get(index));
        }
        //System.out.println("summarize out...");
        return sb.toString();
    }

    /**
     * 最大边缘相关(Maximal Marginal Relevance)，根据λ调节准确性和多样性
     * max[λ*score(i) - (1-λ)*max[similarity(i,j)]]:score(i)句子的得分，similarity(i,j)句子i与j的相似度
     * User-tunable diversity through λ parameter
     * - High λ= Higher accuracy
     * - Low λ= Higher diversity
     *
     * @param sortedSentList 排好序的句子，编号及得分
     * @return
     */
    private Map<Integer, Double> MMR(List<Map.Entry<Integer, Double>> sortedSentList) {
        //System.out.println("MMR In...");
        double[][] simSentArray = sentJSimilarity();//所有句子的相似度
        Map<Integer, Double> sortedLinkedSent = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> entry : sortedSentList) {
            sortedLinkedSent.put(entry.getKey(), entry.getValue());
        }
        Map<Integer, Double> MMR_SentScore = new LinkedHashMap<Integer, Double>();//最终的得分（句子编号与得分）
        Map.Entry<Integer, Double> Entry = sortedSentList.get(0);//第一步先将最高分的句子加入
        MMR_SentScore.put(Entry.getKey(), Entry.getValue());
        boolean flag = true;
        while (flag) {
            int index = 0;
            double maxScore = Double.NEGATIVE_INFINITY;//通过迭代计算获得最高分句子
            for (Map.Entry<Integer, Double> entry : sortedLinkedSent.entrySet()) {
                if (MMR_SentScore.containsKey(entry.getKey())) {
                    continue;
                }
                double simSentence = 0.0;
                for (Map.Entry<Integer, Double> MMREntry : MMR_SentScore.entrySet()) {//这个是获得最相似的那个句子的最大相似值
                    double simSen = 0.0;
                    if (entry.getKey() > MMREntry.getKey()) {
                        simSen = simSentArray[MMREntry.getKey()][entry.getKey()];
                    } else {
                        simSen = simSentArray[entry.getKey()][MMREntry.getKey()];
                    }
                    if (simSen > simSentence) {
                        simSentence = simSen;
                    }
                }
                simSentence = λ * entry.getValue() - (1 - λ) * simSentence;
                if (simSentence > maxScore) {
                    maxScore = simSentence;
                    index = entry.getKey();//句子编号
                }
            }
            MMR_SentScore.put(index, maxScore);
            if (MMR_SentScore.size() == sortedLinkedSent.size()) {
                flag = false;
            }
        }
        //System.out.println("MMR out...");
        return MMR_SentScore;
    }

    /**
     * 每个句子的相似度，这里使用简单的jaccard方法，计算所有句子的两两相似度
     *
     * @return
     */
    private double[][] sentJSimilarity() {
        //System.out.println("sentJSimilarity in...");
        int size = sentSegmentWords.size();
        double[][] simSent = new double[size][size];
        for (Map.Entry<Integer, List<String>> entry : sentSegmentWords.entrySet()) {
            for (Map.Entry<Integer, List<String>> entry1 : sentSegmentWords.entrySet()) {
                if (entry.getKey() >= entry1.getKey()) {
                    continue;
                }
                int commonWords = 0;
                double sim = 0.0;
                for (String entryStr : entry.getValue()) {
                    if (entry1.getValue().contains(entryStr)) {
                        commonWords++;
                    }
                }
                sim = 1.0 * commonWords / (entry.getValue().size() + entry1.getValue().size() - commonWords);
                simSent[entry.getKey()][entry1.getKey()] = sim;
            }
        }
        //System.out.println("sentJSimilarity out...");
        return simSent;
    }

    public static void main(String[] args) {

        NewsSummaryUtil summary = new NewsSummaryUtil();


        String text = "我国古代历史演义小说的代表作。明代小说家罗贯中依据有关三国的历史、杂记，在广泛吸取民间传说和民间艺人创作成果的基础上，加工、再创作了这部长篇章回小说。" +
                "作品写的是汉末到晋初这一历史时期魏、蜀、吴三个封建统治集团间政治、军事、外交等各方面的复杂斗争。通过这些描写，揭露了社会的黑暗与腐朽，谴责了统治阶级的残暴与奸诈，" +
                "反映了人民在动乱时代的苦难和明君仁政的愿望。小说也反映了作者对农民起义的偏见，以及因果报应和宿命论等思想。战争描写是《三国演义》突出的艺术成就。" +
                "这部小说通过惊心动魄的军事、政治斗争，运用夸张、对比、烘托、渲染等艺术手法，成功地塑造了诸葛亮、曹操、关羽、张飞等一批鲜明、生动的人物形象。" +
                "《三国演义》结构宏伟而又严密精巧，语言简洁、明快、生动。有的评论认为这部作品在艺术上的不足之处是人物性格缺乏发展变化，有的人物渲染夸张过分导致失真。" +
                "《三国演义》标志着历史演义小说的辉煌成就。在传播政治、军事斗争经验、推动历史演义创作的繁荣等方面都起过积极作用。" +
                "《三国演义》的版本主要有明嘉靖刻本《三国志通俗演义》和清毛宗岗增删评点的《三国志演义》";

        text = "被告人:对? 关于王立军,有几个基本事实.首先,1月28日我是初次听到此事.并不相信谷开来会杀人.我跟11·15杀人案无关.我不是谷开来11·15杀人罪的共犯.这个大家都认可.实际上谷开来3月14日她在北京被抓走!" +
                "在这之前她一直非常确切地跟我说她没杀人,是王立军诬陷她.我在1月28日和次听到这个事时我不相信她会杀人." +
                "第二个事实,免王立军的局长.是多个因素.一个,我确实认为他诬陷谷开来.但我并不是想掩盖11·15,我是觉得他人品不好." +
                "因为谷开来和他是如胶似漆,谷开来对他是言听计从,那王立军也通过与谷开来的交往中打入了我的家庭." +
                "那现在发生这么严重的事.作为一个起码的人,要讲人格的话,你干吗不找谷开来商量,而跑我这里来说这些话?" +
                "第二个免他的原因,是他想要挟我.他多次谈他身体不好,打黑压力大,得罪了人." +
                "其实这是在表功.第三,徐某某给我反映了他有五六条问题.有记录.实际上免他是有这些原因的,绝不只是一个谷开来的原因.这是多因一果.";

        text ="我今天想和大家分享一些我的人生经验，比如说，如何在4个月的时间内完成减重近40斤的任务。我从小就非常自卑，因为我的数学成绩特别差。全班的数学平均分是80分时，我的分数是8分。同学们都觉得我的脑子有问题，老师们也觉得我将来不会有什么出息。我心里很难过，就问我妈怎么办，我妈说：“没关系，我带你去找一些科学的解决办法。”什么解决办法呢？我妈带我去拜访气功大师。我走在路上，心想这哪里科学了！怎么会有人去找气功大师治脑子呢？结果我们到现场一看，有3000多人都坐在那里。我当时有两个感受：第一，我们的城市不大，可是怎么有这么多脑子不好的人？第二，我并不孤独。经过“治疗”，“奇迹”果然出现了。我以前数学是很少及格的，大师对我“发功”后，我的数学就再也没有及格过。这是我第一次跟自卑作战，却以惨败而告终。我带着这种低人一等的想法度过了整个学生时代，直到我参加工作。为什么参加工作之后，我突然没有这种智力上的自卑感了呢？因为没有数学考试了啊！我的工作只要靠四则运算就可以做得很好，再难一点的交给电脑就可以完成。所以在那个时候，我完全摆脱了智力上的自卑感。但是，另外一件事情又给我营造了巨大的自卑感——我的发际线开始往后退了。最近我看了一则新闻，说最早的一批“90后”开始秃头了。“90后”老是玩手机、玩电脑、熬夜、不好好吃饭，不秃头才怪！我那时候才22岁，一洗头，掉的头发就会堵塞下水道。我试过各种方法，比如拿生姜往脑袋上擦，把醋往头上倒，让整个脑袋弥漫着那种“迷人”的味道。然后什么中药、西药，民间的、官方的，几乎所有治脱发的方子我都试过了，但都没用。我25岁时，发际线已经到天灵盖了，眼神不好的小伙伴开始管我叫“爷爷”了。于是我打算破罐子破摔——直接剃光头！在去理发店的路上，我碰到了单位的领导，领导说：“你不能剃光头，剃了光头会影响企业形象。”我说：“我的头发马上要掉光了，变成纯天然的光头，到时候还是一样啊！”领导就说：“你这个年轻人，该走的弯路一米都不会少，你要向我们学习，把两边的头发留长，交叉盖在头顶上，这样别人就不会发现你是一个秃头了。”我只好从命。我当时在厂区骑单车，风一吹，两边的头发就会竖起来，像海带一样在空中飘动。那种耻辱的感觉，你们体会一下。当时，我做了一个很红的播客，名叫“教授易小星”（后改为“叫兽易小星”），总是戴着一个面具。那是因为我的自卑心理在作祟，我担心自己一摘下面具，观众就会说：“啊，原来易小星这个人又秃又胖，好难看。”我无法接受这个事实，只能通过戴面具来跟我的自卑心理作战，那个面具我戴了5年。但后来我来到北京转行做导演，发型上的自卑感突然消失了。因为我发现，北京有好多人都是光头。北京是一座很神奇的城市，大家都可以变成自己想要的样子，没有人对你说教，没有人会看你不顺眼，你只要做好自己，不去干扰别人就行。所以我换了一个环境后，再也没有戴过面具。我与之战斗了5年的自卑的源头，就这样莫名其妙地消失了，我成了快乐的光头导演。但是，2016年，又有一件事情引发了我强烈的自卑感。我辛辛苦苦做好了一个系列的剧本，原本定好的男主角突然档期有冲突，我在短时间内找不到合适的演员来演这部戏，最后只能自导自演。我要演的角色是一个30岁左右的青年男子，但是，我根本不敢站在镜头前，根本不敢去展现自己，因为我觉得自己又胖又老又难看。如果当时我完成不了这部作品的拍摄，之前一年和兄弟们的努力就全白费了。所以我决定要战胜自卑，开始减肥，力争从一个油腻的中年胖子变成一个英俊的青年瘦子。我的减肥计划是先管住嘴。吃年夜饭时，我端着一碗水煮的青菜，看着大家吃排骨、猪蹄、红烧鱼等各种美食。我爸觉得我是神经病，都30多岁了竟然还要减肥。但是人一旦坚定目标，就比较容易达成所愿。我就是从那天晚上开始管住嘴的，然后连续吃了4个月的“健身餐”，并且连续健身4个月，最终实现了目标。大家都说，我瘦下来后精神变得特别好。能不好吗？少了几十斤肉，跑起来特别快，我以特别愉快的心态拍完了那部戏。但是我发现了一个残酷的事实：虽然我瘦下来了，但并没有变英俊。我跟我的自卑心理作战，又失败了，我只是从一个难看的胖子变成了一个难看的瘦子。不过我对自身形象的自卑感消失了，我没有战胜自己那些自卑心理的源头，但是我变成了一个超级自信的人。从智力上的自卑到发型上的自卑，再到形象上的自卑，我一直在和自卑作战，一直试着改变这一切。但到最后我才发现，我其实根本没有必要和自卑战斗，因为上天给我的一切，很多时候是没有办法改变的。也许你和我一样，不够聪明，没有数学天赋，一辈子也不可能成为在数学方面很有造诣的人，但没关系，你可以从事对数学要求不高的工作；也许你和我一样，周围的人觉得你太有个性了，但没关系，你可以换一个没有人觉得你格格不入的环境；也许你和我一样，没有特别好看的外表，但没关系，你可以锻炼身体，让自己身体健康、心态变好。我们根本不需要去战胜自卑，因为每个人都不完美，每个人都会因为自己的不完美而产生自卑心理，都会在人生的某个阶段产生自卑心理。如果要和自卑作战，那么这一辈子恐怕都无休止。如果你跟我一样，也不完美，那就接受自己的不完美，与自己的自卑和平共处，把自卑变成自己前进的动力。";


        System.out.println(text);

        String keySentences = summary.SummaryMeanstdTxt(text);
        System.out.println("summary: " + keySentences);

        String topSentences = summary.SummaryTopNTxt(text);
        System.out.println("summary: " + topSentences);

        String mmrSentences = summary.SummaryMMRNTxt(text);
        System.out.println("summary: " + mmrSentences);


    }
}
