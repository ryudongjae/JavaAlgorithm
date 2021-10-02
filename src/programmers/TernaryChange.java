package programmers;

import java.util.ArrayList;

public class TernaryChange {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> value = new ArrayList<>();
        while (true){
            if(n<3) {
                value.add(n);
                break;
            }
            value.add(n%3);
            n = n/3;
        }

        for(int i = 0; i < value.size(); i++){
            answer+=(Math.pow(3,value.size()-i-1)*value.get(i));
        }
        return answer;
    }
}
