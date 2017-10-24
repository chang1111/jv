package java18;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ex18_05_Date {
    
    public static void main(String[] args) {
        // 현재 날짜와 시간 출력
        Date date = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fo = tf.format(date);
        System.out.println(fo);
        // 현재 연도만 출력
        System.out.println(date.getYear() + 1900 + "년");
        // 현재 월만 출력
        System.out.println(date.getMonth() + 1 + "월");
        // 현재 일만 출력
        System.out.println(date.getDate() + "일");
        // 현재 시간만 출력
        System.out.println(date.getHours() + "시");
        // 현재 분만 출력
        System.out.println(date.getMinutes() + "분");
        // 현재 초만 출력
        System.out.println(date.getSeconds() + "초");
        
        // 현재에 +3년, -4월, +2일 더해서 출력하시오
        date.setYear(date.getYear() + 3);
        date.setMonth(date.getMonth() - 4);
        date.setDate(date.getDate() + 2);
        tf = new SimpleDateFormat("yyyy-MM-dd");
        fo = tf.format(date);
        System.out.println(fo);
        
        // 현재에 +4시간, -30분, +10초 더해서 출력하시오
        date.setHours(date.getHours() + 4);
        date.setMinutes(date.getMinutes() - 30);
        date.setSeconds(date.getSeconds() + 10);
        tf = new SimpleDateFormat("HH:mm:ss");
        fo = tf.format(date);
        System.out.println(fo);
        
        // 날짜는 "yyyy-MM-dd" 형태로 출력하시오
        // 시간은 'HH:mm:ss" 형태로 출력하시오
        
    }
    
}
