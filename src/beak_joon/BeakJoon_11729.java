package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BeakJoon_11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2,N) -1)).append('\n');

        Hanoi(N,1,2,3);
        System.out.println(sb);

    }

	/*
		N : 원판의 개수
		start : 출발지
		mid : 옮기기 위해 이동해야 장소
		to : 목적지
	 */
    public static void Hanoi(int N,int start,int mid,int to){

        //원판 개수 1
        if(N == 1){
            sb.append(start+" "+ to+"\n");
            return;
        }
        // STEP 1 : N-1개를 A에서 B로 이동
        Hanoi(N-1,start,mid,to);

        // STEP 2 : 1개를 A에서 C로 이동
        sb.append(start+ " "+to+"\n");

        // STEP 3 : N-1개를 B에서 C로 이동
        Hanoi(N-1,mid,start,to);
    }
}
