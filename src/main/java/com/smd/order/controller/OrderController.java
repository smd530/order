package com.smd.order.controller;

import com.smd.order.VO.ResultVO;
import com.smd.order.converter.OrderForm2OrderDTOConverter;
import com.smd.order.dto.OrderDTO;
import com.smd.order.enums.ResultEnum;
import com.smd.order.exception.OrderException;
import com.smd.order.form.OrderForm;
import com.smd.order.service.OrderService;
import com.smd.order.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> createOrder(@Valid OrderForm orderForm,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm{}", orderForm);
            throw new OrderException(bindingResult.getFieldError().getDefaultMessage(),
                    ResultEnum.PARAM_ERROR.getCode());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        ResultVO resultVO = ResultVOUtil.success(map);
        return resultVO;
    }
}
