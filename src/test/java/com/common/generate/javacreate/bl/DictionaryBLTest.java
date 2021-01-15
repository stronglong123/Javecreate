package com.common.generate.javacreate.bl;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.JavacreateApplication;
import com.common.generate.javacreate.model.CategoryDTO;
import com.common.generate.javacreate.model.CategoryTestDTO;
import com.common.generate.javacreate.model.DictionaryDTO;
import com.common.generate.javacreate.model.DictionaryQueryDTO;
import com.common.generate.javacreate.model.ProductCategoryGroupDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.utils.FileUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
        String json = FileUtil.readFileByChars("C:\\Users\\Administrator\\Desktop\\供应链类目.txt");
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


    @Test
    public void test2(){
        String json = FileUtil.readFileByChars("C:\\Users\\Administrator\\Desktop\\供应链类目.txt");
        List<ProductCategoryGroupDTO> productCategoryGroupDTOS = JSON.parseArray(json, ProductCategoryGroupDTO.class);
        List<CategoryTestDTO> list =new ArrayList<>();
        loopTree2(productCategoryGroupDTOS,null,list);
        System.out.println(JSON.toJSONString(list));
        List<String> result =new ArrayList<>();
        list.stream().filter(it->it.getLeaf()).forEach(it->{
            String name = it.getCatName();
            if(StringUtils.isNotEmpty(it.getpId())){
                name = findParentName(list, it.getpId(), name);
            }
            result.add(name);
        });
        System.out.println(JSON.toJSONString(result));
    }

    public String findParentName(List<CategoryTestDTO> list, String catId,String name) {
        CategoryTestDTO categoryTestDTO = list.stream().filter(it -> it.getCatId().equals(catId)).findAny().orElse(null);
        name = categoryTestDTO.getCatName()+"/"+name;
        if(StringUtils.isNotEmpty(categoryTestDTO.getpId())){
            CategoryTestDTO dto = list.stream().filter(it -> it.getCatId().equals(categoryTestDTO.getpId())).findAny().orElse(null);
            name = dto.getCatName()+"/"+name;
        }
        return name;
    }


    private void loopTree2(List<ProductCategoryGroupDTO> dtos, String parentId, List<CategoryTestDTO> list) {
        for (ProductCategoryGroupDTO dto : dtos) {
            if(dto.getName().equals("膨化食品")){
                System.out.println(JSON.toJSONString(dto));
            }
            CategoryTestDTO categoryDTO =new CategoryTestDTO();
            categoryDTO.setCatId(dto.getId().toString());
            categoryDTO.setCatName(dto.getName());
            categoryDTO.setpId(parentId);
            if (CollectionUtils.isNotEmpty(dto.getChildProductCategoryGroupDTOS())) {
                categoryDTO.setLeaf(false);
                list.add(categoryDTO);
                loopTree2(dto.getChildProductCategoryGroupDTOS(), dto.getId().toString(), list);
            } else {
                categoryDTO.setLeaf(true);
                list.add(categoryDTO);
            }
        }
    }
}