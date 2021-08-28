package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeakJoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new  InputStreamReader(System.in));
        String[] KN = br.readLine().split(" ");
        int K = Integer.parseInt(KN[0]);
        int N = Integer.parseInt(KN[1]);

        int []cable = new int[K];
        for(int i =0; i< K; i++){
            cable[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cable);
        long hi = cable[K-1];
        long lo = 1;
        long mid = 0;

        while (hi >= lo){
            mid = (hi+lo)/2;
            long cnt = 0;
            for(int i=0; i< cable.length; i++){
                cnt += cable[i]/mid;
            }

            if(cnt >= N)lo =mid +1;
            else if(cnt<N) hi = mid -1;

        }
        System.out.println(hi);
    }
}
