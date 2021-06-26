package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BeakJoon_10872 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = factorial(N);
        System.out.println(sum);
    }

    public static int factorial(int N){
        if(1 == N)return 1;
        return N * factorial(N-1);
    }
}
