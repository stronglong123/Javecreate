package com.common.generate.javacreate.utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xialei
 * @date 2021/1/16 10:40
 */
public class SimpleSummariserAlgorithmUtil {
    /**
     * @param @param  input
     * @param @param  numSentences
     * @param @return
     * @return String
     * @throws
     * @Title: summarise
     * @Description: 文章摘要实现
     */
    public static String summarise(String input, int numSentences) {
        // get the frequency of each word in the input 计算原始文本的词频，生成一个数组
        Map<String, Integer> wordFrequencies = segStr(input);

        // now create a set of the X most frequent words
        Set<String> mostFrequentWords = getMostFrequentWords(100, wordFrequencies).keySet();

        // break the input up into sentences
        // workingSentences is used for the analysis, but
        // actualSentences is used in the results so that the
        // capitalisation will be correct.
        String[] workingSentences = getSentences(input.toLowerCase());
        String[] actualSentences = getSentences(input);

        // iterate over the most frequent words, and add the first sentence
        // that includes each word to the result
        Set<String> outputSentences = new LinkedHashSet<String>();
        Iterator<String> it = mostFrequentWords.iterator();
        while (it.hasNext()) {
            String word = (String) it.next();
            for (int i = 0; i < workingSentences.length; i++) {
                if (workingSentences[i].indexOf(word) >= 0) {
                    outputSentences.add(actualSentences[i]);
                    break;
                }
                if (outputSentences.size() >= numSentences) {
                    break;
                }
            }
            if (outputSentences.size() >= numSentences) {
                break;
            }

        }

        List<String> reorderedOutputSentences = reorderSentences(outputSentences, input);

        StringBuffer result = new StringBuffer("");
        it = reorderedOutputSentences.iterator();
        while (it.hasNext()) {
            String sentence = (String) it.next();
            result.append(sentence);
            result.append("."); // This isn't always correct - perhaps it should be whatever symbol the sentence finished with
            if (it.hasNext()) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    /**
     * @param @param  outputSentences
     * @param @param  input
     * @param @return
     * @return List<String>
     * @throws
     * @Title: reorderSentences
     * @Description: 将句子按顺序输出
     */
    private static List<String> reorderSentences(Set<String> outputSentences, final String input) {
        // reorder the sentences to the order they were in the
        // original text
        ArrayList<String> result = new ArrayList<String>(outputSentences);

        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {
                String sentence1 = (String) arg0;
                String sentence2 = (String) arg1;

                int indexOfSentence1 = input.indexOf(sentence1.trim());
                int indexOfSentence2 = input.indexOf(sentence2.trim());
                int result = indexOfSentence1 - indexOfSentence2;

                return result;
            }

        });
        return result;
    }

    /**
     * @param @param  num
     * @param @param  words
     * @param @return
     * @return Map<String, Integer>
     * @throws
     * @Title: getMostFrequentWords
     * @Description: 对分词进行按数量排序, 取出前num个
     */
    private static Map<String, Integer> getMostFrequentWords(int num, Map<String, Integer> words) {

        Map<String, Integer> keywords = new LinkedHashMap<String, Integer>();
        int count = 0;
        // 词频统计
        List<Map.Entry<String, Integer>> info = new ArrayList<Map.Entry<String, Integer>>(words.entrySet());
        Collections.sort(info, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });

        // 高频词输出
        for (int j = 0; j < info.size(); j++) {
            // 词-->频
            if (info.get(j).getKey().length() > 1) {
                if (num > count) {
                    keywords.put(info.get(j).getKey(), info.get(j).getValue());
                    count++;
                } else {
                    break;
                }
            }
        }
        return keywords;
    }


    /**
     * @param @param  content
     * @param @return
     * @return Map<String, Integer>
     * @throws
     * @Title: segStr
     * @Description: 返回LinkedHashMap的分词
     */
    private static Map<String, Integer> segStr(String content) {
        // 分词
        Reader input = new StringReader(content);
        // 智能分词关闭（对分词的精度影响很大）
        IKSegmenter iks = new IKSegmenter(input, true);
        Lexeme lexeme = null;
        Map<String, Integer> words = new LinkedHashMap<String, Integer>();
        try {
            while ((lexeme = iks.next()) != null) {
                if (words.containsKey(lexeme.getLexemeText())) {
                    words.put(lexeme.getLexemeText(), words.get(lexeme.getLexemeText()) + 1);
                } else {
                    words.put(lexeme.getLexemeText(), 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * @param @param  input
     * @param @return
     * @return String[]
     * @throws
     * @Title: getSentences
     * @Description: 把段落按. ! ?分隔成句组
     */
    private static String[] getSentences(String input) {
        if (input == null) {
            return new String[0];
        } else {
            // split on a ".", a "!", a "?" followed by a space or EOL
            //"(\\.|!|\\?)+(\\s|\\z)"
            return input.split("(\\.|!|\\?)");
        }

    }

    public static void main(String[] args) throws IOException {

//        String text="自古刀扇过背刺";
//        StringReader sr=new StringReader(text);
//        IKSegmenter ik=new IKSegmenter(sr, true);
//        Lexeme lex=null;
//        while((lex=ik.next())!=null) {
//            System.out.print(lex.getLexemeText() + "|");
//        }


        String text = "被告人:对? 关于王立军,有几个基本事实.首先,1月28日我是初次听到此事.并不相信谷开来会杀人.我跟11·15杀人案无关.我不是谷开来11·15杀人罪的共犯.这个大家都认可.实际上谷开来3月14日她在北京被抓走!" +
                "在这之前她一直非常确切地跟我说她没杀人,是王立军诬陷她.我在1月28日和次听到这个事时我不相信她会杀人." +
                "第二个事实,免王立军的局长.是多个因素.一个,我确实认为他诬陷谷开来.但我并不是想掩盖11·15,我是觉得他人品不好." +
                "因为谷开来和他是如胶似漆,谷开来对他是言听计从,那王立军也通过与谷开来的交往中打入了我的家庭." +
                "那现在发生这么严重的事.作为一个起码的人,要讲人格的话,你干吗不找谷开来商量,而跑我这里来说这些话?" +
                "第二个免他的原因,是他想要挟我.他多次谈他身体不好,打黑压力大,得罪了人." +
                "其实这是在表功.第三,徐某某给我反映了他有五六条问题.有记录.实际上免他是有这些原因的,绝不只是一个谷开来的原因.这是多因一果.";

        text ="我今天想和大家分享一些我的人生经验，比如说，如何在4个月的时间内完成减重近40斤的任务。我从小就非常自卑，因为我的数学成绩特别差。全班的数学平均分是80分时，我的分数是8分。同学们都觉得我的脑子有问题，老师们也觉得我将来不会有什么出息。我心里很难过，就问我妈怎么办，我妈说：“没关系，我带你去找一些科学的解决办法。”什么解决办法呢？我妈带我去拜访气功大师。我走在路上，心想这哪里科学了！怎么会有人去找气功大师治脑子呢？结果我们到现场一看，有3000多人都坐在那里。我当时有两个感受：第一，我们的城市不大，可是怎么有这么多脑子不好的人？第二，我并不孤独。经过“治疗”，“奇迹”果然出现了。我以前数学是很少及格的，大师对我“发功”后，我的数学就再也没有及格过。这是我第一次跟自卑作战，却以惨败而告终。我带着这种低人一等的想法度过了整个学生时代，直到我参加工作。为什么参加工作之后，我突然没有这种智力上的自卑感了呢？因为没有数学考试了啊！我的工作只要靠四则运算就可以做得很好，再难一点的交给电脑就可以完成。所以在那个时候，我完全摆脱了智力上的自卑感。但是，另外一件事情又给我营造了巨大的自卑感——我的发际线开始往后退了。最近我看了一则新闻，说最早的一批“90后”开始秃头了。“90后”老是玩手机、玩电脑、熬夜、不好好吃饭，不秃头才怪！我那时候才22岁，一洗头，掉的头发就会堵塞下水道。我试过各种方法，比如拿生姜往脑袋上擦，把醋往头上倒，让整个脑袋弥漫着那种“迷人”的味道。然后什么中药、西药，民间的、官方的，几乎所有治脱发的方子我都试过了，但都没用。我25岁时，发际线已经到天灵盖了，眼神不好的小伙伴开始管我叫“爷爷”了。于是我打算破罐子破摔——直接剃光头！在去理发店的路上，我碰到了单位的领导，领导说：“你不能剃光头，剃了光头会影响企业形象。”我说：“我的头发马上要掉光了，变成纯天然的光头，到时候还是一样啊！”领导就说：“你这个年轻人，该走的弯路一米都不会少，你要向我们学习，把两边的头发留长，交叉盖在头顶上，这样别人就不会发现你是一个秃头了。”我只好从命。我当时在厂区骑单车，风一吹，两边的头发就会竖起来，像海带一样在空中飘动。那种耻辱的感觉，你们体会一下。当时，我做了一个很红的播客，名叫“教授易小星”（后改为“叫兽易小星”），总是戴着一个面具。那是因为我的自卑心理在作祟，我担心自己一摘下面具，观众就会说：“啊，原来易小星这个人又秃又胖，好难看。”我无法接受这个事实，只能通过戴面具来跟我的自卑心理作战，那个面具我戴了5年。但后来我来到北京转行做导演，发型上的自卑感突然消失了。因为我发现，北京有好多人都是光头。北京是一座很神奇的城市，大家都可以变成自己想要的样子，没有人对你说教，没有人会看你不顺眼，你只要做好自己，不去干扰别人就行。所以我换了一个环境后，再也没有戴过面具。我与之战斗了5年的自卑的源头，就这样莫名其妙地消失了，我成了快乐的光头导演。但是，2016年，又有一件事情引发了我强烈的自卑感。我辛辛苦苦做好了一个系列的剧本，原本定好的男主角突然档期有冲突，我在短时间内找不到合适的演员来演这部戏，最后只能自导自演。我要演的角色是一个30岁左右的青年男子，但是，我根本不敢站在镜头前，根本不敢去展现自己，因为我觉得自己又胖又老又难看。如果当时我完成不了这部作品的拍摄，之前一年和兄弟们的努力就全白费了。所以我决定要战胜自卑，开始减肥，力争从一个油腻的中年胖子变成一个英俊的青年瘦子。我的减肥计划是先管住嘴。吃年夜饭时，我端着一碗水煮的青菜，看着大家吃排骨、猪蹄、红烧鱼等各种美食。我爸觉得我是神经病，都30多岁了竟然还要减肥。但是人一旦坚定目标，就比较容易达成所愿。我就是从那天晚上开始管住嘴的，然后连续吃了4个月的“健身餐”，并且连续健身4个月，最终实现了目标。大家都说，我瘦下来后精神变得特别好。能不好吗？少了几十斤肉，跑起来特别快，我以特别愉快的心态拍完了那部戏。但是我发现了一个残酷的事实：虽然我瘦下来了，但并没有变英俊。我跟我的自卑心理作战，又失败了，我只是从一个难看的胖子变成了一个难看的瘦子。不过我对自身形象的自卑感消失了，我没有战胜自己那些自卑心理的源头，但是我变成了一个超级自信的人。从智力上的自卑到发型上的自卑，再到形象上的自卑，我一直在和自卑作战，一直试着改变这一切。但到最后我才发现，我其实根本没有必要和自卑战斗，因为上天给我的一切，很多时候是没有办法改变的。也许你和我一样，不够聪明，没有数学天赋，一辈子也不可能成为在数学方面很有造诣的人，但没关系，你可以从事对数学要求不高的工作；也许你和我一样，周围的人觉得你太有个性了，但没关系，你可以换一个没有人觉得你格格不入的环境；也许你和我一样，没有特别好看的外表，但没关系，你可以锻炼身体，让自己身体健康、心态变好。我们根本不需要去战胜自卑，因为每个人都不完美，每个人都会因为自己的不完美而产生自卑心理，都会在人生的某个阶段产生自卑心理。如果要和自卑作战，那么这一辈子恐怕都无休止。如果你跟我一样，也不完美，那就接受自己的不完美，与自己的自卑和平共处，把自卑变成自己前进的动力。";
        System.out.println(text);
        System.out.println(summarise(text, 7));
    }

}
