package cn.whu.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String sayHello() {
        StringBuilder info = new StringBuilder();
        info.append("hello!\n");
        info.append("<a href=http://127.0.0.1/get_name>get name</a>");
        return info.toString();
    }

    @RequestMapping("/get_name")
    public String getName() {
        String serviceName = "query-service";
        String interfaceName = "name";
        String url = String.format("http://%s/%s", serviceName, interfaceName);
        return restTemplate.getForObject(url, String.class);
    }
}
