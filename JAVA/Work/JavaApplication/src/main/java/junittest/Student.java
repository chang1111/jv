package junittest;

public class Student {
    private String name = "";
    private int    score = 0 ;
    
    // getter & setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    // toString
    @Override
    public String toString() {
        return "Student [name=" + name + ", score=" + score + "]";
    }
    
    // constructor
    public Student() {
        super();
    }
    public Student(String name, int score) {
        super();
        this.name = name;
        this.score = score;
    }
    
    
    // 메서드
    public  String   getgrade( int grade ) {
        
        String result = "";
        
        if( grade>= 90 ) {
            result = "A" ;
        }
        else if( grade >= 80 ) {
            result = "B";
        }
        else if( grade >= 70 ) {
            result = "C";
        }
        else if( grade >= 60 ) {
            result = "D";
        }
        else  {
            result = "F";
        }
        
        return result;
    }
    
    
    
    
}
