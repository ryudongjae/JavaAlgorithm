package programmers;

public class delivery {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int [][] val = new int[N][N];
        for(int i = 0; i < val.length;i++){
            for(int j = 0; j < val[0].length; j++){
                if (i == j){
                    val[i][j] = 0;
                    continue;
                }
                val[i][j] = 500001;
            }
        }
        for(int i = 0; i < road.length; i++){
            if (val[road[i][0]-1][road[i][1]-1] < road[i][2])continue;
            val[road[i][0]-1][road[i][1]-1] = road[i][2];
            val[road[i][1]-1][road[i][0] -1] = road[i][2]; //양방향이 가능하므로 양쪽으로 값을 삽입
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    if (j == k) continue;
                    if (val[j][k] > val[j][i]+val[i][k]){
                        val[j][k] = val[j][i]+val[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < val[0].length; i++){
            if (val[0][i] <= K){
                answer++;
            }
        }
        return answer;
    }
}
