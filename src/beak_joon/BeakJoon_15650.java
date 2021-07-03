package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_15650 {
    public static int[] arr;
    public static int N,M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);

        System.out.println(sb);
    }

    private static void dfs(int at, int depth) {
        if (depth == M ){
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = at; i <= M; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}
