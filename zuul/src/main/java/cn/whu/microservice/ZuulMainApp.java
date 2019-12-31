package cn.whu.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 在浏览器访问 http://127.0.0.1:10086/query-service/name?requestMsg=wang
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulMainApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMainApp.class,args);
    }
}
