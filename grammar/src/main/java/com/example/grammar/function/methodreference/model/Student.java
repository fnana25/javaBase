package com.example.grammar.function.methodreference.model;

import lombok.Builder;
import lombok.Data;

/**
 * Student
 *
 * @author fengna
 * @date 2019/3/26
 */
@Data
@Builder
public class Student {

    private int id;

    private String name;

    private int score;

    public static int staticCompareByName(Student a, Student b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }

    public static int staticCompareByScore(Student a, Student b) {
        return b.getScore() - a.getScore();
    }

    public int compareByName(Student a) {
        return this.getName().compareToIgnoreCase(a.getName());
    }

    public int compareByScore(Student a) {
        return this.getScore() - a.getScore();
    }

    @Override
    public String toString() {
        return "" + this.id;
    }
}
