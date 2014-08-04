package io.lamma.example;

import io.lamma.Date;
import io.lamma.DayOfWeek;

/**
 * http://stackoverflow.com/questions/12283794/determinining-the-date-of-a-particular-day-of-week
 */
public class StackOverflow12283794 {

    public static void main(String [] args) {
        new Date(2014, 7, 1).previous(DayOfWeek.FRIDAY); // 2014-06-27
        new Date(2014, 7, 2).previous(DayOfWeek.FRIDAY); // 2014-06-27
        new Date(2014, 7, 3).previous(DayOfWeek.FRIDAY); // 2014-06-27
        new Date(2014, 7, 4).previous(DayOfWeek.FRIDAY); // 2014-06-27
        new Date(2014, 7, 5).previous(DayOfWeek.FRIDAY); // 2014-07-04
        new Date(2014, 7, 6).previous(DayOfWeek.FRIDAY); // 2014-07-04
        new Date(2014, 7, 7).previous(DayOfWeek.FRIDAY); // 2014-07-04

        System.out.println(new Date(2014, 7, 1).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 2).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 3).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 4).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 5).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 6).previous(DayOfWeek.FRIDAY));
        System.out.println(new Date(2014, 7, 7).previous(DayOfWeek.FRIDAY));
    }
}
