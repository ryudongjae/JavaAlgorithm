package programmers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scov = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            scov.offer(scoville[i]);
        }

        while (scov.peek() < K) {
            if (scov.size() < 2) return -1;

            int val1 = scov.poll();
            int val2 = scov.poll();
            int result = val1 + (val2 * 2);
            scov.offer(result);
            answer++;
        }

        return answer;
    }
}
