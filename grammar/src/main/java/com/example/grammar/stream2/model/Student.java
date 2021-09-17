package com.example.grammar.stream2.model;

import lombok.Builder;
import lombok.Data;

/**
 * Student
 *
 * @author fengna
 * @date 19/4/1 20:33
 */
@Data
@Builder
public class Student implements Comparable<Student>{

    private String  name;
    private int score;
    private Boolean flag;

    @Override
    public int compareTo(Student o) {
            return this.score - o.getScore();
    }
}
