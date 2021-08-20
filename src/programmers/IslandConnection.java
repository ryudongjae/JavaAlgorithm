package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnection {
    int[] findParent;

    public int find(int child){
        if(findParent[child] == child){
            return child;
        }else{
            return findParent[child] = find(findParent[child]);
        }
    }
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[2];
                Integer b = o2[2];
                return a.compareTo(b);
            }
        });

        findParent = new int[n];
        for(int i = 0; i < n; i++){
            findParent[i] = i;
        }

        int answer = 0;
        for(int i = 0; i < costs.length; i++){
            int firstIsland = find(costs[i][0]);
            int secondIsland = find(costs[i][1]);
            if(firstIsland != secondIsland ){
                findParent[secondIsland] = firstIsland;
                answer+= costs[i][2];
            }
        }
        return answer;
    }
}
