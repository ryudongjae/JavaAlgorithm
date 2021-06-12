package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        int count = 0;
        int copy = N;

        do{
            N = ((N % 10 ) *10) + (((N / 10) + (N%10) % 10));
            count++;
        }while(copy != N);

        System.out.println(count);
    }
}
