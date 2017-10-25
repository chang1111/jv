package java18;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.core.SimpleAliasRegistry;

public class jv18_07_Calendar {
    
    public static void main(String[] args) {
        Calendar d = Calendar.getInstance();
        System.out.println(d);
        System.out.println("년 >> " + d.get(Calendar.YEAR));
        System.out.println("월 >> " + d.get(Calendar.MONTH));
        System.out.println("일 >> " + d.get(Calendar.DATE));
        System.out.println("시 >> " + d.get(Calendar.HOUR));
        System.out.println("분 >> " + d.get(Calendar.MINUTE));
        System.out.println("초 >> " + d.get(Calendar.SECOND));
        
        d.set(Calendar.YEAR, 2000);
        d.set(Calendar.MONTH, 4);
        d.set(Calendar.DATE, 13);
        d.set(Calendar.HOUR, 12);
        d.set(Calendar.MINUTE, 13);
        d.set(Calendar.SECOND, 15);
        System.out.println(d);
        
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fo = tf.format(d.getTime());
        System.out.println(fo);

    }
    
}
