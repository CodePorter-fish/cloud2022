package com.xq.springcloud.service;

public interface PaymentService {
    public String paymentInfo_ok(Long id);
    public String paymentInfo_timeout(Long id);
}
