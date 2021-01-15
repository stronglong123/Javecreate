package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.dao.QuestionBankMapper;
import com.common.generate.javacreate.model.QuestionBankDTO;
import com.common.generate.javacreate.model.QuestionBankQueryDTO;
import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.base.PageResult;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.utils.UUIDUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author xialei
 * @date 2020-12-01
 */
@Service
public class QuestionBankBL {
    @Autowired
    private QuestionBankMapper questionBankMapper;

    public QuestionBankDTO detail(Long id) {
        return questionBankMapper.detail(id);
    }

    public PageList<QuestionBankDTO> pageList(QuestionBankQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
        List<QuestionBankDTO> list = questionBankMapper.list(queryDTO);
        return new PageList<>(list);
    }

    public void insert(QuestionBankDTO questionBank) {
        if (questionBank.getId() == null) {
            questionBank.setId(UUIDUtil.getUuid());
        }
        questionBankMapper.insert(questionBank);
    }

    public void insertBatch(List<QuestionBankDTO> questionBanks) {
        questionBanks.stream().filter(it->it.getId()==null).forEach(it->it.setId(UUIDUtil.getUuid()));
        questionBankMapper.insertBatch(questionBanks);
    }

    public void update(QuestionBankDTO questionBank) {
        questionBankMapper.update(questionBank);
    }

    public void delete(QuestionBankDTO questionBank) {
        questionBankMapper.delete(questionBank);
    }

}
