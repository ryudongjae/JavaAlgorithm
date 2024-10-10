package beak_joon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_27433 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long inputNum = Long.parseLong(br.readLine());
        System.out.println(recursion(inputNum));

    }

    public static long recursion(long number){

        if(number == 0){
            return 1;
        }else{
            return number * recursion(number - 1);
        }
    }
}
