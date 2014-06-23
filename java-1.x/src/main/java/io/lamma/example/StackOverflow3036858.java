package io.lamma.example;

import io.lamma.Calendar;
import io.lamma.Date;

import static io.lamma.LammaConversion.*;

/**
 * this example resolving this question
 *
 * http://stackoverflow.com/questions/3036858/how-can-i-find-the-most-recent-month-end-date-with-joda-time
 */
public class StackOverflow3036858 {

    public static void main(String [] args) {
        // print 2014-05-30, because 2014-05-31 is holiday
        System.out.println(findDate(new Date(2014, 5, 31)));

        // print 2014-04-30
        System.out.println(findDate(new Date(2014, 5, 30)));

        // print 2014-04-30, because the most recent working day of 2014-05-25 is not the last working day of May
        System.out.println(findDate(new Date(2014, 5, 25)));
    }

    private static Calendar cal = weekendCalendar();   // let's use weekend calendar for now

    public static Date findDate(Date current) {
        if (cal.isHoliday(current)) {
            Date lastWorkingDayOfThisMonth = current.thisMonthEnd().backward(cal);
            Date mostRecentWorkingDay = current.backward(cal);
            if (lastWorkingDayOfThisMonth.equals(mostRecentWorkingDay)) {
                return mostRecentWorkingDay;
            } else {
                return lastWorkingDayOfLastMonth(current);
            }
        } else {
            return lastWorkingDayOfLastMonth(current);
        }
    }

    public static Date lastWorkingDayOfLastMonth(Date d) {
        return d.pastMonthEnd().backward(cal);
    }
}
