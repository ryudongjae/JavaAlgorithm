package programmers;

public class GCD {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++){
            int g = gcd(answer,arr[i]);
            answer = arr[i]*answer/g;
        }
        return answer;
    }
    static int gcd(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        while (x%y != 0) {
            int r = x%y;
            x = y;
            y = r;
        }
        return y;
    }
}
