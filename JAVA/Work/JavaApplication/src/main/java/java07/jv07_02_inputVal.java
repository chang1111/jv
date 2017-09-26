package java07;

public class jv07_02_inputVal {
    public static String[] inputVal(String x) {
        String[] y = {x, x + "d", "abc"};
        return y;
    }
    public static void main(String[] args) {
        String x = "bbhfdh";
        String[] y = inputVal(x);
        for (int i = 0;i < y.length;i++){
            System.out.println(y[i]);
        }
        
    }
    
}
