package programmers;

import java.util.Scanner;

public class DivideNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int answer = 0;

        for(int i=0; i<1; i++){
            answer += number % 100;
           number /= 100;
        }

        System.out.println(answer);
    }
}
