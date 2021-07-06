package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_9663 {
    public static int N;
    public static int [] arr;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(cnt);


    }
    public static void nQueen(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth]= i;
            if (possibility(depth)){

                //가능한 위치면 재귀 호출
                nQueen(depth+1);
            }
        }

    }

    public static boolean possibility(int col){

        for(int i = 0; i < col; i++ ){
            // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if(arr[col] == arr[i]){
                return false;
            }

            //열끼리 연산 값과 행끼리 연산값이 같으면 대각선 위치함으로 false
            else if (Math.abs(col-i)==Math.abs(arr[col] - arr[i])){
                return false;
            }
        }

        return true;
    }
}
