import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {
    public static void main(String[] args) {
        String pattern = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate d = LocalDate.parse("29/07/1991", formatter);

        System.out.println(d);

        String str =  d.format(formatter);

        System.out.println(d);

    }


}
