package programmers;

public class MatrixMultiplication {
    public int solution(int[][] matrix_sizes) {
        int[][]dp = new int[matrix_sizes.length][matrix_sizes.length];

        for(int i = 0; i < matrix_sizes.length; i++){
            for(int j = 0; j < matrix_sizes.length; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < matrix_sizes.length; i++){
            for(int j = 0; j < matrix_sizes.length - i; j++){
                int a = j;
                int b = j+i;
                if(a==b)dp[a][b] = 0;
                else{
                    for(int k = a; k <b; k++){
                        dp[a][b] = Math.min(dp[a][b],dp[a][k]+dp[k+1][b] + matrix_sizes[a][0]*matrix_sizes[k][1]*matrix_sizes[b][1]);
                    }
                }
            }
        }

        return dp[0][matrix_sizes.length-1];

    }


}
