package com.gft.challenge;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;


class Calendar implements Iterable<LocalDate> {

    private LocalDate startDate;

    Calendar(LocalDate startDate) {
        this.startDate = startDate;
        if(this.startDate == null) {
            this.startDate = LocalDate.now();
        }
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new CalendarIterator(startDate);
    }

    @Override
    public void forEach(Consumer<? super LocalDate> action) {
        for (LocalDate localDate : this) {
            action.accept(localDate);
        }
    }

    @Override
    public Spliterator<LocalDate> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(),0);
    }

    private class CalendarIterator implements Iterator<LocalDate> {

        private static final int DAY_DIFF_BETWEEN_FRIDAY_AND_TUESDAY = 4;
        private static final int DAY_DIFF_BETWEEN_TUESDAY_AND_FRIDAY = 3;

        private LocalDate currentDate;

        CalendarIterator(LocalDate startDate) {
            currentDate = startDate;
            while(currentDate.getDayOfWeek() != DayOfWeek.TUESDAY && currentDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(1);
            }
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public LocalDate next() {
            LocalDate toReturn = currentDate;
            if(currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(DAY_DIFF_BETWEEN_FRIDAY_AND_TUESDAY);
            } else {
                currentDate = currentDate.plusDays(DAY_DIFF_BETWEEN_TUESDAY_AND_FRIDAY);
            }
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not able to remove date");
        }
    }
}
