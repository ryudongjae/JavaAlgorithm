package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingTheBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int answer = 0;
        int nowWeight = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){
            int truck = truck_weights[i];

            while (true){
                if (que.isEmpty()){
                    que.add(truck);
                    nowWeight += truck;
                    time++;
                    break;
                }
                else if(que.size() == bridge_length){
                    nowWeight -=que.poll();
                }

                else{
                    if (truck + nowWeight <=  weight){
                        que.add(truck);
                        nowWeight += truck;
                        time++;
                        break;
                    }else{
                        que.add(0);
                        time++;
                    }
                }
            }
        }
        answer = time + bridge_length;
        return answer;
    }
}
