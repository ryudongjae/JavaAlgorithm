package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1929 {
    public static boolean []prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        prime = new boolean[N+1];
        get_prime();

        StringBuilder sb  = new StringBuilder();

        for(int i = M; i<= N; i++){
            if (!prime[i]){
                sb.append(i).append('\n');
            }
            System.out.println(sb);
        }
    }
    // 1 ~ Max 범위

    // 소수인 수 = false
    // 소수가 아닌 수 = true
    //에라토스테네스의 체
    public static void get_prime(){
        //0 이랑 1은 소수가 아니므로 true
        prime[0] = true;
        prime[1] = true;

        for(int i = 2; i<= Math.sqrt(prime.length); i++){
            if (prime[i]){  //이미 검증된것은 스킵
                continue;
            }

		/*
		정석대로라면 j = i * 2 부터 시작이지만
		이미 2의 배수가 걸러졌기때문에
		i 의 제곱수부터 시작해도 된다.
		*/


            for (int j = i*i; j< prime.length; j += i){
                prime[j] = true;
            }
        }
    }
}
