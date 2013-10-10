package com.agiledon.guava;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class PersonComparison implements Comparable<PersonComparison> {
    private String name;
    private int age;
    private Gender gender;

    public PersonComparison(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int compareTo(PersonComparison that) {
        return ComparisonChain.start()
                .compare(this.name, that.name)
                .compare(this.age, that.age)
                .compare(this.gender, that.gender, Ordering.natural().nullsLast())
                .result();
    }

    public enum Gender {
        Male, Female
    }
}
