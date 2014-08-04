package io.lamma.example;

import io.lamma.Date;
import io.lamma.DayOfWeek;

/**
 * http://stackoverflow.com/questions/11631588/java-check-if-date-is-next-sunday
 */
public class StackOverflow11631588 {

    public static void main(String [] args) {
        Date today = new Date(2014, 7, 1);  // assume today is 2014-07-01
        Date nextSunday = today.next(DayOfWeek.SUNDAY);     // 2014-07-06
    }
}
