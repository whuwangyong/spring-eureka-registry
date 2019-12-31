package cn.whu.rest;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

/**
 * @Author WangYong
 * @Date 2019/11/11
 * @Time 16:18
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
//        Gson gson = new Gson();
//        Person wang = new Person("wangyong", 28);
//        String json = gson.toJson(wang);
//        Object p1 = gson.fromJson(json, Person.class);
//        Class clazz = Class.forName(Person.class.getName());
//        Object p2 = gson.fromJson(json, clazz);
//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(wang.getClass()==Person.class);

//        Person wang = new Person("wangyong", 28);
//        People yong = new People();
//        BeanUtils.copyProperties(wang,yong);
//        System.out.println(yong);

//        System.out.println(BizType.BANK_OPEN.name());
//        System.out.println(BizType.BANK_OPEN);
//        System.out.println(BizType.BANK_OPEN.getType());
//        System.out.println(BizType.values());

        People wang = new People("wangyong", 28);
        System.out.println(wang.getClass().getAnnotation(MsgNo.class).value());


    }
}
