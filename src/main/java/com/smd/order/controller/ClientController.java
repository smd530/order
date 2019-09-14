package com.smd.order.controller;

import com.netflix.discovery.converters.Auto;
import com.smd.order.bean.ProductInfo;
import com.smd.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> list = productClient.listForOrder(Arrays.asList("164103465734242707"));
        log.info("response {}" + list);

        return "OjbK";
    }
}
