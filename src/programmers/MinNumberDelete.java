package programmers;

import java.util.*;

public class MinNumberDelete {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length == 1) return new int[]{-1};
        for (int i : arr) {
            list.add(i);
        }
        Integer min = Collections.min(list);
        list.remove(min);
        answer = new int[arr.length-1];
        for(int i = 0; i <list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
