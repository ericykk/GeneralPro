package com.eric.general.configuration.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description: 将客户端请求json中的字符串日期转换指定格式Date
 * author:Eric
 * Date:16/10/17
 * Time:14:53
 * version 1.0.0
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        String dateStr = jsonParser.getText();
        if(StringUtils.isBlank(dateStr)){
            return null;
        }
        try{
            //字符串格式日期
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
            return dateFormat.parse(dateStr);
        }catch (ParseException e){
            e.printStackTrace();
            //时间戳格式日期
            Long dateTime = Long.parseLong(dateStr);
            return new Date(dateTime);
        }
    }
}
