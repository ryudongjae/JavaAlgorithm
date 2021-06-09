package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 사칙연산
* */
public class BeakJoon_10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st  = new StringTokenizer(str," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
    }
}
class BeakJoon_10869_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);



        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);



    }
}
