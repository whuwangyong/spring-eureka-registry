package cn.whu.rest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author WangYong
 * @Date 2019/12/04
 * @Time 16:42
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MsgNo {
    int value() default 0;
}
