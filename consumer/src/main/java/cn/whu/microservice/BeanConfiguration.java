package cn.whu.microservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }
}
