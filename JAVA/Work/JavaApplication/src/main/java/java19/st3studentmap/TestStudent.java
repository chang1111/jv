package java19.st3studentmap;

import java.util.*;

public class TestStudent {
    
    public static void main(String[] args) {
        //HashMap 인스턴스 생성
        Map<Integer, Student> st = new HashMap<Integer, Student>();
        
        //Map에 추가
        // key      -->   value
        // 170101   -->   new Student(구준표)
        // 170102   -->   new Student(금잔디)
        // 170103   -->   new Student(윤지후)
        st.put(170101, new Student(170101, "구준표"));
        st.put(170102, new Student(170102, "금잔디"));
        st.put(170103, new Student(170103, "윤지후"));
        
        // entrySet, foreach map에 항목 출력;
        for (Map.Entry<Integer, Student> map : st.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println("-------------------------");
        // 학번 170102를 삭제
        st.remove(170102);
        System.out.println(st);
        System.out.println("-------------------------");
        // 윤지후 이름이 "윤후로 개명
        st.put(170103, new Student(170103, "윤후"));
        System.out.println(st);
        System.out.println("-------------------------");
        // entrySet, foreach amp에 항목 출력
        for (Map.Entry<Integer, Student> map : st.entrySet()) {
            System.out.println(map.getKey() + " : " + map.getValue());
        }
    }
    
}
