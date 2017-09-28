package java07;

import java.util.Arrays;

public class ex07_03_배열의최대최소구하기 {
    public static void printArray(int[] array) {
        for (int i = 0;i < array.length;i++) {
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.println();
            }
            else {
                System.out.print(", ");
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] array = {23, 96, 35, 42, 81, 19, 8, 77, 50, 64};
        
        System.out.print("배열 정렬 전 : ");
        printArray(array);
        
        Arrays.sort(array);
        System.out.print("배열 정렬 후 : ");
        printArray(array);
        
        System.out.print("최소값 : ");
        System.out.println(array[0]);
        System.out.print("최대값 : ");
        System.out.println(array[array.length - 1]);
        
    }
    
}
