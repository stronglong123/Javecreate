package com.common.generate.javacreate.bl;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.JavacreateApplication;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.ProductCategoryGroupDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.utils.FileUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xialei
 * @date 2020/12/10 18:15
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavacreateApplication.class)
public class DictionaryBLTest {

    @Autowired
    private DictionaryBL dictionaryBL;

    @Test
    public void selectByPrimaryKey() {



    }

    @Test
    public void pageList() {
        DictionaryQueryDTO queryDTO =new DictionaryQueryDTO();
        PageList<DictionaryDTO> pageList = dictionaryBL.pageList(queryDTO);
        System.out.println(JSON.toJSONString(pageList));
    }

    @Test
    public void list() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertBatch() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }


    @Test
    public void test(){
        String json = FileUtil.readFileByChars("C:\\Users\\Administrator\\Desktop\\response.txt");
        List<ProductCategoryGroupDTO> productCategoryGroupDTOS = JSON.parseArray(json, ProductCategoryGroupDTO.class);
        List<String> list =new ArrayList<>();
        loopTree(productCategoryGroupDTOS,"",list);
        System.out.println(JSON.toJSONString(list));
    }


    private void loopTree(List<ProductCategoryGroupDTO> dtos, String name, List<String> list) {
        for (ProductCategoryGroupDTO dto : dtos) {
            if (CollectionUtils.isNotEmpty(dto.getChildProductCategoryGroupDTOS())) {
                list.add(name+"/"+dto.getName());
                loopTree(dto.getChildProductCategoryGroupDTOS(), name+"/"+dto.getName(), list);
            } else {
                list.add(name+"/"+dto.getName());
            }
        }
    }
}