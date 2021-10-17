package programmers;

public class N_DP {

    static int n;
    static int target;
    static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0,0);
        return answer == Integer.MAX_VALUE ? -1: answer;
    }

    private void dfs(int count, int prev) {
        if (count > 8){
            answer = -1;
            return;
        }

        if (prev == target){
            answer =Math.min(answer,count);
            return;
        }

        int tN = n;
        for(int i = 0; i < 8- count; i++){
            int newCount = count + i + 1;
            dfs(newCount,prev+tN);
            dfs(newCount,prev-tN);
            dfs(newCount,prev/tN);
            dfs(newCount,prev*tN);

            tN = tN *10+n;
        }
    }
}
