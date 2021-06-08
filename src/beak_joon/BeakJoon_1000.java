package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//in.nextLine() : 문자열 입력시 Enter 입력 전까지만 받음
/*
A+B
 */
public class BeakJoon_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();

        StringTokenizer str = new StringTokenizer(st," ");
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());

        System.out.println(a+b);
    }
}
/**
 *
 * 위와같은 read() 메소드의 슬픈 사연들로 10 이상의 값을 받고 싶을 때 쓰기가 매우 복잡해진다.
 * 고로 BufferedReader 을 쓸 때는 readLine() 으로 쓰게 된다.
 *
 * readLine() 을 통해 입력 받아 연산하는 방법 두 가지를 설명할 것이다.
 * 앞서 말했듯이 readLine() 은 한 행을 전부 읽기 때문에 공백단위로 입력해 준 문자열을 공백단위로 분리해주어야 문제를 풀 수 있을 것이다.
 *
 * 문자열 분리 방법에는 두 가지가 있다.
 * StringTokenizer 클래스를 이용하여 분리해주는 방법
 * split() 을 이용하는 방법
 * 이 부분은 나중에 자세히 포스팅 하겠다만
 * 결론부터 말하자면 StringTokenizer 가 성능면에서 좋다. 그래서 단순 규칙으로 문자열을 분리해줄 때 필자는 StringTokenizer을 애용한다.
 *
 * StringTokenizer 또한 java.util 패키지에 있으므로 import 해준 다음 객체 생성을 해준다.
 *
 * 객체 생성 할 때 StringTokenizer( "문자열" , 구분자 ); 을 해주면 된다.
 * 구분된 변수를 꺼낼 때는 차례대로 nextToken(); 을 해주면 문자열을 반환해준다.
 * 이때 반환시킨 문자열은 반환됨과 동시에 해당 객체에서 사라지게 된다.
 *
 * 그리고 문자열을 반환했으니 Integer.parseInt()로 int 형으로 변환시켜준다.*/
