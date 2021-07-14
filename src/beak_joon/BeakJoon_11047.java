package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BeakJoon_11047 {
    static int N,K,cnt;
    static int [] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        cnt = 0;
        for(int i = 0 ; i< N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }


        for(int i = N-1; i>=0; i--){

            if(coin[i] <= K){
                cnt += K/coin[i];
                K = K%coin[i];
            }
        }
        System.out.println(cnt);
    }
}
