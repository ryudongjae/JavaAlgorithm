package programmers;

import java.util.Stack;

public class ParenthesisConversion {
    int position;
    public String solution(String p) {
        if (p.isEmpty())return p;

        boolean correct = isCorrect(p);

        String u = p.substring(0,position);
        String v = p.substring(position,p.length());

        if(correct){
          return u + solution(v);
        }

        String result= "(" + solution(v) + ")";

        for(int i = 1; i < u.length()-1; i++){
            if(u.charAt(i) == '('){
                result += ")";
            }else {
                result += "(";
            }
        }
        return result;
    }

    boolean isCorrect(String s){
        boolean ret = true;
        int left = 0; int right = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <  s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
                stack.add('(');
            }else{
                right++;
                if(stack.isEmpty()){
                    ret = false;
                }else{
                    stack.pop();
                }
            }
            if (left == right){
                position = i+1;
                return ret;
            }
        }
        return true;
    }
}
