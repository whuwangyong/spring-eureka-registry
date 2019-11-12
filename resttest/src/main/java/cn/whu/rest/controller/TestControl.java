package cn.whu.rest.controller;

import cn.whu.rest.ClientTest;
import cn.whu.rest.DeferredResultHalder;
import cn.whu.rest.MockQueue;
import cn.whu.rest.Person;
import org.omg.CORBA.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @Author WangYong
 * @Date 2019/11/08
 * @Time 18:33
 */
@RestController
public class TestControl {
    @Autowired
    private MockQueue moQueue;
    @Autowired
    private DeferredResultHalder deferredResultHalder;
    @Autowired
    ClientTest clientTest;

    private static final Logger logger = LoggerFactory.getLogger(TestControl.class);

    @GetMapping("/test")
    public String syncSuccess() {
        logger.info("主线程开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("主线程结束");
        return "success";
    }

    @GetMapping("/runnable")
    public Callable<String> asyncSuccessRunnable() {
        logger.info("主线程开始");
        Callable<String> result = new Callable<String>() {
            public String call() throws Exception {
                logger.info("副线程开始");
                Thread.sleep(10000);
                logger.info("副线程结束");
                return "runnable";
            }
        };
        logger.info("主线程结束");
        return result;
    }

    @GetMapping("/deferredResult")
    public DeferredResult<Person> asyncSuccessDeferredResult() {
        logger.info("主线程开始");
        String orderNumber = String.valueOf(new Random().nextInt());
        moQueue.setPlaceOrder(orderNumber);
        DeferredResult<Person> result = new DeferredResult<>();
        deferredResultHalder.getMap().put(orderNumber, result);
        result.onCompletion(() -> {
            logger.info("complete!");
        });
        result.setResultHandler(new DeferredResult.DeferredResultHandler() {
            @Override
            public void handleResult(Object result) {
                logger.info("result:" + result.toString());
            }
        });
        logger.info("主线程结束");
        return result;
    }

    @PostMapping("/deferredResult")
    public DeferredResult<Person> asyncSuccessDeferredResult2(@RequestBody Person person) {
        logger.info("主线程开始");
//        String orderNumber = String.valueOf(new Random().nextInt());
        String orderNumber = person.getName();
        moQueue.setPlaceOrder(orderNumber);
        DeferredResult<Person> result = new DeferredResult<>();
        deferredResultHalder.getMap().put(orderNumber, result);
        result.onCompletion(() -> {
            logger.info("complete!");
        });
        result.setResultHandler(result1 -> logger.info("result:" + result1.toString()));
        logger.info("主线程结束");
        return result;
    }

    @GetMapping("/rest")
    public String resttemplate() {
        return clientTest.run();
    }

    @GetMapping("/haha")
    public void haha() {
        clientTest.sendPost();
    }
}