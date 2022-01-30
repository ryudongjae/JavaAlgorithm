package programmers;

import java.util.ArrayList;


public class LineWay {
    public int[] solution(int n, long k) {
        int[] result = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long fac = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }

        int idx = 0;
        long remain = k - 1;
        while (idx < n) {
            fac = fac / (n - idx);
            long value = remain / fac;
            result[idx++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % fac;
        }

        return result;
    }
}
/**
 첫번째 숫자가 n! / n 번 나오는 것을 확인했다.이렇게 첫번째 숫자는 쉽게 구할 수 있다. k=7 이므로 첫번째 숫자는 2이다. 이는 배열 [1,2,3,4]의 1번 인덱스이다.
 n! /n 번씩 첫번째 숫자가 나오고 k는 1부터 시작하므로 첫번째 숫자의 배열 인덱스는 (k-1)/(n!/n), 즉 (k-1) / (n-1)!이다.
 처음엔 순열을 구성하는 요소가 [1,2,3,4] 였고, 첫번째 숫자가 구해진 뒤에는 같은 방법으로, 중복을 제외한 요소 [1,3,4]중에, k = (k-1) % (n-1)!를 통해 구해짐을 알 수 있었다.
*/