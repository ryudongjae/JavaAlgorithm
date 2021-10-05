package programmers;

import javax.swing.plaf.IconUIResource;

public class N_Queen {
    static int[] col;
    static int answer;
    static int cnt = 0;
    public int solution(int n) {
        answer = 0;
        col = new int[n];
        backTracking(0,n);
        return cnt;
    }

    private void backTracking(int depth,int n) {
        if(depth == n){
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++){
            col[depth] = i;

            if(isPossibility(depth)){
                backTracking(depth+1,n);
            }
        }
    }

    private boolean isPossibility(int depth) {
        for(int i = 0; i < depth; i++){
            if(col[depth] ==  col[i]){
                return false;
            }else if(Math.abs(depth-i) == Math.abs(col[depth]- col[i])){
                return false;
            }
        }
        return true;
    }
}
