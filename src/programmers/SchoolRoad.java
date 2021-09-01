package programmers;

public class SchoolRoad {
    public int solution(int m, int n, int[][] puddles) {
        int [][] road = new int[n][m];
        int mod = 1000000007;
        for (int[] puddle : puddles) {
            road[puddle[1] - 1][puddle[0]-1] = -1;
        }

        road[0][0] = 1;

        for(int i = 0; i < n; i++){
            for (int j =0; j < m; j++ ){
                if (road[i][j] == -1){
                    road[i][j] = 0;
                    continue;
                }
                if(i != 0){
                    road[i][j] += road[i-1][j] % mod;
                }
                if(j != 0){
                    road[i][j] += road[i][j-1] % mod;
                }
            }
        }

        return road[n-1][m-1] % mod;
    }
}
