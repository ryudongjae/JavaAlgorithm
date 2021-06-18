package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A =Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int B =Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        //reverse() = 저장되어 있던 문자열을 뒤집는다.
        System.out.print(A > B ? A : B);

    }
}
