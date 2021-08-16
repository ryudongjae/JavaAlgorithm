package programmers;

public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;

        int n_cnt = Integer.bitCount(n); //bitCount메서드는 2진수로 변환한 뒤 ,2진수에 포함된 1을 카운팅해주는 메서드
        int b_cnt = 0;

        while (true){
            n++;

            b_cnt = Integer.bitCount(n);

            if(n_cnt == b_cnt){
                answer = n;
                break;
            }
        }
        return answer;
    }
}
