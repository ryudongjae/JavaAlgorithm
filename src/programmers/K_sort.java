package programmers;

import java.util.Arrays;

public class K_sort {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            int[] result = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(result);
            answer[i] = result[commands[i][2]-1];

        }
        return answer;
    }
}
