package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2231 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_N = br.readLine(); //자릿수의 길이를 알기위해 일단 문자열로 입력 받음

        int N_len =str_N.length(); //해당 문자열의 길이 변수

        int N = Integer.parseInt(str_N);  //문자열을 정수로 변환
        int result = 0;

        //i 는 가능한 최솟값인 N-9*N의 각 자릿수 부터 시작
        for(int i =(N -(N_len*9)); i < N; i++){
            int number = i;
            int sum = 0;

            while (number != 0){
                sum += number % 10;
                number /= 10;

            }

            if(sum + i == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
