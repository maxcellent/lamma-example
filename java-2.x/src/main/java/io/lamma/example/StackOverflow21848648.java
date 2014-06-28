package io.lamma.example;

import io.lamma.Date;
import io.lamma.Dates;

import java.util.List;

/**
 * http://stackoverflow.com/questions/21848648/date-list-increment-method-in-java
 */
public class StackOverflow21848648 {

    public static void main(String [] args) {
        createShiftDate();
    }

    public static List<Date> createShiftDate() {
        List<Date> dates = Dates.from(2013, 1, 1).to(2013, 1, 28).build();

        for (Date date: dates) {
            System.out.println(date.toISOString() + ", " + date.dayOfWeek());
        }

        return dates;
    }

}
