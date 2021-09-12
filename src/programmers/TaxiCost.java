package programmers;

public class TaxiCost {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][]node = new int[n+1][n+1];
        for(int i = 1; i< n+1; i++){
            for(int j = 1; j <n+1; j++){
                node[i][j] = 20000001;
            }
            node[i][i] = 0;
        }

        //node 배열에 지점간의 거리 입력하기 (양방향)
        for(int i = 0; i < fares.length; i++){
            node[fares[i][0]][fares[i][1]] = fares[i][2];
            node[fares[i][1]][fares[i][0]] = fares[i][2];
        }


        for(int i = 1; i < n+1; i++){ //경유하는 노드
            for(int j = 1; j < n+1; j++){
                for(int k =1; k < n+1; k++){
                    if (node[j][k] > node[j][i] + node[i][k]){
                        node[j][k] = node[j][i] + node[i][k];//경유해서 가는 값이 더 작다면 노드값을 갱신해준다.
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i< n+1; i++){
            answer = Math.min(answer,node[s][i] + node[i][a] + node[i][b]);
        }
        return answer;
    }
}
