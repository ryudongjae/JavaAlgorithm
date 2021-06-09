package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(br.readLine());

        if(y%4 == 0){
          if(y%400 == 0){
              System.out.println("1");
          }else if(y%100 == 0 ){
              System.out.println("0");
          }else{
              System.out.println("1");
          }
        }else{
            System.out.println("0");
        }
    }
}
class BeakJoon_2753_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(br.readLine());

        System.out.println((y%4 == 0)?((y%400 == 0)?"1":(y%100 == 0)?"0":"1"):"0");
    }
}


