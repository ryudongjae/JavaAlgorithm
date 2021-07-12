package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_9461 {
    static long[] seq = new long[101];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        padovan();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            sb.append(seq[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);


    }

    static void padovan() {
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 1;

        for (int i = 4; i < 101; i++) {
            seq[i] = seq[i - 2] + seq[i - 3];
        }
    }
}
