package com.smd.order.util;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     *
     * 简单使用 生产环境不可用
     */

    public static synchronized String genUniueKey() {

        Random random = new Random();
        Integer number = random.nextInt(90000) + 10000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
