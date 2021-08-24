package programmers;

public class BracketCount {
    public int solution(int n) {

        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<n+1; i++){
            for(int j = 1; j<i+1; j++){
                dp[i] += (dp[i-j] * dp[j-1]);
            }
        }
        return dp[n];
    }
}
