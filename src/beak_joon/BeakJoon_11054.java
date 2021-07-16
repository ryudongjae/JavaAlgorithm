package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_11054 {
    static int N;
    static int [] seq;
    static int [] ri_dp;
    static int [] le_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ri_dp = new int[N];
        le_dp = new int[N];
        seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for(int i = 0; i< N; i++){

            if(max < ri_dp[i] + le_dp[i]){
                max = ri_dp[i] + le_dp[i];
            }
        }

        System.out.println(max-1);

    }

    static void LIS() {
        for(int i = 0; i < N; i++){
            ri_dp[i] = 1;

            for(int j = 0; j < i; j++){
                if (seq[j] < seq[i] && ri_dp[i] < ri_dp[j] + 1){
                    ri_dp[i] = ri_dp[j] +1;
                }
            }
        }
    }

    static void LDS() {
        for(int i = N-1; i >= 0; i--){
            le_dp[i] = 1;

            for(int j = N -1; j > i; j--){
                if (seq[j] < seq[i] && le_dp[i] < le_dp[j] + 1){
                    le_dp[i] = le_dp[j] +1;
                }
            }
        }
    }
}
