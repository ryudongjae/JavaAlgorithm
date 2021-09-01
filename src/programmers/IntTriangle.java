package programmers;

public class IntTriangle {
    public int solution(int[][] triangle) {
        int [][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];


        for(int i = 1; i < triangle.length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];

            for(int j = 1; j < i+1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1],dp[i-1][j]);
            }
        }
        int max = 0;
        for(int i = 0; i < dp[dp.length -1].length; i++){
            max = Math.max(dp[dp.length-1][i],max);
        }
        return max;
    }
}
