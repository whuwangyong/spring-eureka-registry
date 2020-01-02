package cn.whu.microservice.feign;

import cn.whu.microservice.bean.Student;
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
    Map postRibbonServer(@RequestBody Map<String,String> requestMsg);

    @PostMapping("/student/{city}/{school}")
    String addStudent(@RequestParam("city") String city, @RequestParam("school") String school, @RequestBody Student student);

    @GetMapping("/student/query")
    String queryStudent(@RequestParam("sno") String sno);

}
