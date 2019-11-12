package cn.whu.rest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @Author WangYong
 * @Date 2019/11/08
 * @Time 18:53
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(QueueListener.class);

    @Autowired
    private MockQueue moQueue;
    @Autowired
    private DeferredResultHalder deferredResultHalder;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        //无限循环
        new Thread(() -> {
            while (true) {
                if (moQueue.getComplaceOrder() != null && !moQueue.getComplaceOrder().equals("")) {
                    String orderNumber = moQueue.getComplaceOrder();
                    logger.info("返回订单处理结果" + orderNumber);
                    deferredResultHalder.getMap().get(orderNumber).setResult(new Person("liuting", 29));
                    moQueue.setComplaceOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}