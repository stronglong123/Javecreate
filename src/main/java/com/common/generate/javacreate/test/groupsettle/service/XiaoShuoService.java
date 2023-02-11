package com.common.generate.javacreate.test.groupsettle.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.text.TextDTO;
import com.common.generate.javacreate.test.groupsettle.dto.PushOtherSettleDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author xialei
 * @date 2022/3/14 20:29
 */
public class XiaoShuoService {

    public static void main(String[] args) throws Exception {
        general();
    }


    private static void general() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\冤种玩家的人生模拟器.xlsx";
        List<TextDTO> tableDTOS = ExcelUtils.readExcelToEntity(TextDTO.class, filePath, "冤种玩家的人生模拟器.xlsx");
        StringBuilder result = new StringBuilder();
        tableDTOS.forEach(it -> {
            String comment = it.getComment();
            if(StringUtils.isNotEmpty(comment)){
                comment = comment.replace("mchaptererror();『章节错误,点此举报』", "");
                String[] split = comment.split("请翻页\\)");
                comment = split[0];
                comment = comment.replace("(本章未完,", "");

            }


            result.append(("\r\n"))
//                    .append(it.getTitle())
//                    .append(("\r\n"))
                    .append(comment);
        });

        exportText(result.toString());
    }


    /* 导出txt文件
     * @author
     * @param	response
     * @param	text 导出的字符串
     * @return
     */
    public static void exportTxt(HttpServletResponse response, String text) {

        BufferedOutputStream buff = null;
        ServletOutputStream outStr = null;
        try {
            outStr = response.getOutputStream();
            buff = new BufferedOutputStream(outStr);
            buff.write(text.getBytes("UTF-8"));
            buff.flush();
            buff.close();
        } catch (Exception e) {
            //LOGGER.error("导出文件文件出错:{}",e);
        } finally {
            try {
                buff.close();
                outStr.close();
            } catch (Exception e) {
                //LOGGER.error("关闭流对象出错 e:{}",e);
            }
        }
    }


    public static void exportText(String data) {
        try {
            File file = new File("C:\\Users\\Administrator\\Desktop\\data.txt");
            if (!file.exists()) {
                file.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            }
            FileOutputStream fos = new FileOutputStream(file, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(data);
            bw.newLine();
            bw.flush();
            bw.close();
            osw.close();
            fos.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
