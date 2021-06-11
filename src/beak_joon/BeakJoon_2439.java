package beak_joon;

import java.io.*;

public class BeakJoon_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= N-i; j++){
                System.out.print(" ");
            }
            for(int k =1; k<= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
class BeakJoon_2439_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder  sb = new StringBuilder();


        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= N-i; j++){
                sb.append(" ");
            }
            for(int k =1; k<= i; k++){
                sb.append("*");
            }
           sb.append('\n');
        }
        System.out.print(sb);
    }
}
class BeakJoon_2439_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        br.close();


        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= N-i; j++){
              bw.write(' ');
            }
            for(int k =1; k<= i; k++){
                bw.write('*');
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

