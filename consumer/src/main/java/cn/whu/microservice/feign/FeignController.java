package cn.whu.microservice.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Feign")
@Slf4j
public class FeignController {

    @Autowired
    ServerApi serverApi;

    @GetMapping("/RibbonServer")
    public String getRibbonServer() {

        String requestMsg = "Feign GET 请求 RibbonServer";
        String response = serverApi.getRibbonServer(requestMsg);
//        log.info("response={}", response);
        System.out.println("response={}"+ response);
        return response;
    }

    @PostMapping("/RibbonServer")
    public Map postRibbonServer1() {
        Map<String, String> map = new HashMap<>(16);
        map.put("user", "wangyong");
        map.put("age", "28");
        Map response = serverApi.postRibbonServer(map);
//        log.info("response={}", response);
        System.out.println("response="+ response);
        return response;
    }

}
