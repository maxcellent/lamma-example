package io.lamma.example;

import io.lamma.Date;
import io.lamma.DateRange;

import static io.lamma.LammaConversion.*;

/**
 * http://stackoverflow.com/questions/2689379/how-to-get-a-list-of-dates-between-two-dates-in-java
 */
public class StackOverflow2689379 {

    public static void main(String [] args) {
        Date fromDate = date(2014, 6, 29);
        Date toDate = date(2014, 7, 1);
        DateRange range = fromDate.to(toDate);

//        output:
//        Date(2014,6,29)
//        Date(2014,6,30)
//        Date(2014,7,1)

        for (Date d: range.javaIterable()) {
            System.out.println(d);
        }
    }

}
