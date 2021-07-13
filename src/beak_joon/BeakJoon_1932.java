package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_1932 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] Triangle = new int[N][N];
        for(int i = 0; i < N; i++) {

            String[] Input = br.readLine().split(" ");

            for(int j = 0; j < Input.length; j++) {
                Triangle[i][j] = Integer.parseInt(Input[j]);
            }
        }
        for(int i = N-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                Triangle[i][j] += Math.max(Triangle[i+1][j], Triangle[i+1][j+1]);
            }
        }
        System.out.println(Triangle[0][0]);
    }


}


