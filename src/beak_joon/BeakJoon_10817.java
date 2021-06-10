package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

/*
* 세 숫자 중에서 두번쨰로 큰수 출력하기
* */
public class BeakJoon_10817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int []arr = new int[3];

        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<2; i++){
            for(int j = i+1; j<3; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] =  temp;
                 }
            }
        }
    }
}

class BeakJoon_10817_2{
    public static void main(String[] args) throws IOException {
       BufferedReader be = new BufferedReader(new InputStreamReader(System.in));

       String str = be.readLine();
       StringTokenizer st  = new StringTokenizer(str, " ");

       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       int c = Integer.parseInt(st.nextToken());

       if(a >= b){
           if( a>= c ){
               //a가 가장 크거나 같을 경우
               if(b >=  c){
                   System.out.println(b);
               }else {
                   System.out.println(c);
               }
           }else {
               System.out.println(a);
           }
       }else {
           if( c<= b){
               if(c <= a){
                   System.out.println(a);
               }else{
                   System.out.println(c);
               }
           }else{
               System.out.println(b);
           }
       }
    }
}
