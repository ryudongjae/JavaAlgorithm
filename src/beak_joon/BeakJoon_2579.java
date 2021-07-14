package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] fl = new int[N+1];
        int [] dp = new int[N+1];
        for(int i = 1; i < N; i++){
            fl[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = fl[1];

        if(N >= 2){
            dp[2] = fl[1]+ fl[2];

        }

        for(int i = 3; i<=N; i++ ){
            dp[i] = Math.max(dp[i-2],dp[i-3]+fl[i-1])+fl[i];
        }

        System.out.println(dp[N]);
    }
}
