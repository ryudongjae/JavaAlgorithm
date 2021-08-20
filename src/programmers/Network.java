package programmers;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers[0].length]; //방문 여부
        for(int i = 0; i < n; i++){
            if (!visited[i]){  //방문하지 않았으면 dfs
                dfs(computers,visited,i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int n) {
        visited[n] = true;
        for(int i = 0; i < computers[0].length; i++){
            if(!visited[i] && computers[n][i] == 1){
                dfs(computers,visited,i);
            }
        }
    }
}
