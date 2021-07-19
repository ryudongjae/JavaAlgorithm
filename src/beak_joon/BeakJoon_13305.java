package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  //N개의 도시

        long[] dis = new long[N-1];
        long[] cost = new long[N];

        //distance
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N-1; i++){
            dis[i] = Long.parseLong(st.nextToken());
        }

        //cost
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long total = 0;
        long minCost = cost[0];

        //기름값 검증
        for(int i = 0; i < N; i++){
            if(cost[i] < minCost){
                minCost = cost[i];
            }

            total+= (minCost * dis[i]);
        }

        System.out.println(total);
    }

}
