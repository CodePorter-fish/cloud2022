package com.xq.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
     * fallbackMethod = "paymentInfo_timeoutHandler“ 表示当需要服务降级是需要调用方法paymentInfo_timeoutHandler
     * @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
     * 这个表示这个方法在3秒内执行结束，就正常调用这个方法，超过3s就服务降级
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeout(Long id) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeout:id" + id +  "O(∩_∩)O哈哈~";
    }

    //paymentInfo_timeout,出现超时，宕机，错误等情况调用的方法
    public String paymentInfo_timeoutHandler(Long id) {

        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_timeoutHandler:id" + id +  "o(╥﹏╥)o";
    }
}
