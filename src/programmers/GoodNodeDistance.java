package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GoodNodeDistance {
    public int solution(int n, int[][] edge) {
        boolean[] check = new boolean[n];
        boolean[][] connect = new boolean[n][n];
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < edge.length; i++){
            connect[edge[i][0]-1][edge[i][1]-1]=true;
            connect[edge[i][1]-1][edge[i][0]-1]=true;
        }
        check[0] = true;
        que.add(0);

        int answer = 0;
        while (!que.isEmpty()){
            int queSize = que.size();
            for(int i = 0;  i < queSize;i++){
                int node = que.poll();
                for(int j = 0; j < n; j++){
                    if(connect[j][node] && !check[j]){
                        check[j] = true;
                        que.add(j);
                    }
                }
            }
            answer = queSize;
        }
        return answer;
    }
}
