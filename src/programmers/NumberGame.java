package programmers;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);


        for(int i_a = A.length-1 , i_b = B.length-1; i_a >= 0; i_a--) {
            if (B[i_b] > A[i_a]){
                answer++;
                i_b--;
            }
        }
        return answer;
    }
}
