package io.lamma.example;

import io.lamma.Date;
import io.lamma.Dates;

/**
 * http://stackoverflow.com/questions/2689379/how-to-get-a-list-of-dates-between-two-dates-in-java
 */
public class StackOverflow2689379 {

    public static void main(String [] args) {
//        output:
//        Date(2014,6,29)
//        Date(2014,6,30)
//        Date(2014,7,1)

        for (Date d: Dates.from(2014, 6, 29).to(2014, 7, 1).build()) {
            System.out.println(d);
        }
    }

}
