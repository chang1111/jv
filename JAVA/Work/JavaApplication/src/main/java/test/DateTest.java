package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("yyyy-MM-dd");
        String 대여날짜 = tf.format(date);
        System.out.println(대여날짜);
        
    }
    
}
