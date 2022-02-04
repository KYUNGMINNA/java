package chapter10;

import java.time.*;
import java.time.temporal.*;

public class ch10_23 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, 12, 31);
        LocalTime time = LocalTime.of(12,34,56);

        LocalDateTime dt  = LocalDateTime.of(date, time);

        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dt.atZone(zid);


        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId nyId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);


        OffsetDateTime odt = zdt.toOffsetDateTime();

        System.out.println(dt);
        System.out.println(zid);
        System.out.println(zdt);
        System.out.println(seoulTime);
        System.out.println(nyTime);
        System.out.println(odt);
    }
}