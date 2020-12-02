package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-01
 */
public interface IQuestionBankService {

     QuestionBankDTO detail(Long id);

     PageList<QuestionBankDTO> pageList(QuestionBankQueryDTO questionBank);

     void insert(QuestionBankDTO questionBank);

     void insertBatch(List<QuestionBankDTO> questionBanks);

     void update(QuestionBankDTO questionBank);

     void delete(QuestionBankDTO questionBank);

}
