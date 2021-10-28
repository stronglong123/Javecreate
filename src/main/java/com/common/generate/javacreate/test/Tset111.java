package com.yijiupi.himalaya.supplychain.omsgroupsettle.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;

/**
 * @author xialei
 * @date 2021/5/12 18:51
 */
public class Tset111 {

    public static void main(String[] args) throws Exception {
        try {
        	File file = new File("C:\\Users\\Administrator\\Desktop\\测试.txt");
            String content = FileUtils.readFileToString(file);
            
            int s = content.indexOf("div class=\"portlet-body\"");
            int e = content.indexOf("div class='col-md-5 col-sm-12' style='margin: 10px 0;'");
            content = content.substring(s-1,e-1);
//            System.out.println(content);
            
            s = content.indexOf("tbody");
            e = content.indexOf("/table");
            content = content.substring(s-1,e-1);
//            System.out.println(content);
            
            Parser parser = new Parser();
            parser.setInputHTML(content);
            
            int index = 0;

            for (NodeIterator i = parser.elements (); i.hasMoreNodes(); ) {
                Node node = i.nextNode();
                
                if("tr role=\"row\" class=\"odd\"".equals(node.getText())) {
                	System.out.println("第"+index+"一个对象###############");
                	int index2 = 0;
                	for (NodeIterator j = node.getChildren().elements(); j.hasMoreNodes(); ) {
                		 Node tdNode = j.nextNode();
                		 if(tdNode.getText().contains("td")) {
                			 index2++;
                			 if(tdNode.toPlainTextString() == null || "".equals(tdNode.toPlainTextString())) {
                				 continue;
                			 }
                			 if(index2 >= 16) {
                				 continue;
                			 }
                			 
                			 // TODO
                			 System.out.println(tdNode.toPlainTextString());
                		 }
                	}
                	System.out.println("第"+index+"一个对象###############");
                	index++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
