package io.lamma.example;

import io.lamma.Date;

/**
 * http://stackoverflow.com/questions/23971439/get-the-first-monday-of-a-month
 */
public class StackOverflow23971439 {

    public static void main(String [] args) {
        printFirstMonday(2014, 1);  // output = Date(2014,1,6)
        printFirstMonday(2014, 2);  // output = Date(2014,2,3)
        printFirstMonday(2014, 3);  // output = Date(2014,3,3)
        printFirstMonday(2014, 4);  // output = Date(2014,4,7)
        printFirstMonday(2014, 5);  // output = Date(2014,5,5)
        printFirstMonday(2014, 6);  // output = Date(2014,6,2)
    }

    public static void printFirstMonday(int year, int month) {
        Date firstDayOfMonth = new Date(year, month, 1);
        Date lastDayOfLastMonth = firstDayOfMonth.pastMonthEnd();
        Date firstMonday = lastDayOfLastMonth.comingMonday();
        System.out.println(firstMonday);
    }
}
