package cn.whu.rest;

import java.time.LocalTime;

/**
 * @Author WangYong
 * @Date 2019/11/11
 * @Time 16:18
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(LocalTime.now().toSecondOfDay()/60/60);
        System.out.println(LocalTime.of(0,0).getSecond());
        System.out.println(LocalTime.now().getSecond()-LocalTime.of(0,0).getSecond());
    }
}
