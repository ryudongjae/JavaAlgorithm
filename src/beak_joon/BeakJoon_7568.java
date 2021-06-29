package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [][] arr = new int[N][2];

        String[] str;

        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]); //몸무게
            arr[i][1] = Integer.parseInt(str[1]); //키

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int rank = 1;

            for(int j = 0; j < N; j++){
                if(i==j)continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[i][j]){
                    rank ++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.println(sb);
    }
}
