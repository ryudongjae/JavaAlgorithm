package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int [] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int val = Math.abs(arr[0] - arr[1]);

        for(int i = 1; i < N-1  ; i++){
            val = gcb(val,Math.abs(arr[i] - arr[i+1]));
        }


        for(int i = 2; i <= val/2; i ++){
            if(val % i == 0){
                sb.append(i + " ");
            }
        }
        sb.append(val);
        System.out.println(sb);
    }

    static int gcb(int a,int b) {

        while(b != 0 ){
            int r = a%b;
            a = b;
            b = r;
        }

        return a;
    }
}
