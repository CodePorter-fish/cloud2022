package com.xq.springcloud.service.impl;

import com.xq.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_ok(Long id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok:id" + id +  "O(∩_∩)O哈哈~";
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_timeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeout:id" + id +  "O(∩_∩)O哈哈~";
    }
}
