package com.chang.demo.study.jdk8.date;

import java.time.*;
import java.util.TimeZone;

/**
 * @author: changhao
 * @time: 2019-09-09
 */
public class TestNewDate {
    public static void main(String[] args) {
//        testClock();
//        testLocal();
//        ZoneDateTime();
        testDruation();
    }

    public static void testClock(){
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());//时间，精确到纳秒
        System.out.println(clock.millis());//==System.out.println(System.currentTimeMillis());
        System.out.println(TimeZone.getDefault());
    }

    public static void testLocal(){
        Clock clock = Clock.systemUTC();
        LocalDate date= LocalDate.now();
        LocalDate dateFromClock = LocalDate.now(clock);

        System.out.println(date);
        System.out.println(dateFromClock);

        LocalTime time = LocalTime.now();
        LocalTime timeFromClock = LocalTime.now(clock);

        System.out.println(time);
        System.out.println(timeFromClock);

        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );

        System.out.println( datetime );
        System.out.println( datetimeFromClock );
    }

    public static void ZoneDateTime(){
        Clock clock = Clock.systemUTC();
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );

        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );
    }

    public static void testDruation(){
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
