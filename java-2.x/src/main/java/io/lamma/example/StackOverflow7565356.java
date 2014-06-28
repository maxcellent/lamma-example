package io.lamma.example;

import io.lamma.Date;

/**
 * http://stackoverflow.com/questions/7565356/get-first-monday-after-certain-date
 */
public class StackOverflow7565356 {

    public static void main(String [] arg) {
        System.out.println(new Date(2014, 6, 27).comingMonday());   // Date(2014,6,30)
    }
}
