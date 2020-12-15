package com.common.generate.javacreate.service.impl;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.constants.SystemConstant;
import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.service.FileService;
import com.common.generate.javacreate.service.IQuestionBankService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author xialei
 * @date 2020/12/1 13:40
 */

@Service
public class NiuKeService extends FileService {

    @Autowired
    private IQuestionBankService questionBankService;

    public QuestionBankDTO dealText(String line, QuestionBankDTO questionBankDTO) {
        if (StringUtils.isEmpty(line)) {
            return questionBankDTO;
        }
        line = line.trim();
        StringBuilder builder = new StringBuilder();
        if (line.startsWith("问题: ")) {
            if(StringUtils.isNotEmpty(questionBankDTO.getQuestion())){
                questionBankDTO = save(questionBankDTO);
            }
            line = line.replace("问题: ", "");
            builder.append(SystemConstant.LINE_FEED_WIN).append("问题:").append(line);
            questionBankDTO.setQuestion(line);
        } else if (line.startsWith("考察点：")) {
            line = line.replace("考察点：", "");
            builder.append(SystemConstant.LINE_FEED_WIN).append("考察点：").append(line);
            questionBankDTO.setKeyWord(line);
        } else if (line.startsWith("参考回答：")) {
            line = line.replace("参考回答：", "");
            builder.append(SystemConstant.LINE_FEED_WIN).append("参考回答：").append(line);
            questionBankDTO.setAnswer(line);
        }
        return questionBankDTO;
    }

    @Override
    public String dealText(String line, boolean changeFlag) {
        return null;
    }

    @Override
    public void getFileByName(String sourceFileName) {
        File inFile = FileUtils.getFile(sourceFileName);
        BufferedReader in = null;
        System.out.println(JSON.toJSONString(inFile));
        try {
            in = new BufferedReader(new FileReader(inFile));
            String line = "";
            QuestionBankDTO questionBankDTO = new QuestionBankDTO();
            while ((line = in.readLine()) != null) {
                questionBankDTO = dealText(line, questionBankDTO);
            }
            if(StringUtils.isNotEmpty(questionBankDTO.getQuestion())){
                save(questionBankDTO);
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


    private QuestionBankDTO save(QuestionBankDTO dto){
        questionBankService.insert(dto);
        return new QuestionBankDTO();
    }

}
