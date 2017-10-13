package java13.st1var;

public class Test {
    void sub(int... v) {
        System.out.println("인수의 개수 : " + v.length);
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int i = 0;i < v.length;i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
