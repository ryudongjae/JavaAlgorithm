package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(arithmetic_sequence(Integer.parseInt(br.readLine())));

    }

    public static int arithmetic_sequence(int num){
        int count = 0;  //한수 카운팅

        if(num < 100){
            return num;
        }

        else {
            count = 99;
            if(num == 1000) {  //예외처리 필수
                num = 999;
            }
                for(int i = 100; i <= num; i++){
                    int hun = i/100;  //백의 자리
                    int ten = (i/10)%10; //십의 자리
                    int one = i%10;

                    if((hun-ten)==(ten-one)){
                        count++;

                }
            }
        }
        return count;
    }
}
