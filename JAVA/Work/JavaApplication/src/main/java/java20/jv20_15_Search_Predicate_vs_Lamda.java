package java20;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

class User {
    private String name;
    private Integer number;
    private Boolean isChecked;
    
    public User() {
        super();
    }

    public User(String name, Integer number, Boolean isChecked) {
        super();
        this.name = name;
        this.number = number;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", number=" + number + ", isChecked="
                + isChecked + "]";
    }
    
    public static class MyPredicateContains implements Predicate {
        /*
         * Predicate를 사용하기 위해서는
         * build.gradle에
         * compile 'commons-collections:commons-collections:3.2' 을
         * 추가해야한다
         */
        
        private Object expected;
        private String fieldName;
        
        public MyPredicateContains (String fieldName, Object expected) {
            this.fieldName = fieldName;
            this.expected = expected;
        }
        
        @Override
        public boolean evaluate(Object object) {
            if (fieldName.equals("name")) {
                return ((User)object).getName().contains(expected.toString());
            }
            else if (fieldName.equals("number")) {
                return ((User)object).getNumber().equals(expected);
            }
            else if (fieldName.equals("isChecked")) {
                return ((User)object).getIsChecked().equals(expected);
            }
            else {
                return false;
            }
        }
        
    }
}

public class jv20_15_Search_Predicate_vs_Lamda {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User("User Name A", 1, true));
        users.add(new User("User Name B", 2, false));
        users.add(new User("Other User", 3, true));
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println();
        
        // Lamda를 이용한 searching : lamda는 java 8 부터 지원
        // equal searching
        List<User> result = users.stream().filter(e->e.getName().equals("User Name B")).collect(Collectors.toList());
        System.out.println("Eqauls Searching");
        for (User user : result) {
            System.out.println(user);
        }
        System.out.println();
        
        // contains searching
        result = users.stream().filter(e->e.getName().contains("Na")).collect(Collectors.toList());
        System.out.println("Contains Searching");
        for (User user : result) {
            System.out.println(user);
        }
        System.out.println();
        
        // Predicate를 이용한 searching
        // Predicate를 사용하기 위해서는 build.gradle에
        // compile 'commons-collections:commons-collections:3.2' 을
        // 추가해야한다
        // 1. User.MyPredicateContains 인스턴스 만들기
        // 2. CollectionUtils.select() 실행
        // 3. 프린트
        Predicate predicate = new User.MyPredicateContains("name", "Other");
        result = (List<User>) CollectionUtils.select(users, predicate);
        for (User user : result) {
            System.out.println(user);
        }
        System.out.println();
    }

}
