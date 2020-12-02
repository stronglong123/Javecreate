package com.common.generate.javacreate.dao;

import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.base.PageResult;

import java.util.List;

/**
 * @author xialei
 * @date  2020-12-01
 */
public interface QuestionBankMapper {

     QuestionBankDTO detail(Long id);

     List<QuestionBankDTO> list(QuestionBankQueryDTO questionBank);

     int insert(QuestionBankDTO questionBank);

     int insertBatch(List<QuestionBankDTO> questionBanks);

     int update(QuestionBankDTO questionBank);

     int delete(QuestionBankDTO questionBank);

}