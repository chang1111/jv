package java18;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class jv18_09_LocalDateTime {
    
    public static void main(String[] args) {
        
        // 현재 날짜
        LocalDate today = LocalDate.now();
        System.out.println(today);
        // 현재 연도만 출력
        System.out.println(today.get(ChronoField.YEAR));
        // 현재 월만 출력
        System.out.println(today.get(ChronoField.MONTH_OF_YEAR));
        // 현재 일만 출력
        System.out.println(today.get(ChronoField.DAY_OF_MONTH));
        // 현재 시간 가져오기
        LocalTime curtime = LocalTime.now();
        System.out.println(curtime);
        // 현재 시간만 출력
        System.out.println(curtime.get(ChronoField.HOUR_OF_DAY));
        // 현재 분만 출력
        System.out.println(curtime.get(ChronoField.MINUTE_OF_HOUR));
        // 현재 초만 출력
        System.out.println(curtime.get(ChronoField.SECOND_OF_MINUTE));
        
        // 현재에 +3년, -4월, +2일, +4시간, -30분, +10초 더해서
        // "yyyy-MM-dd HH:mm:ss" 형태로 출력하시오
        LocalDateTime dt = LocalDateTime.now();
        dt = dt.plusYears(3);
        dt = dt.plusMonths(-4);
        dt = dt.plusDays(2);
        dt = dt.plusHours(4);
        dt = dt.plusMinutes(-30);
        dt = dt.plusSeconds(10);
        System.out.println(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
    }
    
}
