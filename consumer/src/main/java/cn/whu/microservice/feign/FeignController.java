package cn.whu.microservice.feign;

import cn.whu.microservice.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Map postRibbonServer() {
        Map<String, String> map = new HashMap<>(16);
        map.put("user", "wangyong");
        map.put("age", "28");
        Map response = serverApi.postRibbonServer(map);
//        log.info("response={}", response);
        System.out.println("response="+ response);
        return response;
    }

    @GetMapping("/test")
    public String addStudent() {
        String response = serverApi.addStudent("ShenZhen", "福外高中", new Student("aaaa", 111));
        System.out.println("response="+ response);
        return response;
    }

    //请求url：http://127.0.0.1/Feign/query?sno=110
    //或 http://127.0.0.1/Feign/query，或使用默认值sno=0000
    @GetMapping("/query")
    public String queryStudent(@RequestParam(value = "sno", defaultValue = "0000") String sno) {
        log.info("sno:" + sno);
        String response = serverApi.queryStudent(sno);
        log.info("response=" + response);
        return response;
    }

}
