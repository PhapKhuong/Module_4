import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TestLocalDate {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy";
        String dateTimePattern = "dd/MM/yyyy HH:mm:ss";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);

        LocalDate d = LocalDate.parse("29/07/1991", formatter);


        System.out.println(d);

        String str =  d.format(formatter);

        System.out.println(str);

        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();

        Calendar dd = Calendar.n


        LocalDateTime dateTime1 = LocalDateTime.parse("2023-07-08T15:07:01.305");
        System.out.println("========================");
        System.out.println(dateTime1);

        System.out.println("========================");

        String dateTimeString = dateTime.format(dateTimeFormatter);

        System.out.println(dateTimeString);


    }


}
