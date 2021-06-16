package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        //첫번째 행
        for(int i = 0; i < N; i++){
            if(i%2 ==0){
                sb.append('*');
            }else{
                sb.append(' ');
            }
        }
        sb.append('\n');

        //두번째 행
        for(int i = 0; i < N; i++){
            if(i%2 != 0){
                sb.append('*');
            }else{
                sb.append(' ');
            }
        }
        sb.append('\n');

        String str =sb.toString();


        for(int i =1; i<N; i++){
            sb.append(str);
        }

        System.out.println(sb);
    }


}
