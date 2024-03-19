package com.example.springboot1.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Description
 * @Author wjw
 * @Date 2023/12/5 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffVO {
    private String name;
    private Integer age;
    private BigDecimal salary;
}
