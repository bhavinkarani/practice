package nl.ing.api.cash.order.temp;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateDiff {
    public static void main(String[] args) {
        //24-May-2017, change this to your desired Start Date
        LocalDate dateBefore = LocalDate.of(2017, Month.MAY, 24);
        //29-July-2017, change this to your desired End Date
        LocalDate dateAfter = LocalDate.of(2017, Month.JULY, 29);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateAfter, dateBefore);
        System.out.println(noOfDaysBetween);
    }
}

