package programmers;

public class _2xnTile {
    public int solution(int n) {
        int a = 1, b = 1;
        for(int i =0; i < n-1; i++){
            int result = (a+b)% 1000000007;
                a = b;
                b = result;
        }
        return b;
    }
}
