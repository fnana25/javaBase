package com.example.grammar.function.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Company
 *
 * @author fengna
 * @date 2019/3/26
 */
@Data
@Builder
public class Company {

    private String name;

    private List<Employee> employees;
}
