package com.gft.challenge;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;

public class CalendarTest {

    private Iterator iterator;

    @Before
    public void setup() {
        Calendar calendar = new Calendar(LocalDate.of(2016, 9, 19));
        iterator = calendar.iterator();
    }

    @Test
    public void hasNextShouldReturnTrueWhenStartDateNotNull() {
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    public void hasNextShouldReturnFalseWhenStartDateIsNull() {
        Calendar localCalendar = new Calendar(null);
        Iterator localIterator = localCalendar.iterator();
        assertThat(localIterator.hasNext()).isFalse();
    }

    @Test
    public void shouldBeAbleToIterateOverFewMondaysAndFridays() {
        assertThat(iterator.next()).isEqualTo(LocalDate.of(2016,9,20));
        assertThat(iterator.next()).isEqualTo(LocalDate.of(2016,9,23));
        assertThat(iterator.next()).isEqualTo(LocalDate.of(2016,9,27));
        assertThat(iterator.next()).isEqualTo(LocalDate.of(2016,9,30));
    }
}
