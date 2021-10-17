package programmers;

import java.util.ArrayList;
import java.util.List;

public class N2ArrCut {
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> arr = new ArrayList<>();
        for(long i = left; i < right+1; i++){
            arr.add((int) (Math.max(i/n,i%n)+1));
        }
        return arr;
    }
}
