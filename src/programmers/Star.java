package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        StringTokenizer str = new StringTokenizer(st," ");
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b; i++){
            sb.append("*");
        }
        for (int i = 0; i< a;i++ ){
            System.out.println(sb.toString());
        }



    }
}
