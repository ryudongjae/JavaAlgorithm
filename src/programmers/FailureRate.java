package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        int[] answer =new int[N];
        double [] stage = new double[N+1];

        for (int i : stages) {
            if( i == N+1){
                continue;
            }
            stage[i] ++;
        }

        ArrayList<Double> failure = new ArrayList<>();
        double num = stages.length;
        double value = 0;

        for(int i = 1; i < stage.length; i++){
            value = stage[i];
            if (num == 0){
                stage[i] = 0;
            }else{
                stage[i] = stage[i]/num;
                num =num-value;

            }
            failure.add(stage[i]);
        }

        Collections.sort(failure,Collections.reverseOrder());

        for (int i = 0; i< failure.size(); i++){
            for(int j = 1; j < stage.length; j++){
                if(failure.get(i) == stage[j]){
                    answer[i] = j;
                    stage[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
