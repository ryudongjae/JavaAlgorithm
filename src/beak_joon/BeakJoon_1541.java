package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");


        while(st.hasMoreTokens()){
            int t = 0;

            StringTokenizer st_p = new StringTokenizer(st.nextToken(),"+");

            while (st_p.hasMoreTokens()){
                t += Integer.parseInt(st_p.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = t;
            }else{
                sum -= t;
            }


        }

        System.out.println(sum);
    }
}
