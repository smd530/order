package com.smd.order.enums;

import lombok.Getter;

/**
 * @Description: 返回结果枚举类
 *
 * @Author: shanmingda
 * @Date: 2019-07-29 17:53
*/

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
