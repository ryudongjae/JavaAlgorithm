package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class RaceTrackConstruction {
    static int n;
    static int [][]visited;
    static int []dx ={-1,0,1,0};
    static int []dy = {0,-1,0,1};
    static int value = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        n = board.length;
        visited = new int[n][n];
        bfs(board);
        return value;
    }

    private void bfs(int[][]board) {

        Queue<Road>que = new LinkedList<>();
        que.add(new Road(0,0,-1,0));
        visited[0][0] = 1;

        while(!que.isEmpty()){
            int qx = que.peek().x;
            int qy = que.peek().y;
            int qDir = que.peek().dir;
            int qPrice = que.poll().cost;

            if(qx == n-1 && qy == n-1){
                value = Math.min(value,qPrice);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                int nDir = i;

                if(nx < 0 || ny < 0 || nx >= n ||ny >= n ||board[nx][ny] == 1)continue;

                int newCost = qPrice;
                if (qDir == -1 || nDir ==qDir)newCost += 100;
                else newCost += 600;

                if(visited[nx][ny] == 0){
                    visited[nx][ny] = newCost;
                    que.add(new Road(nx,ny,nDir,newCost));
                }else if(visited[nx][ny] >= newCost){
                    visited[nx][ny] = newCost;
                    que.add(new Road(nx,ny,nDir,newCost));
                }
            }
        }
    }

    class Road {
        int x,y,dir,cost;

         Road(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
}
