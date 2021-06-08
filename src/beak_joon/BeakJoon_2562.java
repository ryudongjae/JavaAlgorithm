package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 최대값
 * */
public class BeakJoon_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int index = 0;

        for(int i = 0; i< 9; i++){
            int val = Integer.parseInt(bufferedReader.readLine());
            //parseInt = 문자열을 정수형으로 바꿔준다
            if(val > max){
                max = val;
                index = i+1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
