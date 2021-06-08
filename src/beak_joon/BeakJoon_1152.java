package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
    단어의 개수
 */
public class BeakJoon_1152 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        scanner.close();

        // st 에 공백을 기준으로 나눈 토큰들을 st 에 저장한다
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");

        // countTokens() 는 토큰의 개수를 반환한다
        System.out.println(stringTokenizer.countTokens());
    }
}


class BeakJoon1152_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        System.out.println(st.countTokens());
    }
        }
