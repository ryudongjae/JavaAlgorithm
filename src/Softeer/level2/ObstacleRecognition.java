package Softeer.level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ObstacleRecognition {

    //map size
    static int N ;
    static int vector[][];

    //map
    static char arr[][];
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new char[N][N];
        for(int i=0;i<N;i++){
            arr[i] = in.readLine().toCharArray();
        }

        //탐색
        ArrayList<Integer> count = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //map에서 1인 경우에만 주변 탐색
                //블록 별로 카운트가 되어야함
                if(arr[i][j]=='1'){
                    count.add(bfs(i,j));
                }
            }
        }

        //출력
        StringBuilder sb = new StringBuilder();
        sb.append(count.size()).append('\n');
        Collections.sort(count);
        for(int cnt:count){
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }

    //해당 위치에 방문한 적 있는지 확인
    public static boolean isCheck(int x , int y){
        return x >= 0 && y >= 0 && x < N && y < N && arr[x][y] == '1';
    }

    public static int bfs(int x, int y) {
        int count = 0;  // 블록의 크기 카운트
        Queue<int[]> queue = new ArrayDeque<>();  // BFS에 사용할 큐 선언
        queue.offer(new int[]{x, y});  // 시작점 큐에 추가
        arr[x][y] = '0';  // 방문 처리 (방문한 위치를 0으로 바꿈)

        int[] now;
        int ni, nj;

        while (!queue.isEmpty()) {
            count++;  // 블록 크기 증가
            now = queue.poll();  // 큐에서 현재 위치 꺼냄

            for (int[] d : vector) {  // 상하좌우 탐색
                ni = now[0] + d[0];  // 새로운 x 좌표
                nj = now[1] + d[1];  // 새로운 y 좌표
                if (isCheck(ni, nj)) {  // 해당 좌표가 유효하고 장애물이 있는지 확인
                    queue.offer(new int[]{ni, nj});  // 큐에 추가하여 다음 탐색 진행
                    arr[ni][nj] = '0';  // 방문 처리
                }
            }
        }

        return count;  // 해당 블록의 크기 반환
    }

}
