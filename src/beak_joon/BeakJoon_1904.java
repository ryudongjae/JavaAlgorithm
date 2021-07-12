package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());


        System.out.println(Tile(N));



    }

    public static int Tile(int N) {

        if (N == 1){
            return 1;
        }

        else if(N == 2){
            return 2;
        }

        int val1 = 1;
        int val2 = 2;
        int sum = 0;

        for(int i = 2; i < N; i++ ){
            sum = (val1 + val2)%15746;
            val1 = val2;
            val2 = sum;

        }

        return sum;
    }
}
