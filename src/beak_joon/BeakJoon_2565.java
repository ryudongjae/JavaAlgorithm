package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BeakJoon_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] dp =new Integer[N];
        int[][] wire = new int[N][2];

        StringTokenizer st;

        for(int i = 0; i < wire.length; i++){
            st = new StringTokenizer(br.readLine()," ");
            wire[i][0] = Integer.parseInt(st.nextToken()); //A전봇대
            wire[i][1] = Integer.parseInt(st.nextToken()); //B전봇대

        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });

        for(int i = 0; i < dp.length; i++){
            dp[i] = 1; // 체크횟수
            /**
             * i번째 전봇대를 기준으로 이전의 전봇대들의
             * 전선을 연결하기 위한 탐색
             * 즉, i번째 전봇대에 연결된 B전봇대는
             * 탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함
             */

            for(int j = 0; j < i; j++){
                if(wire[i][1] > wire[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1 );
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(N - max);

    }
}
