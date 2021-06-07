package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BeakJoon_10871 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int X = in.nextInt();
        int arr[] = new int[N];


        for(int i = 0; i < N; i++){
            arr[i] = in.nextInt();
        }

        in.close();

        for(int i = 0; i<N; i++){
            if(arr[i] < X){
                System.out.print(arr[i] +" ");
            }
        }
    }
}

class BeakJoon_10871_2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());

            if(value < X){
                sb.append(value).append(' ');
            }
            System.out.println(sb);
        }
    }
}
