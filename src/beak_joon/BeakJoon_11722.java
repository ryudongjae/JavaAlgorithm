package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_11722 {
    static int [] seq;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        seq = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N-1; i >= 0; i --){
            dp[i] = 1;

            for(int j = N -1; j > i; j--){
                if (seq[j] < seq[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for(int i = 0; i < N; i++){
            max = dp[i] > max ? dp[i] : max;
        }

        System.out.println(max);
    }
}
