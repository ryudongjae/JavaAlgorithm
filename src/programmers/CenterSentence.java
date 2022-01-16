package programmers;

public class CenterSentence {
    public String solution(String s) {
        String answer = "";
        String[] string  = s.split("");
        if(string.length%2 != 0 ){
            answer = string[s.length()/2];
        } else {
            answer += string[(s.length()/2)-1];
            answer += string[s.length()/2];
        }
        return answer;
    }
}
