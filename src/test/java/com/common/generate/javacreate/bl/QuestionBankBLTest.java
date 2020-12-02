package com.common.generate.javacreate.bl;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.JavacreateApplication;
import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author xialei
 * @date 2020/12/1 16:35
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavacreateApplication.class)
public class QuestionBankBLTest {

    @Autowired
    private QuestionBankBL questionBankBL;

    @Test
    public void detail() {
    }

    @Test
    public void pageList() {
        QuestionBankQueryDTO questionBankDTO =new QuestionBankQueryDTO();
        PageList<QuestionBankDTO> pageList = questionBankBL.pageList(questionBankDTO);
        System.out.println(JSON.toJSONString(pageList));
    }

    @Test
    public void insert() {
        QuestionBankDTO dto =new QuestionBankDTO();
        dto.setKeyWord("测试");
        dto.setQuestion("怎么使用");
        dto.setAnswer("使用方式");
        questionBankBL.insert(dto);
    }

    @Test
    public void insertBatch() {
    }

    @Test
    public void update() {
        QuestionBankDTO dto =new QuestionBankDTO();
        dto.setId(1L);
        dto.setKeyWord("关键词1");
        questionBankBL.update(dto);
    }

    @Test
    public void delete() {
        QuestionBankDTO dto =new QuestionBankDTO();
        dto.setId(1L);
        questionBankBL.delete(dto);
    }
}