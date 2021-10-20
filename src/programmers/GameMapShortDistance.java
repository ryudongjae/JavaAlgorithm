package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortDistance {
    public int solution(int[][] maps) {
        int answer,x,y,nx,ny;
        int [] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        int n = maps.length; int m = maps[0].length;
        boolean[][]visited = new boolean[n][m];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);que.offer(0);
        visited[0][0] = true;
        while(!que.isEmpty()){
            x = que.poll();
            y = que.poll();

            for (int i = 0; i < dx.length; i++){
                nx = x + dx[i];
                ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
                if (maps[nx][ny] == 0) continue;
                if (!visited[nx][ny]){
                    que.offer(nx);
                    que.offer(ny);
                    maps[nx][ny] = maps[x][y]+1;
                    visited[nx][ny] = true;
                }
            }
        }
        if (maps[n-1][m-1] == 1)answer = -1;
        answer = maps[n-1][m-1];

        return answer;
    }
}
