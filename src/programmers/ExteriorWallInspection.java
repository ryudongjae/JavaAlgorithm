package programmers;

public class ExteriorWallInspection {
    private int n,answer;
    private int[] weak,dist,spreadWeak;
    private boolean finish;
    public int solution(int n, int[] weak, int[] dist) {

        this.n = n; this.weak = weak; this.dist = dist;

        makeSpreadWeak();
        finish = false;
        answer = Integer.MAX_VALUE;

        for(int i = 1; i <= dist.length; i++){
            permutation(0,i,new boolean[dist.length], new int[i]);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    //친구로 순열 생성
    private void permutation(int depth, int num, boolean[] visited, int[] result) {
        if (finish){
            return;
        }
        if (depth == num){
            checkIfCanCover(result);
            return;
        }
        for(int i = 0; i < dist.length; i++){
            if(!visited[i]){
                result[depth] = dist[i];
                visited[i] = true;
                permutation(depth+1,num,visited,result);
                visited[i] = false;
            }
        }
    }

    private void checkIfCanCover(int[] result) {
        //시작점 i 기준으로 한바퀴돈다.
        for(int i = 0; i < weak.length; i++){
            int start = i;
            boolean flag = true;

            //친구 수 만큼 돈다.
            for(int k = 0; k <  result.length; k++){
                //취약 지점 개수만큼
                for(int j = i; j < i +weak.length; j++){
                    //두 점 사이의 거리가 검사가능한 거리보다 크면 ,커버할 수 없음 => 다른 친구 검사
                    //이전 지점은 검사 완료했으므로 현재 지점을 시작점으로 지정
                    if(spreadWeak[j] - spreadWeak[start] > result[k]){
                        start = j;
                        k++;

                        if(k == result.length){
                            flag = false;
                            break;
                        }
                    }
                }

                //주어진 사람으로 전체 취약지점을 커버할 수 있다면 더이상 검사를 진행할 필요가 없다.
                if(flag){
                    answer = k +1;
                    finish = true;
                    return;
                }
            }
        }
    }

    private void makeSpreadWeak() {
        int len = weak.length;
        spreadWeak = new int[len * 2 -1];

        for(int i = 0; i <len; i++){
            spreadWeak[i] = weak[i];
        }

        for(int i = 0; i <len -1; i++){
            spreadWeak[i+len] = weak[i]+n;
        }
    }
}
