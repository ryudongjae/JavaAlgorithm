package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
    public int[] solution(String s) {
        s = s.substring(2,s.length()-2);  //처음과 마지막 특수기호 없애기
        String []arr = s.split("\\},\\{");
        String [][] tup = new String[arr.length][1];
        for(int i = 0; i < tup.length; i++){
            tup[i][0] = arr[i];  //기호를 뺀 값을 2차원 배열에 삽입
        }

        Arrays.sort(tup, new Comparator<String[]>() { //길이 정렬
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
            String[]splitValue = tup[i][0].split(",");  //하나씩 나눈다.
            for(int j = 0; j <  splitValue.length; j++){
                if(!list.contains(Integer.parseInt(splitValue[j]))){  //이미 값이 들어가 있는지 여부
                    list.add(Integer.parseInt(splitValue[j]));
                }
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();  //arraylist를 int[]로 변환
        return answer;
    }
}
