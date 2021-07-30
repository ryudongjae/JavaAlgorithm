package programmers;

import java.util.Arrays;

public class Average {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i = 0; i < arr.length; i++ ){
            answer += arr[i];

        }
        return answer/ arr.length;
    }


    public int getMean(int[] arr) {
        return (int) Arrays.stream(arr).average().orElse(0);
    }
}
