package cn.whu.rest;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author WangYong
 * @Date 2019/11/11
 * @Time 18:32
 */
@Component
public class ClientTest {
    private static final Logger logger = LoggerFactory.getLogger(ClientTest.class);

    @Autowired
    RestTemplate restTemplate;

    public String run() {
        String res = "default";

//        DeferredResult<Person> result = restTemplate.postForObject("http://127.0.0.1:8080/deferredResult",
//                new Person("wangyong", 29), new DeferredResult<Person>().getClass());

        Person result = restTemplate.postForObject("http://127.0.0.1:8080/deferredResult",
                new Person("wangyong", 29), Person.class);
        String result2 = restTemplate.postForObject("http://127.0.0.1:8080/deferredResult",
                new Person("wangyong", 29), String.class);

        if (result != null) res = result.toString();
        logger.info("res:" + res);
        return res;
    }

    public void sendPost() {

        try {
            //创建连接
            URL url = new URL("http://127.0.0.1:8080/deferredResult");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            connection.connect();

            //POST请求
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            JSONObject user = new JSONObject();
            user.put("name", "赵云");
            user.put("age", "20");
            out.write(user.toString().getBytes("UTF-8"));
            out.flush();
            out.close();

            //读取响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println("sb:" + sb);
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
