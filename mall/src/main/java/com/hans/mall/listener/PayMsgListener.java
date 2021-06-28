package com.hans.mall.listener;

import com.google.gson.Gson;
import com.hans.mall.pojo.PayInfo;
import com.hans.mall.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "payNotify")
@Slf4j
public class PayMsgListener {

    @Autowired
    private OrderServiceImpl orderService;

    @RabbitHandler
    public void process(String msg) {
        log.info(" received => {}", msg);

        PayInfo payInfo = new Gson().fromJson(msg, PayInfo.class);
        if (payInfo.getPlatformStatus().equals("SUCCESS")) {
            // change order status
            orderService.paid(payInfo.getOrderNo());
        }
    }

}
