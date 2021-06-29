package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_10989 {
    public static void main(String[] args) throws IOException {
        //범위 0 - 10000
        int [] count = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            count[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++){
            //i값 개수가 0이 될때까지 출력
            while(count[i] > 0){
                sb.append(i).append('\n');
                count[i]--;
            }
        }

        System.out.println(sb);
    }
}
