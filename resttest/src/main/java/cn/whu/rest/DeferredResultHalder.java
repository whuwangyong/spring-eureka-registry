package cn.whu.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author WangYong
 * @Date 2019/11/08
 * @Time 18:56
 */
@Component
public class DeferredResultHalder {
    private Map<String, DeferredResult<Person>> map=new HashMap<>();

    public Map<String, DeferredResult<Person>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<Person>> map) {
        this.map = map;
    }
}