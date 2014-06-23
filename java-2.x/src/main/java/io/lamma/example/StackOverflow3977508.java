package io.lamma.example;

import io.lamma.Dates;

/**
 * http://stackoverflow.com/questions/3977508/recurring-event-logic
 */
public class StackOverflow3977508 {

    public static void main(String [] args) {

        // monthly on a date of the month that corresponds to the start date
        // output: [Date(2014,6,10), Date(2014,7,10), Date(2014,8,10), Date(2014,9,10), Date(2014,10,10)]
        System.out.println(Dates.from(2014, 6, 10).to(2014, 10, 10).byMonth().build());

        // weekly on a day of the week of that corresponds to the start date
        // output: [Date(2014,6,10), Date(2014,6,17), Date(2014,6,24), Date(2014,7,1), Date(2014,7,8)]
        System.out.println(Dates.from(2014, 6, 10).to(2014, 7, 10).byWeek().build());

        // every 2 weeks on a day of the week of that corresponds to the start date
        // output: [Date(2014,6,10), Date(2014,6,24), Date(2014,7,8)]
        System.out.println(Dates.from(2014, 6, 10).to(2014, 7, 10).byWeeks(2).build());

        // edge cases are handled properly, for example, leap day
        // output: [Date(2012,2,29), Date(2013,2,28), Date(2014,2,28), Date(2015,2,28), Date(2016,2,29)]
        System.out.println(Dates.from(2012, 2, 29).to(2016, 2, 29).byYear().build());
    }
}
