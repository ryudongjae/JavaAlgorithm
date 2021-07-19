package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(A-- > 0){
            int N = Integer.parseInt(st.nextToken());
            if(max_value < N){
                max_value = N;
            }else{
                max_value = max_value;
            }

            if(min_value > N){
                min_value = N;
            }
            else {
                min_value = min_value;
            }
        }

        System.out.println(min_value*max_value);
    }
}
