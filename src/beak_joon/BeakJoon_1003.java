package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] zero = new int[41];
        zero[0] = 1;
        zero[1] = 0;

        int[] one = new int[41];
        one[0] = 0;
        one[1] = 1;

        for (int i = 2; i <= 40; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(zero[n]).append(" ").append(one[n]).append("\n");
        }
        System.out.println(sb);
    }
}
