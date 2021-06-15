package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum =0;
        for(int i =0; i < 5; i++){
            int val = Integer.parseInt(br.readLine());

            sum+= val > 40 ? val : 40;
        }

        System.out.println(sum/5);
    }
}
