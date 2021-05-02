package com.common.generate.javacreate.utils;

import com.common.generate.javacreate.model.base.exception.DataValidateException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xialei
 * @date 2021/4/30 22:29
 */
/**
 * @author liushuang 2018/2/24
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jp.getText();
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new DataValidateException(e);
        }
    }
}
