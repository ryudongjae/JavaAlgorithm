package beak_joon;

import java.io.*;

/*\
* N찍기
* */
public class BeakJoon_2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int i = 1;
        while (i<= N){
            System.out.println(i);
            i++;
        }
    }
}
class BeakJoon_2741_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int i = 1;
        StringBuilder sb  = new StringBuilder();

        while(i <= N){
            sb.append(i+"\n");
            i++;

        }
        System.out.println(sb);
    }
}

class BeakJoon_2741_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int i = 1;
        while(i <= N){
            bw.write(i+"\n");
            i++;

        }

        bw.flush(); //남은 데이터 모두 출력
        bw.close(); //스트림을 닫음

    }
}