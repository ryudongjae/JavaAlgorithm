package beak_joon;

import java.io.*;

public class BeakJoon_2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 1; i<=N; i++){
            for( int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
class BeakJoon_2438_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=N; i++){
            for(int j =1; j<=i; j++){
                sb.append("*");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}

class BeakJoon_2438_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 1; i<=N; i++){
            for(int j = 1; j <= i; j++){
                bw.write("*");
            }
            bw.newLine(); //newLine: 줄바꿈
        }
        bw.flush();
        bw.close();
    }
}