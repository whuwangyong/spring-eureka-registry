package cn.whu.microservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {


    @RequestMapping("/name")
    public String getName() {
        return "I am query service";
    }
}
