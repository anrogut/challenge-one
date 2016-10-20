package com.gft.challenge;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Spliterator;

import static org.assertj.core.api.Assertions.assertThat;

public class CalendarTest {

    private static final String DATE_STRING = "2016-09-19";
    private Calendar calendar;

    @Before
    public void setUp() {
        calendar = new Calendar(LocalDate.parse(DATE_STRING));
    }

    @Test
    public void spliteratorShouldNotBeNull() {
        assertThat(calendar.spliterator()).isNotNull();
    }

    @Test
    public void spliteratorIsInstanceOfSpliteratorClass() {
        assertThat(calendar.spliterator()).isInstanceOf(Spliterator.class);
        assertThat(calendar.spliterator().estimateSize()).isEqualTo(Long.MAX_VALUE);
    }

}
