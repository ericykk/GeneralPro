package com.eric.general.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * Description:消息监听器
 *
 * @author: Eric
 * @Date: 18/8/7
 */
@Slf4j
public class UniversalMqListener implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        log.info("处理mq消息开始！");
        String handleMessage = new String(message.getBody(), "utf-8");
        if (StringUtils.isBlank(handleMessage)) {
            return;
        }
        JSONObject object = JSON.parseObject(handleMessage);
        log.info("当前处理消息：" + object.toJSONString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("处理mq消息结束！");
    }
}
