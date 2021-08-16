package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class SurveillanceCamera {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1 == o2)return Integer.compare(o1[1],o2[1]);

                return Integer.compare(o1[0],o2[0]);
            }
        });

        int oc = routes[0][1];

        for(int i = 1; i < routes.length-1; i++){
            if (oc > routes[i][1])oc = routes[i][1];
            if(oc < routes[i+1][0]){
                answer++;
                oc = routes[i+1][1];
            }
        }
        return answer;
    }
}
