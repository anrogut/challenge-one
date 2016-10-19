package com.gft.challenge;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


class Calendar implements Iterable<LocalDate> {

    private LocalDate startDate;

    Calendar(LocalDate startDate) {
        this.startDate = startDate;
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
        return null;
    }

    private class CalendarIterator implements Iterator<LocalDate> {

        private LocalDate currentDate;

        CalendarIterator(LocalDate startDate) {
            currentDate = startDate;
        }


        @Override
        public boolean hasNext() {
            return currentDate != null;
        }

        @Override
        public LocalDate next() {
            while(currentDate.getDayOfWeek() != DayOfWeek.TUESDAY && currentDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
                currentDate = currentDate.plusDays(1);
            }
            LocalDate toReturn = currentDate;
            currentDate = currentDate.plusDays(1);
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not able to remove date");
        }
    }
}
