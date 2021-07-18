package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_11653 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());

       int i = 2;
       while(true){
           if(N == 1){
               break;
           }
           if(N % i == 0){
               N/= i;
               System.out.println(i);
           }else {
               i++;
           }
       }
    }
}
