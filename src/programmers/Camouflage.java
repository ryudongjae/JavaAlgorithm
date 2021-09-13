package programmers;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hash = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            hash.put(clothes[i][1],hash.getOrDefault(clothes[i][1],0)+1);
        }
        for (String s : hash.keySet()) {
            answer *= (hash.get(s)+1);
        }
        answer--;

        return answer;
    }
}
