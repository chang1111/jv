package java18;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ex18_07_Calendar {
    
    public static void main(String[] args) {
        Calendar d = Calendar.getInstance();
        
        // 현재 날짜와 시간 출력
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fo = tf.format(d.getTime());
        System.out.println(fo);
        
        // 현재 연도만 출력
        System.out.println(d.get(Calendar.YEAR));
        // 현재 월만 출력
        System.out.println(d.get(Calendar.MONTH) + 1);
        // 현재 일만 출력
        System.out.println(d.get(Calendar.DATE));
        // 현재 시간만 출력
        System.out.println(d.get(Calendar.HOUR));
        // 현재 분만 출력
        System.out.println(d.get(Calendar.MINUTE));
        // 현재 초만 출력
        System.out.println(d.get(Calendar.SECOND));
        
        // 현재에 +3년, -4월 +2일 더해서 "yyyy-MM-dd" 형태로 출력하시오
        
        // 현재에 +4시간, -30분, +10초 "HH:mm:ss" 형태로 출력하시오
    }
    
}
