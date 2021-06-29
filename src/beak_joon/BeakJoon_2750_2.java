package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//N(1 <= N <= 1000)
public class BeakJoon_2750_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N =Integer.parseInt(br.readLine());

        //범위 -1000 : 1000
        boolean [] arr = new boolean[2001];

        for(int i = 0; i < N; i++){
            arr[Integer.parseInt(br.readLine()) + 1000] =true;

        }

        for(int i = 0; i < 2001; i++){
            if(arr[i]){
                sb.append(i - 1000).append('\n');
            }
        }

        System.out.println(sb);
    }
}
