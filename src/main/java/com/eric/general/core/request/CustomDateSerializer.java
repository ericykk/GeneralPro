package com.eric.general.core.request;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:将java对象中date类型字段转换为指定格式的json字符串
 * author:Eric
 * Date:16/10/17
 * Time:18:38
 * version 1.0.0
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String dataStr = dateFormat.format(date);
        jsonGenerator.writeString(dataStr);
    }
}
