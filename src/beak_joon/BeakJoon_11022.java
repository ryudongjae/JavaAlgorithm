package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* A+B
* */
public class BeakJoon_11022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int A;
        int B;
        StringTokenizer st;
        for(int i = 0; i<= T; i++){
            st = new StringTokenizer(br.readLine()," ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            System.out.println("Case #"+ i +": "+A+" + "+B+" = "+(A+B) );

        }

        br.close();
    }
}

class BeakJoon_11022_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        int A;
        int B;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            sb.append("Case #"+ i +": ").append(A + " + " +B +" = " + (A+B)).append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}