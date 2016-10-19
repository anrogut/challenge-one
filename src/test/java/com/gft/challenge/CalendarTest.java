package com.gft.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalendarTest {

    private Iterator iterator;
    private Calendar calendar;

    @Before
    public void setUp() {
        calendar = new Calendar(LocalDate.of(2016, 9, 19));
        iterator = calendar.iterator();
    }

    @Test
    public void hasNextShouldReturnTrueWhenStartDateNotNull() {
        iterator = calendar.iterator();
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
        List<LocalDate> correctDates = Arrays.asList(
                LocalDate.of(2016,9,20),
                LocalDate.of(2016,9,23),
                LocalDate.of(2016,9,27),
                LocalDate.of(2016,9,30)
        );
        for(LocalDate localDate : correctDates) {
            assertThat(localDate).isEqualTo(iterator.next());
        }
    }

    @Test
    public void shouldThrowUnsupportedOperationException() {
        assertThatThrownBy(() -> iterator.remove())
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Not able to remove date");
    }
}
