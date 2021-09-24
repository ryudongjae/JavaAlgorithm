package programmers;

import java.util.Arrays;
import java.util.Collections;

public class StringDescendingOrder {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        for(int i=0; i< str.length; i++){
            answer+=str[i];
        }
        return answer;
    }
}
