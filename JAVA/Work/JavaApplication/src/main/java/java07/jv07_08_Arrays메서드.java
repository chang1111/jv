package java07;

import java.util.Arrays;

public class jv07_08_Arrays메서드 {
    
    public static void main(String[] args) {
        
        // 배열 만들기
        int[] array = new int[6];
        
        // for문을 이용한 배열 초기화
        for (int i = 0;i < array.length;i++) {
            array[i] = array.length - i;
        }
        printArray(array);
        
        // Arrays 정렬 & printArray() 호출
        Arrays.sort(array);
        printArray(array);
        
        // Arrays 검색 & printArray() 호출
        int val = Arrays.binarySearch(array, 4);
        System.out.println("4값의 위치 " + val);
        
        // Arrays 초기화 & printArray() 호출
        Arrays.fill(array, -1);
        printArray(array);
    }
    
    // 메서드 만들기
    // 메서드명 : printArray
    // 메서드 타입 : void
    // 매개변수 : 정수 배열
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
}
