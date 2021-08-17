package programmers;

public class SteppingBridge {
    public int solution(int[] stones, int k) {
        int low = 1;
        int high = 200000000;
        int mid = 0;
        int answer = 0;

        while(low <= high){
            mid = (low + high) / 2;

            if(!cross(stones, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }

        return answer;
    }

    boolean cross(int[] stones, int k,int mid){
        //못 건너는 징검다리수
        int cnt = 0;

        for(int stone : stones){
            // 디딤돌의 숫자 - 건너는 친구의 수
            // 0보다 작으면 건널 수 없음을 의미
            if(stone  - mid< 0){
                cnt++;
            }
            else{
                cnt = 0;
            }
            if (cnt == k){
                return false;
            }
        }

        return true;
    }
}
