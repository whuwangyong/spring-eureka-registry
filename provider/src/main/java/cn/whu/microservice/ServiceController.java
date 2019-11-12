package cn.whu.microservice;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServiceController {


    @GetMapping("/name")
    public String getRibbonServer(@RequestParam("requestMsg") String requestMsg) {
        return  requestMsg + "\nI am query service.";
    }

    @PostMapping("/name")
    public Map postRibbonServer(@RequestBody Map<String,String> requestMsg){
        Map<String,String> map = new HashMap<>();
//        requestMsg.forEach((k,v)->map.put(k,v));
        requestMsg.forEach(map::put);

        return map;
    }
}
