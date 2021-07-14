package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1149 {
    static int red;
    static int green;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [][] cost = new int[N][3];

        red =0; green =1; blue = 2;

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            cost[i][red] = Integer.parseInt(st.nextToken());
            cost[i][green] = Integer.parseInt(st.nextToken());
            cost[i][blue] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            cost[i][red] += Math.min(cost[i-1][blue],cost[i-1][green]);
            cost[i][blue] += Math.min(cost[i-1][red],cost[i-1][green]);
            cost[i][green] += Math.min(cost[i-1][red],cost[i-1][blue]);
        }

        System.out.println(Math.min(Math.min(cost[N-1][red],cost[N-1][green]),cost[N-1][blue]));
    }
}
