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
