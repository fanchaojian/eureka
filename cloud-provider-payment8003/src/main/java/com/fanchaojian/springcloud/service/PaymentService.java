package com.fanchaojian.springcloud.service;

import com.fanchaojian.springcloud.entity.Payment;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 14:07
 */

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(long id) ;
}
