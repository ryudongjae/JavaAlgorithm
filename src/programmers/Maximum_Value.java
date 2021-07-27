package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 가장 큰 수
 */
public class Maximum_Value {
    public String solution(int[] numbers) {
        StringBuilder  sb = new StringBuilder();
        String[] value  = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            value[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(value, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(value[0].equals("0")){
            return "0";
        }
        for (String s : value) {
            sb.append(s);
        }
        String answer =sb.toString();

        return answer;
    }
}
