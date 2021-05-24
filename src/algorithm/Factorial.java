package algorithm;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("펙토리얼 계산을 위한 정수값 입력 ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int fac = 1;
        for (int i = 1; i<=num; i++){
            fac *= i;
        }

        System.out.println(num + "! = "+ fac);
    }
}
