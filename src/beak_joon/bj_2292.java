package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2292 {
    public static void main(String[] args) throws IOException {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int depth = 2;

        if (N==1){
            System.out.print(1);
        }else{
            while ( depth <= N){
                depth = depth + (6 * cnt);
                cnt++;
            }

            System.out.print(cnt);
        }
    }
}
