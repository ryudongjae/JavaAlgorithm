package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
곱셈
 */
public class BeakJoon_2588 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        String B = sc.next();

        sc.close();

        System.out.println(A * (B.charAt(2) - '0'));
        System.out.println(A * (B.charAt(1) - '0'));
        System.out.println(A * (B.charAt(0) - '0'));
        System.out.println(A * Integer.parseInt(B));
    }
}

class BeakJoon_2588_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();

        char[]b = B.toCharArray();

        System.out.println(A * (b[2] - '0'));
        System.out.println(A * (b[1] - '0'));
        System.out.println(A * (b[0] - '0'));
        System.out.println(A * Integer.parseInt(B));
    }
}
