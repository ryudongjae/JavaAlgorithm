package beak_joon;

import java.io.*;
import java.util.StringTokenizer;

/*
* A+B -7
* */
public class BeakJoon_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i<=a; i++){
            st = new StringTokenizer(br.readLine()," ");
            System.out.println("Case #"+ i + ":"
                    + (Integer.parseInt(st.nextToken())
                    + Integer.parseInt(st.nextToken())));
        }
        br.close();
    }

}
class BeakJoon_11021_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i = 0; i <= a; i++){
            st = new StringTokenizer(br.readLine()," ");
            sb.append("Case #").append(i).append(": ")
                    .append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()))
                    .append('\n');
        }

        br.close();
        System.out.println(sb);
    }
}
class BeakJoon_11021_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());

        StringTokenizer  st;
        for(int i = 1; i <= a; i++){
            st = new StringTokenizer(br.readLine()," ");
            bw.write("Case #"+i+": " );
            bw.write(Integer.parseInt(st.nextToken())
                    +Integer.parseInt(st.nextToken())+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}