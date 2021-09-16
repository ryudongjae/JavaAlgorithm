package programmers;

import java.util.ArrayList;

public class NoEqualsNumber {
    public int[] solution(int []arr) {
        ArrayList<Integer> itn = new ArrayList<>();

        int num = 10;
        for(int i = 0; i < arr.length; i++){


            if(arr[i] != num){
                itn.add(arr[i]);
                num = arr[i];
            }
        }
        int[] answer = new int[itn.size()];
        for(int i = 0; i< answer.length; i++){
            answer[i] = itn.get(i);
        }
        return answer;
    }
}
