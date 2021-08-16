package programmers;

public class CorrectParenthesis {
    boolean solution(String s) {
        boolean answer = false;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='('){
                cnt++;
            }
            else{
                if (cnt <= 0 )return false;
                cnt--;
            }
        }

        if (cnt == 0)return true;

        return answer;
    }
}
