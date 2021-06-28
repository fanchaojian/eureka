package com.fanchaojian.springcloud.dao;

import com.fanchaojian.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 13:48
 */
@Mapper
public interface PaymentMapper {
    int create(Payment payment);
    Payment getPaymentById(long id) ;
}
