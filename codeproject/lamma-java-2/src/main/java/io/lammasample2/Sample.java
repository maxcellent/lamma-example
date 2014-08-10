package io.lammasample2;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import io.lamma.Date;
import io.lamma.Dates;
import io.lamma.DayOfWeek;
import io.lamma.HolidayRule;
import io.lamma.HolidayRules;

import java.util.List;

/**
 * run with following mvn command under root dir (the one with pom.xml file):
 *      mvn compile exec:java -Dexec.mainClass="io.lammasample2.Sample"
 */
public class Sample {

    public static void main(String [] args) {
        /**
         * Date generation
         */
        println("Dates.from(new Date(2014, 5, 10)).to(new Date(2014, 5, 12)).build()", Dates.from(new Date(2014, 5, 10)).to(new Date(2014, 5, 12)).build());

        List<Date> dates = Dates.from(new Date(2014, 5, 10)).to(new Date(2014, 5, 12)).build();
        for (Date date: dates) {
            System.out.println(date);
        }

        println("Dates.from(2014, 5, 10).to(2014, 5, 12).build()", Dates.from(2014, 5, 10).to(2014, 5, 12).build());

        /**
         * generate dates by different step
         */
        println("Dates.from(2014, 5, 10).to(2014, 5, 15).by(2).build()", Dates.from(2014, 5, 10).to(2014, 5, 15).by(2).build());
        println("Dates.from(\"2014-05-20\").to(\"2014-05-15\").by(-2).build()", Dates.from("2014-05-20").to("2014-05-15").by(-2).build());

        /**
         * by week
         */
        println("Dates.from(2014, 5, 10).to(2014, 5, 24).byWeek().build()", Dates.from(2014, 5, 10).to(2014, 5, 24).byWeek().build());
        println("Dates.from(2014, 5, 10).to(2014, 5, 24).byWeeks(2).build()", Dates.from(2014, 5, 10).to(2014, 5, 24).byWeeks(2).build());

        /**
         * by month
         */
        println("Dates.from(2014, 5, 10).to(2014, 7, 10).byMonth().build()", Dates.from(2014, 5, 10).to(2014, 7, 10).byMonth().build());
        println("Dates.from(2014, 1, 31).to(2014, 4, 30).byMonth().build()", Dates.from(2014, 1, 31).to(2014, 4, 30).byMonth().build());
        println("Dates.from(2014, 5, 10).to(2014, 11, 10).byMonths(3).build()", Dates.from(2014, 5, 10).to(2014, 11, 10).byMonths(3).build());

        /**
         * by year
         */
        println("Dates.from(2014, 5, 10).to(2016, 5, 10).byYear().build()", Dates.from(2014, 5, 10).to(2016, 5, 10).byYear().build());
        println("Dates.from(2012, 2, 29).to(2016, 2, 29).byYear().build()", Dates.from(2012, 2, 29).to(2016, 2, 29).byYear().build());
        println("Dates.from(2012, 2, 29).to(2016, 2, 29).byYears(2).build()", Dates.from(2012, 2, 29).to(2016, 2, 29).byYears(2).build());

        /**
         * filter out weekends with guava
         */
        List<Date> result = Dates.from(2014, 10, 10).to(2014, 10, 15).build();
        Predicate<Date> weekdays = new Predicate<Date>() {
            @Override
            public boolean apply(Date d) {
                return ! d.is(DayOfWeek.SATURDAY) && ! d.is(DayOfWeek.SUNDAY) ;
            }
        };
        println("Iterables.filter(result, weekdays)", Iterables.filter(result, weekdays));

        /**
         * filter out weekends with Lamma's HolidayRule
         */
        println("Dates.from(2014, 10, 10).to(2014, 10, 15).except(HolidayRules.weekends()).build()", Dates.from(2014, 10, 10).to(2014, 10, 15).except(HolidayRules.weekends()).build());

        /**
         * filter out both weekends and holidays
         */
        HolidayRule ukHoliday2015 = HolidayRules.simpleRule(
                new Date(2015, 1, 1), new Date(2015, 4, 3), new Date(2015, 4, 6),
                new Date(2015, 5, 4), new Date(2015, 5, 25), new Date(2015, 8, 31),
                new Date(2015, 12, 25), new Date(2015, 12, 28)
        );

        // these two styles are identical

        // Style 1
        println("Dates.from(2015, 12, 23).to(2015, 12, 30).except(HolidayRules.weekends()).except(ukHoliday2015).build()", Dates.from(2015, 12, 23).to(2015, 12, 30).except(HolidayRules.weekends()).except(ukHoliday2015).build());

        // Style 2
        println("Dates.from(2015, 12, 23).to(2015, 12, 30).except(HolidayRules.weekends().and(ukHoliday2015)).build()", Dates.from(2015, 12, 23).to(2015, 12, 30).except(HolidayRules.weekends().and(ukHoliday2015)).build());
    }

    public static void println(String script, Object r) {
        System.out.println(script + "; // => " + r);
    }
}
