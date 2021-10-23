package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2);
        String []arr = s.split("\\},\\{");
        String [][] tup = new String[arr.length][1];
        for(int i = 0; i < tup.length; i++){
            tup[i][0] = arr[i];
        }

        Arrays.sort(tup, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].length() < o2[0].length()){
                    return -1;
                }else if(o1[0].length() > o2[0].length()){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < tup.length; i++){
            String[]splitValue = tup[i][0].split(",");
            for(int j = 0; j <  splitValue.length; j++){
                if(!list.contains(Integer.parseInt(splitValue[j]))){
                    list.add(Integer.parseInt(splitValue[j]));
                }
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
