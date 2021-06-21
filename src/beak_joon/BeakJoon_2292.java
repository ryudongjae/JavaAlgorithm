package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count =1;
        int range = 2;

        if(N == 1){
            System.out.println(1);
        }else{
            while(range <= N){
                range = range +(6 * count);
                count++;
            }

            System.out.println(count);
        }
    }
}
