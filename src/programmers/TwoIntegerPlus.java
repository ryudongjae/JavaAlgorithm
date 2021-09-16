package programmers;

public class TwoIntegerPlus {
    public long solution(int a, int b) {
        long answer = 0;
        int max = 0;
        int min = 0;

        if(a==b) {
            return a;
        }
        else if(a>b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        for(int i=min; i<=max; i++) {
            answer += i;
        }

        return answer;
    }
}
