package com.common.generate.javacreate.service;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

/**
 * @author xialei
 * @date 2020/11/30 17:37
 */

@Service
public abstract class FileService {


    public void getFileByName(String sourceFileName, String targetFileName) {
//        File inFile = FileUtils.getFile("C:/Users/Administrator/Desktop/java基本题.txt");
//        File outFile = FileUtils.getFile("C:/Users/Administrator/Desktop/java基本题.txt");
        File inFile = FileUtils.getFile(sourceFileName);
        File outFile = FileUtils.getFile(targetFileName);
        BufferedWriter out = null;
        BufferedReader in = null;
        System.out.println(JSON.toJSONString(inFile));
        try {
            in = new BufferedReader(new FileReader(inFile));
            String line = "";
            out = new BufferedWriter(new FileWriter(outFile));
            boolean changeFlag = true;
            while ((line = in.readLine()) != null) {
                String text = dealText(line, changeFlag);
                if (StringUtils.isNotEmpty(text)) {
                    out.write(text);
                }
            }
        } catch (Exception e) {
            throw new BusinessValidateException("文件读取失败:" + e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new BusinessValidateException("输入流关闭失败:" + e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    throw new BusinessValidateException("输出流关闭失败:" + e);
                }
            }
        }
    }

    public abstract String dealText(String line, boolean changeFlag);


    private String dealText2(String line, boolean changeFlag) {
        if (StringUtils.isEmpty(line)) {
            return "";
        }
        line = line.trim();
        StringBuilder builder = new StringBuilder();
        if (line.startsWith("●")) {
            line = line.replace("●", "");
            builder.append("\r\n").append("问题:").append(line);
        } else if (line.startsWith("考察点")) {
            builder.append("\r\n").append(line);
        } else if (line.startsWith("参考回答")) {
            builder.append("\r\n").append(line);
        } else {
            builder.append(line);
        }
        return builder.toString();
    }


    public void getFileByName(String sourceFileName) {
        File inFile = FileUtils.getFile(sourceFileName);
        BufferedReader in = null;
        System.out.println(JSON.toJSONString(inFile));
        try {
            in = new BufferedReader(new FileReader(inFile));
            String line = "";
            boolean changeFlag = true;
            while ((line = in.readLine()) != null) {
                dealText(line, changeFlag);
            }
        } catch (Exception e) {
            throw new BusinessValidateException("文件读取失败:" + e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new BusinessValidateException("输入流关闭失败:" + e);
                }
            }
        }
    }



}
