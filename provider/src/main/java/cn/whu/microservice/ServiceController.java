package cn.whu.microservice;

import cn.whu.microservice.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ServiceController {


    @Autowired
    HttpServletRequest request;


    /***
     * 在浏览器访问 http://127.0.0.1:8910/name?requestMsg=wang
     * @param requestMsg
     * @return
     */
    @GetMapping("/name")
    public String getRibbonServer(@RequestParam("requestMsg") String requestMsg) {
        return requestMsg + "\nI am query service.";
    }

    @PostMapping("/name")
    public Map postRibbonServer(@RequestBody Map<String, String> requestMsg) {
        Map<String, String> map = new HashMap<>();
//        requestMsg.forEach((k,v)->map.put(k,v));
        requestMsg.forEach(map::put);
        return map;
    }

    @PostMapping("/student/{city}/{school}")
    String addStudent(@PathVariable("city") String city, @PathVariable("school") int school, Student student) {
        log.info(request.getRequestURL().toString());
        String s = city.toUpperCase() + "," + school + "|" + student.toString();
        return s;
    }
}
