package io.lamma.example;

import io.lamma.Date;
import io.lamma.Dates;

import java.util.List;

import static io.lamma.LammaJavaImports.*;

/**
 * http://stackoverflow.com/questions/8040790/joda-time-all-mondays-between-two-dates
 */
public class StackOverflow8040790 {

    public static void main(String [] args) {
        List<Date> dates = Dates.from(2011, 11, 8).to(2011, 12, 30).byWeek().on(MONDAY).build();

        for(Date date: dates) {
            System.out.println(date);
        }
    }

}
