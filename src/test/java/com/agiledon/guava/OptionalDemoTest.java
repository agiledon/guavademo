package com.agiledon.guava;

import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static com.google.common.base.Optional.fromNullable;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalDemoTest {

    private OptionalDemo optionalDemo;

    @Before
    public void setUp() throws Exception {
        optionalDemo = new OptionalDemo();
    }

    @Test
    public void handle_null_case() {
        List<String> messages = optionalDemo.getMessages(true);
        Optional optionalMessages = fromNullable(messages);
        assertThat(optionalMessages.isPresent(), is(false));
    }

    @Test
    public void handle_not_null_case() {
        List<String> messages = optionalDemo.getMessages(false);
        Optional<List<String>> optionalMessages = fromNullable(messages);
        assertThat(optionalMessages.isPresent(), is(true));
        List<String> messagesFromOptional = optionalMessages.get();
        assertThat(messagesFromOptional.size(), is(3));
    }

    @Test(expected = NullPointerException.class)
    public void should_fast_fail_if_null() {
        List<String> messages = optionalDemo.getMessages(true);
        Optional.of(messages);
    }

    @Test
    public void should_return_default_messages_given_null_object() {
        List<String> messages = optionalDemo.getMessages(true);
        List<String> defaultMessages = newArrayList("First", "Second");
        Optional<List<String>> listOptional = fromNullable(messages);
        assertThat(listOptional.or(defaultMessages).size(), is(2));
    }

    @Test
    public void should_return_real_messages_given_not_null_object() {
        List<String> messages = optionalDemo.getMessages(false);
        List<String> defaultMessages = newArrayList("First", "Second");
        Optional<List<String>> listOptional = fromNullable(messages);
        assertThat(listOptional.or(defaultMessages).size(), is(3));
    }
}
