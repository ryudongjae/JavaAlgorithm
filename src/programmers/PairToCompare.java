package programmers;

import java.util.Stack;

public class PairToCompare {
    public int solution(String s) {
        Stack<Character> stack  = new Stack<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c)stack.pop();
            else stack.push(c);
        }


        return stack.isEmpty()?1:0;
    }
}
