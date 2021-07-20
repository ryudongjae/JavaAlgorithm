package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int firR = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            int subR = Integer.parseInt(st.nextToken());
            int gcd = gcd(firR,subR);
            sb.append(firR/gcd).append('/').append(subR/gcd).append('\n');


        }

        System.out.println(sb);



    }

    static int gcd(int a, int b){
        while (b != 0 ){
        int r = a%b;
        a = b;
        b = r;
        }
        return a;
    }
}

