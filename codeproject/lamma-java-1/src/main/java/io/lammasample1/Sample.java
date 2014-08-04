package io.lammasample1;

// common Java helper to interop java code with Lamma's scala code
// it is recommended to always add this one when using Lamma
import static io.lamma.LammaJavaImports.*;

import io.lamma.Date;
import io.lamma.DayOfWeek;

/**
 * run with following mvn command under root dir (the one with pom.xml file):
 *      mvn exec:java -Dexec.mainClass="io.lammasample1.Sample"
 */
public class Sample {

    public static void main(String [] args) {
        System.out.println("import static io.lamma.LammaJavaImports.*;");
        System.out.println();
        System.out.println("import io.lamma.Date;");
        System.out.println("import io.lamma.DayOfWeek;");
        System.out.println();

        /**
         * date creation: following three forms are interchangeable
         */
        println("new Date(2014, 5, 5)", new Date(2014, 5, 5));  // create with constructor
        println("date(2014, 10, 7)", date(2014, 10, 7));        // create with helper method
        println("date(\"2014-10-07\")", date("2014-10-07"));    // create with ISO 8601

        /**
         * compare dates
         *
         * similarly for: isAfter, isOnOrBefore and isOnOrAfter
         */
        println("date(2014, 7, 7).isBefore(date(2014, 7, 8))", date(2014, 7, 7).isBefore(date(2014, 7, 8)));

        /**
         * day operations
         */
        println("date(2016, 3, 3).minus(date(2016, 2, 25))", date(2016, 3, 3).minus(date(2016, 2, 25))); // calculate date difference, leap day (2016-02-29) is considered
        println("date(2016, 2, 29).plusDays(5)",    date(2016, 2, 29).plusDays(5));
        println("date(2016, 2, 29).minusDays(5)",   date(2016, 2, 29).minusDays(5));

        /**
         * week operations
         */
        println("date(2014, 7, 7).is(DayOfWeek.MONDAY)",                date(2014, 7, 7).is(DayOfWeek.MONDAY));
        println("date(2014, 7, 7).next(DayOfWeek.MONDAY)",              date(2014, 7, 7).next(DayOfWeek.MONDAY));
        println("date(2014, 7, 7).previous(DayOfWeek.MONDAY)",          date(2014, 7, 7).previous(DayOfWeek.MONDAY));
        println("date(2014, 7, 7).nextOrSame(DayOfWeek.MONDAY)",        date(2014, 7, 7).nextOrSame(DayOfWeek.MONDAY));
        println("date(2014, 7, 7).previousOrSame(DayOfWeek.WEDNESDAY)", date(2014, 7, 7).previousOrSame(DayOfWeek.WEDNESDAY));

        println("date(2014, 7, 7).daysOfWeek4j()",                      date(2014, 7, 7).daysOfWeek4j());                   // an iterable containing all days of current week, starting from Monday
        println("date(2014, 7, 7).withDayOfWeek(DayOfWeek.MONDAY)",     date(2014, 7, 7).withDayOfWeek(DayOfWeek.MONDAY));  // with Monday of current week
        println("date(2014, 7, 7).withDayOfWeek(DayOfWeek.SUNDAY)",     date(2014, 7, 7).withDayOfWeek(DayOfWeek.SUNDAY));  // with Sunday of current week

        println("date(2016, 2, 29).plusWeeks(2)",   date(2016, 2, 29).plusWeeks(2));
        println("date(2016, 2, 29).minusWeeks(3)",  date(2016, 2, 29).minusWeeks(3));

        /**
         * month operations
         */
        println("date(2014, 7, 7).daysOfMonth4j()",         date(2014, 7, 7).daysOfMonth4j());          // an iterable containing all days of current month
        println("date(2016, 2, 5).maxDayOfMonth()",         date(2016, 2, 5).maxDayOfMonth());          // => 29
        println("date(2016, 2, 5).lastDayOfMonth()",        date(2016, 2, 5).lastDayOfMonth());         // => Date(2016,2,29)
        println("date(2016, 2, 5).sameWeekdaysOfMonth4j()", date(2016, 2, 5).sameWeekdaysOfMonth4j());  // all Fridays in Feb, 2016

        println("date(2016, 1, 31).plusMonths(3)",  date(2016, 1, 31).plusMonths(3));   // Date(2016,4,30), Note how month end is handled
        println("date(2016, 1, 10).minusMonths(5)", date(2016, 1, 10).minusMonths(5));

        /**
         * year operations
         */
        println("date(2016, 2, 5).maxDayOfYear()",          date(2016, 2, 5).maxDayOfYear());           // max day of year
        println("date(2016, 2, 5).dayOfYear()",             date(2016, 2, 5).dayOfYear());              // an iterable containing all days of current year
        println("date(2016, 2, 5).daysOfYear4j()",          date(2016, 2, 5).daysOfYear4j());           // an iterable containing all days of current year
        println("date(2016, 2, 5).sameWeekdaysOfYear4j()",  date(2016, 2, 5).sameWeekdaysOfYear4j());   // all Fridays in 2016

        println("date(2016, 2, 29).plusYears(3)",   date(2016, 2, 29).plusYears(3));
        println("date(2016, 2, 29).minusYears(2)",  date(2016, 2, 29).minusYears(2));   // Date(2014,2,28), Note how leap year is handled
    }

    public static void println(String script, Object r) {
        System.out.println(script + " => " + r);
    }
}
