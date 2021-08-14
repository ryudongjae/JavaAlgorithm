package programmers;

/**
 * 거스름돈
 */
public class ChangeMoney {
    public int solution(int n, int[] money) {
        int []answer = new int[100001];
        answer[0] = 1;
        for (int i : money) {
            for(int j = i; j <= n; j++){
                answer[j] += answer[j-i];
            }
        }
        return answer[n];
    }
}
