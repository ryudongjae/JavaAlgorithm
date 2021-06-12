package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeakJoon_10952 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A==0&& B==0){
                sc.close();
                break;
            }
            System.out.println(A+B);
        }
    }
}
class BeakJoon_10952_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while(true){
            st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A==0 && B==0){
                break;
            }

            sb.append((A+B)).append('\n');

        }
        System.out.println(sb);
    }
}

class BeakJoon_10952_3{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();

            int A = str.charAt(0) -48;
            int B = str.charAt(2) -48;


            if(A == 0 && B == 0){
                break;
            }
            sb.append((A+B)).append('\n');

        }
        System.out.println(sb);
    }
}