package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.QuestionBankBL;
import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.IQuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-01
 */
@Service
public class QuestionBankServiceImpl implements IQuestionBankService {
    @Autowired
    private QuestionBankBL questionBankBl;
    
    @Override
    public QuestionBankDTO detail(Long id){
        return questionBankBl.detail(id);
    }
    
    @Override
    public PageList<QuestionBankDTO> pageList(QuestionBankQueryDTO questionBank) {
        return questionBankBl.pageList(questionBank);
    }
    
    @Override
    public void insert(QuestionBankDTO questionBank) {
        questionBankBl.insert(questionBank);
    }
    
    @Override
    public void insertBatch(List<QuestionBankDTO> questionBanks){
        questionBankBl.insertBatch(questionBanks);
    }
    
    @Override
    public void update(QuestionBankDTO questionBank) {
        questionBankBl.update(questionBank);
    }
    
    @Override
    public void delete(QuestionBankDTO questionBank) {
        questionBankBl.delete(questionBank);
    }

}
