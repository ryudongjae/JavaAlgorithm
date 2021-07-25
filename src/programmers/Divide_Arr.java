package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Divide_Arr {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0){
                result.add(arr[i]);
            }
        }
        if (result.isEmpty()){
            result.add(-1);
        }
        int[] answer = new int[result.size()];

        for(int i = 0; i< result.size(); i++){
            answer[i] = result.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}

/**
 * 참고한 코드인데
 * 그저 감탄 밖에 안나온다 이렇게 생각하는 사람들도 있구나..........
 */
class sol{
    public int[] solution(int[] arr, int divisor) {

        return Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
    }
}
