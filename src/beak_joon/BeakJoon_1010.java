package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1010 {
    static int T,N,M;
    static int [][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine()," ");
            N =Integer.parseInt(st.nextToken());
            M =Integer.parseInt(st.nextToken());

            sb.append(pascal(M,N)).append('\n');
        }
        System.out.println(sb);
    }

    static int pascal(int M,int N){
        if(dp[M][N] > 0){
            return dp[M][N];
        }

        if (M == N || N == 0){
            return dp[M][N] = 1;
        }

        return dp[M][N] = pascal(M-1,N-1) + pascal(M-1,N);
    }

}
