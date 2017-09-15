package java00.실습_java08_string;

public class ex08_01_String메서드예제 {
    
    public static void main(String[] args) {
	
		// 도전 1. 문자열 치환: 
		// ÷(\u00F7) --> /, ×(\u00D7) --> * 바꾸기
		String temp = "\u00F7 \t \u00D7 ";
        System.out.println( "치환 전 : " + temp ); // " ÷     × " 
		System.out.println( "치환 후 : " + temp ); // "  /      * " 


		// 도전 2. 형변환. 문자열 정수로 바꾸기.
		// 문자열 "3"을 정수 3으로 바꾸시오. 구글 검색
		String temp2 = "3"; 

		
        // 도전 3. 문자열에서 가장 큰 수를 찾으시오.
		//         a. 문자열 자르기 --> String 배열을 얻게 됨.
        //         b. 문자열 배열을 정수 배열로 만든다. 
        //            이 때 for 문과 Integer.parseInt() 사용
        //         c. 정수배열(intArray)를 오름차순 정렬하시오
        //         d. 정수배열에서 최대값을 찾는다.        
		String temp3 = "74 874 9883 73 9 73646 774";
    }

}
