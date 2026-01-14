import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    
    private final DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, inputFormat);
            return date.format(outputFormat);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }
}