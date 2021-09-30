package programmers;

public class CenterNumberPick {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        if(s.length()%2 != 0){
            answer = str[s.length()/2];
        }else{
            answer += str[(s.length()/2) -1];
            answer+= str[s.length()/2];
        }
        return answer;
    }
}
