package cn.whu.microservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("query-service")
public interface ServerApi {

    @GetMapping("/name")
    String getRibbonServer(@RequestParam("requestMsg") String requestMsg);

    @PostMapping("/name")
    Map postRibbonServer(@RequestBody Map requestMsg);

}
