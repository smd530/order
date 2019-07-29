package com.smd.order.dto;

import com.smd.order.bean.OrderDetail;
import lombok.Data;
import org.hibernate.criterion.Order;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

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

    private List<OrderDetail> orderDetailList;
}
