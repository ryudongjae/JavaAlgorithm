package programmers;

/**
 * 예상 대진표
 */
public class Tournament {
    public int solution(int n, int a, int b){
        int answer = 0;
        while(a != b){
            answer++;
            a = (a+1)/2;
            b = (b+1)/2;
        }
        return answer;
    }
}
