package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BeakJoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int [][] room = new int[N][2];

        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]- o2[1];
            }
        });

        int cnt = 0;
        int end_time = 0;

        for(int i = 0; i < N; i++){
            if(end_time <= room[i][0]){  //endtime 값이 회의 시작 시간보다 작다면
                end_time = room[i][1];      //그 회의에 끝나는 시간을 endtime로 정의
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
