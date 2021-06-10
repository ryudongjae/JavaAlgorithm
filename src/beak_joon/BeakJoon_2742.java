package beak_joon;

import java.io.*;

/*
* 반대로 N찍기( 내림차순)
* */
public class BeakJoon_2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();


        while (N > 0){
            System.out.println(N);
            N--;
        }
    }
}
class BeakJoon_2742_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();


        StringBuilder sb  = new StringBuilder();

        while(N > 0){
            sb.append(N+"\n");
            N--;

        }
        System.out.println(sb);
    }
}

class BeakJoon_2742_2_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();


        while(N > 0){
            bw.write(N+"\n");
            N--;

        }

        bw.flush(); //남은 데이터 모두 출력
        bw.close(); //스트림을 닫음

    }
}


