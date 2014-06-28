package io.lamma.example;

// always import this line when using Java, this will make our life a lot easier
import io.lamma.Date;
import io.lamma.Dates;
import io.lamma.HolidayRule;

import java.util.List;

import static io.lamma.LammaJavaImports.*;

/**
 * http://stackoverflow.com/questions/10174526/generating-appointments-date
 */
public class StackOverflow10174526 {

    public static void main(String [] args) {
        HolidayRule ukHoliday2015 = simpleHolidayRule(
                date(2015, 1, 1), date(2015, 4, 3), date(2015, 4, 6),
                date(2015, 5, 4), date(2015, 5, 25), date(2015, 8, 31),
                date(2015, 12, 25), date(2015, 12, 28)
        );

        List<Date> dates = Dates.from(2015, 12, 23).to(2015, 12, 30).byDays(2).except(weekends()).except(ukHoliday2015).build();

        for (Date date: dates) {
            System.out.println(date);
        }
    }

}
