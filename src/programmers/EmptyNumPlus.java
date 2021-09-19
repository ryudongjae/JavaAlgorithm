package programmers;

import java.util.Arrays;

public class EmptyNumPlus {
    public int solution(int[] numbers) {
        int answer = 0;
        int num = 0;
        for(int i = 0; i < numbers.length; i++){
            num += numbers[i];
        }
        answer = 45 - num;
        return answer;
    }
}
