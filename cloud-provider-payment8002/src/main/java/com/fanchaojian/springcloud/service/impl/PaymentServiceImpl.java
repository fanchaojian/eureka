package com.fanchaojian.springcloud.service.impl;

import com.fanchaojian.springcloud.dao.PaymentMapper;
import com.fanchaojian.springcloud.entity.Payment;
import com.fanchaojian.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 14:08
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper ;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment) ;
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.getPaymentById(id);
    }
}
