package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 야근 지수
 */
public class Night_Work {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Long> Nw = new PriorityQueue<>(Collections.reverseOrder());//Collections.reverseOrder() 내림 차순으로 정렬.

        long sum = 0;
        for (long work : works) {
            Nw.add(work);
            sum+=work;
        }
        if(sum <= n) return 0;

        for(int i =0; i<n; i++){
            long now = Nw.poll();
            if(now ==0 )break;
            Nw.add(now-1);
        }

        for (Long s : Nw) {
            answer +=Math.pow(s,2);
        }
        return answer;

    }
}
