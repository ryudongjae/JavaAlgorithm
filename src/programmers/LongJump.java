package programmers;

public class LongJump {
    public long solution(int n) {
        int a = 1 , b =1;
        for(int i = 0; i < n-1; i++){
            int result = (a+b)%1234567;
            a=b;
            b=result;
        }
        return b;
    }
}
