package com.common.generate.javacreate.test;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2021/5/12 19:12
 */
public class ParseUtils {

    /**
     * 提取具有某个属性值的标签列表
     *
     * @param html           被提取的html文本
     * @param tagType        标签的类型
     * @param attributeName  某个属性的名称
     * @param attributeValue 属性应取的值
     * @return
     */
    public static <T extends TagNode> List<T> parseTags(String html, final Class<T> tagType, final String attributeName, final String attributeValue) {
        try {
            //创建一个html解释器
            Parser parser = new Parser();
            parser.setInputHTML(html);

            NodeList tagList = parser.parse(
                    new NodeFilter() {
                        @Override
                        public boolean accept(Node node) {
                            if (node.getClass() == tagType) {
                                T tn = (T) node;
                                if(tn==null){
                                    return false;
                                }
                                try {
                                    String attrValue = tn.getAttribute(attributeName);
                                    if (attrValue != null && attrValue.equals(attributeValue)) {
                                        return true;
                                    }
                                }catch (Exception e){
                                    return false;
                                }

                            }
                            return false;
                        }
                    }
            );
            List<T> tags = new ArrayList<T>();
            for (int i = 0; i < tagList.size(); i++) {
                T t = (T) tagList.elementAt(i);
                tags.add(t);
            }
            return tags;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 提取具有某个属性值的标签
     *
     * @param html           被提取的html文本
     * @param tagType        标签的类型
     * @param attributeName  某个属性的名称
     * @param attributeValue 属性应取的值
     * @return
     */
    public static <T extends TagNode> T parseTag(String html, final Class<T> tagType, final String attributeName, final String attributeValue) {
        List<T> tags = parseTags(html, tagType, attributeName, attributeValue);
        if (tags != null && tags.size() > 0) {
            return tags.get(0);
        }
        return null;
    }

    /**
     * 提取具有某个属性值的标签
     *
     * @param html    被提取的html文本
     * @param tagType 标签的类型
     * @return
     */
    public static <T extends TagNode> T parseTag(String html, final Class<T> tagType) {
        return parseTag(html, tagType, null, null);
    }

    /**
     * 提取具有某个属性值的标签列表
     *
     * @param html    被提取的html文本
     * @param tagType 标签的类型
     * @return
     */
    public static <T extends TagNode> List<T> parseTags(String html, final Class<T> tagType) {
        return parseTags(html, tagType, null, null);
    }
}
