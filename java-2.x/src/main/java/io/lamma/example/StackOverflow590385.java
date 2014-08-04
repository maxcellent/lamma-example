package io.lamma.example;

import io.lamma.Date;
import io.lamma.Dates;
import io.lamma.DayOfWeek;

import java.util.List;

/**
 * http://stackoverflow.com/questions/590385/how-to-get-all-dates-of-sundays-in-a-particular-year-in-java
 */
public class StackOverflow590385 {

    public static void main(String [] args) {
        List<Date> sundays2014 = Dates.from(2014, 1, 1).to(2014, 12, 31).byWeek().on(DayOfWeek.SUNDAY).build();

        for(Date date: sundays2014) {
            System.out.println(date);
        }
    }
}
