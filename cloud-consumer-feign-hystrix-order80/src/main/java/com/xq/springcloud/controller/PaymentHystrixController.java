package com.xq.springcloud.controller;

import com.xq.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/provider/hystrix/ok/get/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        log.info(result);
        return result;
    }

    @GetMapping("/consumer/provider/hystrix/timeout/get/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        String result = paymentHystrixService.paymentInfo_timeout(id);
        log.info(result);
        return result;
    }
}
