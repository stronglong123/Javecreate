package com.common.generate.javacreate.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author xialei
 * @date 2021/10/27 15:00
 */


@Data
@Document(indexName = "user")
public class UserEsQueryDTO implements Serializable {

    private static final long serialVersionUID = -7011425372090693019L;

    @Id
    @Field(type = FieldType.Keyword, store = true)
    private String id;

    /**
     * 索引时用ik_max_word，在搜索时用ik_smart
     */
    @Field(type = FieldType.Text)
    private String content;
    /**
     * 身份证号
     */
    @Field(type = FieldType.Keyword) //当前字段不能分词
    private String idCard;
    /**
     * 年龄
     */
    @Field(type = FieldType.Keyword)
    private String age;
    /**
     * 性别
     */
    @Field(type = FieldType.Keyword)
    private String sex;
    /**
     * 姓名
     */
    @Field(type = FieldType.Keyword)
    private String name;
}
