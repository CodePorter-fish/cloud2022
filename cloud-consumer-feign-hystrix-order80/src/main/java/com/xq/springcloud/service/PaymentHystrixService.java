package com.xq.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentHystrixService {

    @GetMapping("/provider/hystrix/ok/get/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id);

    @GetMapping("/provider/hystrix/timeout/get/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id);
}
