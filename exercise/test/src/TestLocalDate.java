import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

public class TestLocalDate {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy";
        String dateTimePattern = "dd/MM/yyyy HH:mm:ss";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);

        System.out.println("Lỗi đây: ");
        try {
            LocalDate d = LocalDate.parse("29/07/19912", formatter);
            System.out.println(d);
            String str = d.format(formatter);
            System.out.println(str);
        } catch (DateTimeParseException e) {
            System.out.println("Mới bắt lỗi trên xong");
        }




        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate date = LocalDate.now();


        LocalDateTime dateTime1 = LocalDateTime.parse("2023-07-08T15:07:01.305");
        System.out.println("========================");
        System.out.println(dateTime1);

        System.out.println("========================");

        String dateTimeString = dateTime.format(dateTimeFormatter);

        System.out.println(dateTimeString);


    }


}
