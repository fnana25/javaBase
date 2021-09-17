package com.example.grammar.stream.model;

import lombok.Builder;
import lombok.Data;

/**
 * Student
 *
 * @author fengna
 * @date 2019/3/29
 */
@Data
@Builder
public class Student {

    private String name;

    private int score;

    private int age;
}
