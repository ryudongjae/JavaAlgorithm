package programmers;

import java.util.Arrays;

public class SteppingStone {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int left = 0;
        int right = distance;
        int mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            int prev = 0;
            int rmCnt= 0;
            for(int i = 0; i < rocks.length; i++){
                if(rocks[i] - prev < mid){
                    rmCnt++;
                    if(rmCnt > n){
                        break;
                    }
                }else{
                    prev = rocks[i];
                }

            }
            if(rmCnt > n){
                right = mid  -1;
            }
            else{
                answer = answer>mid ? answer:mid;
                left = mid+1;
            }
        }
        return answer;
    }
}
