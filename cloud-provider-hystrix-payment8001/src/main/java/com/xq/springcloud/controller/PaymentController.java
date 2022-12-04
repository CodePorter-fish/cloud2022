package com.xq.springcloud.controller;

import com.xq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/provider/hystrix/ok/get/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_ok(id);
        log.info(result);
        return result;
    }
    @GetMapping("/provider/hystrix/timeout/get/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        String result = paymentService.paymentInfo_timeout(id);
        log.info(result);
        return result;
    }
}
