package com.common.generate.javacreate.advice.aop;

/**
 * @author xialei
 * @date 2020/3/4 19:42
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @Description 字段注解
 * @author xialei
 * @since JDK 1.8
 * @version V1.0
 * @Date:2020年2月22日 下午11:34:47
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMeta {
    //字段的描述注解
    String desc();
}
