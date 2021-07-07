package beak_joon;

import java.io.*;
import java.util.StringTokenizer;

public class BeakJoon_11694 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];

        boolean flag = false; // 돌이 1개인 더미만 존재하는지
        int num = 0; // 돌이 1개인 더미의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());

            if (input[i] != 1) {
                flag = true;
            } else {
                num++;
            }
        }

        // 돌이 1개인 더미만 존재하는 경우
        // 돌 더미가 짝수면 선공이 승리하고, 홀수면 후공이 승리한다.
        if (!flag) {
            bw.write((num % 2 == 1) ? "cubelover" : "koosaga");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        long result = 0; // 님 합
        for (int i = 0; i < N; i++) {
            result ^= input[i];
        }

        if (num != 0) { // 돌이 1개인 더미가 존재하는 경우
            if (num % 2 == 1 && result != 0) {
                bw.write("koosaga");
            } else if (num % 2 == 1 && result == 0) {
                bw.write("cubelover");
            } else if (num % 2 == 0) {
                // 돌이 1개인 더미가 짝수인 경우
                // 돌이 1개가 아닌 임의의 더미를 돌이 1개인 더미로 만들어 준다

                for (int i = 0; i < N; i++) {
                    if (input[i] != 1) {
                        input[i] = 1;
                        break;
                    }
                }

                result = 0; // 님 합
                for (int i = 0; i < N; i++) {
                    result ^= input[i];
                }

                if (result != 0) {
                    bw.write("koosaga");
                } else {
                    bw.write("cubelover");
                }
            }
        } else { // 돌이 1개인 더미가 없는 경우
            bw.write((result != 0) ? "koosaga" : "cubelover");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}