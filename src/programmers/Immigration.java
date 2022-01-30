package programmers;

import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 0;
        long right = (long) n *times[times.length-1];//가장 최악의 경우의(오래걸리는) 시간
        while(left <= right){
            long mid = (left+right)/2;
            long sum = 0;// 총 심사한 인원
            for(int i =0; i < times.length; i++){//빨리 심사하는 심사관 순으로 심사처리

                sum +=mid/times[i];
            }
            if(sum < n){ // 해야할 인원보다 심사처리 못함 -> 시간 더 필요
                left = mid+1;
            }else{  // 해야할 인원보다 심사처리 많이함 -> 시간을 줄여서 더 최고 경우의 시간을 만든다.
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
