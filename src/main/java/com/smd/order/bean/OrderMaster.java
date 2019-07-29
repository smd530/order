package com.smd.order.bean;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderMaster {

    @Id
    private String orderId;

    /**
     * 买家名
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家openId
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态 默认0为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态 默认0为未支付
     */
    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

}
