package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();


        for(int i =progresses.length-1; i >= 0; i--){
            stack.add((100 - progresses[i])/speeds[i] + ((100 - progresses[i])%speeds[i] > 0 ? 1:0));
        }

        List<Integer> li =  new ArrayList<>();

        while (!stack.isEmpty()){
            int count  = 1;
            int top = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= top){
                count++;
                stack.pop();
            }
            li.add(count);
        }
        int[] answer = new int[li.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = li.get(i);
        }
        return answer;
    }
}
