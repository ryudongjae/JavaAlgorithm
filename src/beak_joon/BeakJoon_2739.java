package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 구구단
* */
public class BeakJoon_2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        br.close();

        for(int i =0; i<10; i++){
            System.out.println(a +"*"+ i+"=" +(a*i));
        }
    }
}
