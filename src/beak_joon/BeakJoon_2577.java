package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 개수
 * */
public class BeakJoon_2577 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        String str = String.valueOf(val); //tostring은 nullpointException을 반환하지만 Stirng.valueOf는 null을 반환한다.

        for(int i =0; i< str.length(); i++){
            arr[(str.charAt(i)-48)]++;
        }

        for(int v: arr){
            System.out.println(v);
        }

    }
}
