package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class BeakJoon_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr= br.readLine().toCharArray();

        Arrays.sort(arr);

        for(int i = arr.length -1; i >= 0; i--){
            System.out.print(arr[i]);
        }
    }
}
