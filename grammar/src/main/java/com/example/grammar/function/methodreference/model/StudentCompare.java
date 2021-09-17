package com.example.grammar.function.methodreference.model;

/**
 * StudentCompare
 *
 * @author fengna
 * @date 2019/3/26
 */
public class StudentCompare {

    public int compareByName(Student a, Student b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }

    public int compareByScore(Student a, Student b) {
        return a.getScore() - b.getScore();
    }
}
