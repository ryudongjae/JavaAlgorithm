package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1300 {
    static long result = 0;
    static long hi,lo;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        lo = 1;
        hi = k;

        while(lo <= hi){
            long mid = (lo + hi)/2;
            long cnt = 0;

            for(int i = 1; i <=N; i++){
                cnt+= Math.min(mid/i,N);
            }
            if(k > cnt)lo = mid+1;
            else{
                hi = mid -1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
