package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(factorial(N) /(factorial(N-K)* factorial(K)));
    }

    static int factorial(int N) {
        if(N <= 1 ){
            return 1;
        }

        return N *factorial(N - 1);
    }
}
