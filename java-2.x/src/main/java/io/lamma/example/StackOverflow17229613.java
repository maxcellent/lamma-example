package io.lamma.example;

import io.lamma.Date;
import io.lamma.DayOfWeek;

/**
 * http://stackoverflow.com/questions/17229613/getting-previous-particular-day-in-a-week
 */
public class StackOverflow17229613 {

    public static void main(String [] args) {
        Date today = new Date(2014, 7, 1);

        Date to = today.previous(DayOfWeek.FRIDAY);  // Date(2014,6,27)
        Date from = to.previous(DayOfWeek.SATURDAY); // Date(2014,6,21)

        System.out.println(from);
        System.out.println(to);
    }
}
