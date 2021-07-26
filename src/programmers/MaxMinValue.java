package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class MaxMinValue {
    public String solution(String s) {
        ArrayList<Integer> sList = new ArrayList<>();
        String [] str = s.split(" ");

        for(int i = 0 ; i < str.length; i++){
            sList.add(Integer.parseInt(str[i]));
        }
        String answer = ""+ Collections.min(sList)+""+ Collections.max(sList);
        return answer;
    }
}

class SubCode{
    public String sol(String s){
        String[] str =s.split(" ");
        int n,max,min;
        max = min =Integer.parseInt(str[0]);

        for (int i = 0; i< str.length; i++){
            n = Integer.parseInt(str[i]);
            if(max < n)max = n;
            if (min> n)min = n;

        }
        return min+" "+ max;
    }

}
