package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public int solution(int[][] jobs) {
        int cnt = 0;
        int answer = 0;
        int now = 0;

        Arrays.sort(jobs,(((o1, o2) -> o1[0] - o2[0])));
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int i = 0;

        while ((cnt < jobs.length)){
            while (i< jobs.length&&jobs[i][0] <= now){
                queue.add(jobs[i++]);
            }
            if(queue.isEmpty()){
                now = jobs[i][0];
            }else{
                int[] temp = queue.poll();
                answer+= temp[1] + now - temp[0];
                now+=temp[1];
                cnt++;
            }
        }
        return answer/ jobs.length;
    }
}
