package java07;

public class jv07_01_array {
    
    public static void main(String[] args) {
        
        // 변수 5개 선언
        int score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0;
        
        // 배열을 이용한 변수 5개 선언
        int[] score = new int[5];
        score[0] = 0;
        score[1] = 1;
        score[2] = 2;
        score[3] = 3;
        score[4] = 4;
        
        System.out.println("score1 : " + score1);
        
        System.out.println("score[0] : " + score[0]);
    }
    
}
