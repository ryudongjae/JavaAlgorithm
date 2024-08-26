package programmers;

import java.util.Scanner;

public class RepetitionString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        String s = "";
        for(int i = 0; i < n; i++){
            s = s+str;
        }
        System.out.println(s);
    }
}
