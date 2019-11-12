package cn.whu.microservice.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/RestTemplate")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String sayHello() {
        StringBuilder info = new StringBuilder();
        info.append("hello!\n");
        info.append("<a href=http://127.0.0.1/RestTemplate/get_name>get name</a>");
        return info.toString();
    }

    @RequestMapping(path = "/get_name", method = RequestMethod.GET/*params =*/)
    public String getName() {
        String serviceName = "query-service";
        String interfaceName = "name";
        String url = String.format("http://%s/%s", serviceName, interfaceName);
        return restTemplate.getForObject(url, String.class);
    }
}
