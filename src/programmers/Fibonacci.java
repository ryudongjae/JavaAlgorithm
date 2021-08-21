package programmers;

public class Fibonacci {
    public int solution(int n) {
        int a = 0; int b = 1;
        int dv =1234567;
        for(int i = 0; i < n; i++){
            int c = (a+b)%dv;
            a = b%dv;
            b = c%dv;
        }

        return a;
    }
}
