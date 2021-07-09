package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    static int N;
    static boolean[] visit;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        arr = new int[N+1][N+1];

        for(int i=1; i<N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(1, 0);
        System.out.println(min);
    }

    //조합
    static void comb(int start, int count) {
        if(count == N/2) {

            min = Math.min(min,Ability());
            return;
        }

        for(int i = start; i < N+1; i++) {
            if(visit[i] != true) {
                visit[i] = true;
                comb(i+1, count+1);
                visit[i] = false;
            }
        }
    }

    //능력치 차이
    static int Ability() {
        int start = 0;
        int link = 0;

        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                // 스타트
                if(visit[i] && visit[j])
                    start += arr[i][j];

                // 링크
                if(visit[i] != true && visit[j] != true)
                    link += arr[i][j];
            }
        }

        return Math.abs(start - link);
    }
}

