package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int t = Integer.parseInt(br.readLine());
        for(int r = 0; r < t; r++){
            int k =Integer.parseInt(br.readLine());
            int[] com = new int[k+1];
            int []value = new int[k+1];
            int [][]dp = new int[k+1][k+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= k; i++){
                com[i] = Integer.parseInt(st.nextToken());
                value[i] = value[i-1] + com[i];
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j + i <= k; j++) {
                    int n = j + i;
                    dp[j][n] = Integer.MAX_VALUE;
                    for (int m = j; m < n; m++) {
                        dp[j][n] = Math.min(dp[j][n], dp[j][m] + dp[m + 1][n] + value[n] - value[j - 1]);
                    }
                }
            }
            System.out.println(dp[1][k]);
        }
    }
}
