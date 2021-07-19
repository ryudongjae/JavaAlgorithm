package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int d = min(a,b);

        System.out.println(d);
        System.out.println(a*b/d);
    }

    static int min(int a, int b){
        if(b == 0){
            return a;
        }

        while (b != 0){
            int r = a % b;
            a = b;
            b = r;


        }
        return a;
    }
}
