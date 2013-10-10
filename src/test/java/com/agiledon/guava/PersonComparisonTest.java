package com.agiledon.guava;

import com.google.common.base.Objects;
import org.junit.Test;

import static com.agiledon.guava.PersonComparison.Gender.Female;
import static com.agiledon.guava.PersonComparison.Gender.Male;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonComparisonTest {
    @Test
    public void should_return_negative_number_if_compare_bob_and_jack() {
        PersonComparison firstPerson = new PersonComparison("Bob", 23, Male);
        PersonComparison secondPerson = new PersonComparison("Jack", 33, Female);
        assertThat(firstPerson.compareTo(secondPerson), is(-1));
    }

    @Test
    public void should_return_positive_number_if_compare_jack_whose_age_is_greater_then_other_jack() {
        PersonComparison firstPerson = new PersonComparison("Jack", 48, Male);
        PersonComparison secondPerson = new PersonComparison("Jack", 33, Female);
        assertThat(firstPerson.compareTo(secondPerson), is(1));
    }

    @Test
    public void should_return_zero_if_compare_same_jack() {
        PersonComparison firstPerson = new PersonComparison("Jack", 33, Male);
        PersonComparison secondPerson = new PersonComparison("Jack", 33, Male);
        assertThat(firstPerson.compareTo(secondPerson), is(0));
    }

    @Test
    public void should_return_negative_number_if_the_later_has_none_gender() {
        PersonComparison firstPerson = new PersonComparison("Jack", 33, Male);
        PersonComparison secondPerson = new PersonComparison("Jack", 33, null);
        assertThat(firstPerson.compareTo(secondPerson), is(-1));
    }

    @Test
    public void should_return_true_for_same_object() {
        PersonComparison person = new PersonComparison("Jack", 33, Male);
        assertThat(Objects.equal(person, person), is(true));
    }

    @Test
    public void should_return_false_given_one_object_is_null() {
        PersonComparison person = new PersonComparison("Jack", 33, Male);
        assertThat(Objects.equal(person, null), is(false));
    }

    @Test
    public void should_return_true_given_two_null_objects() {
        assertThat(Objects.equal(null, null), is(true));
    }
}
