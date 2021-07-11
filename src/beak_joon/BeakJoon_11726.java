package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];


        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        System.out.println(dp[N]);
    }
}

class BeakJoon_11726_2{

    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(recur(N));

        System.out.println(sb);
    }
    static int recur(int index) {
        if (index == 1) {
            return 1;
        }
        else if (index == 2) {
            return 2;
        }
        else if (dp[index] != 0) {
            return dp[index];
        }
        else {
            int a = recur(index - 1);
            int b = recur(index - 2);
            dp[index - 1] = a;
            dp[index - 2] = b;

            return dp[index] = (a + b) % 10007;
        }
    }


}
