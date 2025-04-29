package com.only4play.havenest.framework.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    private BeanCopyUtils() {}

    // 拷贝对象属性
    public static <T> T copyBean(Object source, Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtils.copyProperties(source, t);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    // 拷贝对象列表属性
    public  static <O,T> List<T> copyBeanList(List<O> sourceList, Class<T> clazz) {
        return sourceList.stream().map(source -> copyBean(source, clazz)).collect(Collectors.toList());
    }
}
