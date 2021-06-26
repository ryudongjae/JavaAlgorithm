package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_9020 {

    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        get_prime();

        int T = Integer.parseInt(br.readLine());  //test case

        while( T-- > 0){
            int n =Integer.parseInt(br.readLine());
            int first_partition = n/2;
            int second_partition = n/2;

            while(true){

                //두 파티션이 모두 소수일 경우
                if(!prime[first_partition] && !prime[second_partition]){
                    sb.append(first_partition).append(' ').append(second_partition).append('\n');
                    break;
                }

                first_partition --;
                second_partition ++;
            }
        }

        System.out.println(sb);


    }

    public static void get_prime(){
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++){
            if(prime[i]){
                continue;
            }
            for (int j = i*i; j< prime.length; j+= i){
                prime[j] =true;
            }
        }
    }
}
