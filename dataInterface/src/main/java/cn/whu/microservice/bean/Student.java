package cn.whu.microservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author WangYong
 * @Date 2019/12/31
 * @Time 15:40
 */
@Data
@AllArgsConstructor
public class Student {
    String name;
    //    int sno;  // 使用基本类型会报错
    Integer sno;
}
