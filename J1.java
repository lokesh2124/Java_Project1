# Java_Project1

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {

    public static void main(String[] args) {
        // Set the input time and time zone
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId sourceTimeZone = ZoneId.of("America/New_York");

        // Convert the time to a different time zone
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceTimeZone);
        ZoneId targetTimeZone = ZoneId.of("Asia/Tokyo");
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetTimeZone);

        // Format the output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sourceTime = sourceZonedDateTime.format(formatter);
        String targetTime = targetZonedDateTime.format(formatter);

        // Print the results
        System.out.println("Source time in New York: " + sourceTime);
        System.out.println("Converted time in Tokyo: " + targetTime);
    }
}
