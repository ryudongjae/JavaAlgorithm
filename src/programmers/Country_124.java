package programmers;

public class Country_124 {
    public String solution(int n) {
        String[] country = {"4","1","2"};
        String answer = "";

        while (n > 0){
            answer = country[n%3] + answer;
            n = (n-1)/3;
        }
        return answer;
    }
}
