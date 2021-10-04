package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class _8Weekend {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_L = 0;
        int max_H = 0;
        for(int i = 0; i <  sizes.length; i++){
            int l = Math.max(sizes[i][0],sizes[i][1]);
            int h = Math.min(sizes[i][0],sizes[i][1]);
            max_L = Math.max(max_L,l);
            max_H = Math.max(max_H,h);
        }
        return answer = max_H*max_L;
    }
}
