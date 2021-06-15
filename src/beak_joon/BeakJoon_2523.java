package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        for(int i = 1; i <= N; i++){
            for(int j = 0; j <i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = N-1; i>0; i--){
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
class  BeakJoon_2523_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
             for(int j = 0; j <i; j++){
                   sb.append('*');
             }
            sb.append('\n');
        }

        for(int i = N-1; i>0; i--){
             for(int j = 0; j<i; j++){
                 sb.append('*');
             }
             sb.append('\n');
        }
        System.out.println(sb);
    }
}
