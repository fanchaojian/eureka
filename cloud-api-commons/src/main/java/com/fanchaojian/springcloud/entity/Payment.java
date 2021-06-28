package com.fanchaojian.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fanchaojian
 * @date 2021-6-23 - 13:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id ;
    private String serial ;
}
