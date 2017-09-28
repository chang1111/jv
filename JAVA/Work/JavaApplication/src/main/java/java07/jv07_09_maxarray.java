package java07;

import java.util.Arrays;

public class jv07_09_maxarray {
    
    public static void main(String[] args) {
        int[] array = new int[6];
        array[0] = 3;
        array[1] = 1;
        array[2] = 7;
        array[3] = 6;
        array[4] = 9;
        array[5] = 2;
        Arrays.sort(array);
        int min = array[0];
        int max = array[array.length - 1];
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
        max = max(array);
        System.out.println("최대값 : " + max);
        
    }
    public static int max(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1];
    }
    
}
