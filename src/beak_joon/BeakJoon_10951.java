package beak_joon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        while ((str = br.readLine()) != null ){
            st = new StringTokenizer(str, " ");
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }
}

class BeakJoon_10951_2{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while((str = br.readLine()) != null){
            int a =str.charAt(0) - 48;
            int b =str.charAt(2) - 48;

            sb.append(a+b).append("\n");
        }

        System.out.println(sb);
    }
}
