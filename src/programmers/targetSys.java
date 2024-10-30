package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

//우선 범위를 잡아야하는데,,,,,,,
//[[1,4],[3,7],[4,5],[4,8],[10,14],[11,13],[5,12]]
public class targetSys {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] ints = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(solution(ints));
    }
    public static int solution(int[][] targets) {
        int answer = 0;
        int target = 0;
        Arrays.sort(targets,((o1, o2) -> o1[1] - o2[1]));
        for(int i = 0; i < targets.length;  i++){
            if (targets[i][0]< target)continue;
            target = targets[i][1];
            answer++;
        }
        return answer;
    }

}
