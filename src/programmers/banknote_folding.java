package programmers;

import java.util.Arrays;
import java.util.OptionalInt;

public class banknote_folding {
    public static void main(String[] args) {
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        System.out.println(solution(wallet, bill));
    }

    public static int solution(int[] wallet, int[] bill) {
        int answerCnt = 0;
        boolean cntCheck = false;
        int max = Arrays.stream(bill).max().getAsInt();
        int min = Arrays.stream(bill).min().getAsInt();

        //계산하지 않아도 들어가는 지폐인지 확인
        if (compareSize(max,min,wallet,bill)) {
            return 0;
        }

        while (!cntCheck) {
            answerCnt++;
            //계속 큰 값을 나누기위해 큰값 탐색
            if (min > max) {
                min = min / 2;
            } else {
                max = max / 2;
            }
            //크기 비교
            if (compareSize(max,min,wallet,bill)) {
                cntCheck = true;
            }

        }
        return answerCnt;
    }

    public static boolean compareSize(int max, int min, int[] wallet, int[] bill){
        if ((max <= wallet[0] && min <= wallet[1]) || (max <= wallet[1] && min <= wallet[0])) {
            return true;
        }
        return false;
    }
}
