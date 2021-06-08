package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
A-B
 */
public class BeakJoon_1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine(); //eadLine() 은 한 행을 전부 읽기

        StringTokenizer str = new StringTokenizer(st," ");
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());

        System.out.println(a-b);
    }
}

class BeakJoon_1001_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);

        System.out.println(a-b);

    }


}

/**
 *
 * BufferedReader 을 쓰는 방식이다.
 *
 * readLine() 을 통해 입력 받아 연산하는 방법 두 가지를 설명할 것이다.
 * 앞서 말했듯이 readLine() 은 한 행을 전부 읽기 때문에 공백단위로 입력해 준 문자열을 공백단위로 분리해주어야 문제를 풀 수 있을 것이다.
 *
 * 문자열 분리 방법 두 가지로 풀어보자.
 * StringTokenizer 클래스를 이용하여 분리해주는 방법
 * split() 을 이용하는 방법
 *
 * 그리고 반드시 자료형 타입을 잘 보아야 한다.
 * st.nextToken() 은 문자열을 반환하니 Integer.parseInt()로 int 형으로 변환시켜준다.
 *  */
