package java07;

public class jv07_02_ArrayExam {
    
    public static void main(String[] args) {
        int size = 6;
        int[] numbers = new int[size];
        
        for (int i = 0;i < numbers.length;i = i + 1) {
            numbers[i] = i;
        }
        for (int i = 0;i < numbers.length;i = i + 1){
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
    }
    
}
