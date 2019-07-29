package com.smd.order.VO;

import lombok.Data;

/**
 * @Description: http请求的最外层对象
 * 
 * @Author: shanmingda
 * @Date: 2019-07-29 19:18
*/

@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
