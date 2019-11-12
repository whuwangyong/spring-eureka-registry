package cn.whu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author WangYong
 * @Date 2019/11/08
 * @Time 18:52
 */
@Component
public class MockQueue {
    private static final Logger logger = LoggerFactory.getLogger(MockQueue.class);

    private String placeOrder;
    private String complaceOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            logger.info("接到下单请求，正处理……" + placeOrder);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.complaceOrder = placeOrder;
            logger.info("下单请求处理完成" + placeOrder);
        }).start();
    }

    public String getComplaceOrder() {
        return complaceOrder;
    }

    public void setComplaceOrder(String complaceOrder) {
        this.complaceOrder = complaceOrder;
    }
}
