package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine());//첫 줄 N 은 안쓰이므로 입력만 받는다.

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = -10000001;
        int min = 10000001;

        while(st.hasMoreTokens()){
            int val  =Integer.parseInt(st.nextToken());

            if(val > max){
                max =val;
            }
            if(val < min){
                min= val;
            }
        }
        System.out.println(min + " " + max);

    }
}
