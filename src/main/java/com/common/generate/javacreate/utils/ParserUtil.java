package com.common.generate.javacreate.utils;

import com.common.generate.javacreate.advice.aop.FieldMeta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xialei
 * @date 2020/3/4 19:43
 */
public class ParserUtil {

	private ParserUtil() {}

    private static final Logger logger = LoggerFactory.getLogger(ParserUtil.class);

    /**
     * 通过属性取得属性的描述注解
     *
     * @param field
     * @return
     */
    public static String getDesc(Field field) {
        String result = null;
        try {
            field.setAccessible(true);
            Annotation[] annotation = field.getAnnotations();
            for (Annotation tag : annotation) {
                if (tag instanceof FieldMeta) {
                    result = ((FieldMeta) tag).desc();
                    break;
                }
            }
        } catch (SecurityException e) {
            logger.error("获取属性错误", e);
        }
        return result;
    }

    /**
     * 通过对象和属性名称取得属性的描述注解
     *
     * @param obj
     * @param propertyName
     * @return
     */
    public static String getDesc(Object obj, String propertyName) {
        String result = null;
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getName().equals(propertyName)) {
                    String desc = getDesc(field);
                    if (desc != null && !desc.isEmpty()) {
                        result = desc;
                        break;
                    }
                }
            }
        } catch (SecurityException e) {
            logger.error("获取对象属性注解错误", e);
        }
        return result;
    }



    /**
     * 取得obj所有属性的描述注解，返回值为key为obj的属性名称,value为此属性的描述注解
     *
     * @param obj
     * @return
     */
    public static Map<String, String> getAllDesc(Object obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            return getResult(fields);
        } catch (SecurityException e) {
            logger.error("获取所有属性注解错误", e);
        }
        return null;
    }

    /**
     * 取得obj所有属性的描述注解，返回值为key为obj的属性名称,value为此属性的描述注解
     *
     * @param clzName
     * @return
     */
    public static Map<String, String> getAllDesc(String clzName) {
        try {
            Field[] fields = Class.forName(clzName).getDeclaredFields();
            return getResult(fields);
        } catch (SecurityException | ClassNotFoundException e) {
            logger.error("获取对象属性注解错误", e);
        }
        return null;
    }

    /**
     * 将field[]里的字段名称做为key和字段描述做value放在map中
     *
     * @param fields
     */
    private static Map<String, String> getResult(Field[] fields) {
        Map<String, String> result = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id")||field.getName().equals("serialVersionUID")) {
                continue;
            }
            String desc = getDesc(field);
            if (desc != null && !desc.isEmpty()) {
                result.put(field.getName(), getDesc(field));
            }
        }
        return result;
    }


    public static Map<String, String> getAllTypes(Object obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            return getTypes(fields);
        } catch (SecurityException e) {
            logger.error("获取属性类型错误", e);
        }
        return null;
    }

    public static Map<String, String> getAllTypes(String clzName) {
        try {
            Field[] fields = Class.forName(clzName).getDeclaredFields();
            return getTypes(fields);
        } catch (Exception e) {
            logger.error("获取所有属性类型错误", e);
        }
        return null;
    }


    private static Map<String, String> getTypes(Field[] fields) {
        Map<String, String> result = new HashMap<String, String>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id")||field.getName().equals("serialVersionUID")) {
                continue;
            }
            result.put(field.getName(), field.getType().getSimpleName());
        }
        return result;
    }


    public static Map<String, String> getAllFileds(Object obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            return getFileds(fields);
        } catch (SecurityException e) {
            logger.error("获取字段属性错误", e);
        }
        return null;
    }

    public static Map<String, String> getAllFileds(String clzName) {
        try {
            Field[] fields = Class.forName(clzName).getDeclaredFields();
            return getFileds(fields);
        } catch (Exception e) {
            logger.error("获取所有属性错误", e);
        }
        return null;
    }

    private static Map<String, String> getFileds(Field[] fields) {
        Map<String, String> result = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("id")||field.getName().equals("serialVersionUID")) {
                continue;
            }
            result.put(field.getName(), field.getName());
        }
        return result;
    }

}
