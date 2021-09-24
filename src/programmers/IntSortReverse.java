package programmers;

import java.util.Arrays;

public class IntSortReverse {
    public long solution(long n) {
        String []arr = String.valueOf(n).split("");
        StringBuilder sb = new StringBuilder();

        Arrays.sort(arr);

        for(int i = arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }

        return Long.parseLong(sb.toString());
    }
}
