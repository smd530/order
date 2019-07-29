package com.smd.order.repository;

import com.smd.order.OrderApplicationTests;
import com.smd.order.bean.OrderMaster;
import com.smd.order.enums.OrderStatusEnum;
import com.smd.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("吴彦祖");
        orderMaster.setBuyerPhone("17710554925");
        orderMaster.setBuyerAddress("字节跳动总部");
        orderMaster.setBuyerOpenid("123456789");
        orderMaster.setOrderAmount(new BigDecimal("20"));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}