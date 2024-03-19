package com.example.springboot1.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author wjw
 * @Date 2023/12/5 22:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffPublicVO {
    private String name;
    private int age;
    private String extra;
}
