package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt5= five_count(N) - (five_count(N-M) + five_count(M));
        int cnt2= two_count(N) - (two_count(N-M) + two_count(M));

        int  result = Math.min(cnt2,cnt5);
        System.out.println(result);
    }

    static int five_count(long num){
        int cnt = 0;
        while(num >= 5){
            cnt += (num/5);
            num/=5;
        }
        return cnt;
    }
    static int two_count(long num){
        int cnt = 0;
        while(num >= 2){
            cnt += (num/2);
            num/=2;
        }
        return cnt;
    }

}
