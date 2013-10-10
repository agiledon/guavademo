package com.agiledon.guava;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class OptionalDemo {
    public List<String> getMessages(boolean isEmpty) {
        if (isEmpty) {
            return null;
        }

        List<String> messages = newArrayList(
            "first",
            "second",
            "third"
        );
        return messages;
    }
}
