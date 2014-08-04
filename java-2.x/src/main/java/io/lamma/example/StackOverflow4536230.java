package io.lamma.example;

import io.lamma.Date;
import io.lamma.DayOfWeek;

/**
 * http://stackoverflow.com/questions/4536230/how-to-get-the-past-sunday-and-the-coming-sunday-in-java
 */
public class StackOverflow4536230 {

    public static void main(String [] args) {
        Date today = new Date(2014, 7, 1);      // assume today is 2014-07-01
        Date previousSunday = today.previousOrSame(DayOfWeek.SUNDAY);   // 2014-06-29
        Date nextSunday = today.next(DayOfWeek.SUNDAY);                 // 2014-07-06

        System.out.println(previousSunday);
        System.out.println(nextSunday);
    }
}
