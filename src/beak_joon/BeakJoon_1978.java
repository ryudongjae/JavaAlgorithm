package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        int count = 0;

        StringTokenizer st  = new  StringTokenizer(br.readLine()," ");

        while(st.hasMoreTokens()){

            boolean isPrime = true; //소수인 경우 true, 아니면 false

            int num = Integer.parseInt(st.nextToken());
            //이 과정에서 StringTokenizer 자체가 토큰이 남아있는지 여부를 true, false 로 반환시켜준다.
            if(num == 1){
                continue;
            }
            for(int i = 2; i<Math.sqrt(num); i++) {  //제곱근 까지만 연산한다.
                if(num % 1 == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                count++;
            }
        }

        System.out.println(count);
    }
}
