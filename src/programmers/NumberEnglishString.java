package programmers;

import java.util.HashMap;

public class NumberEnglishString {
    public int solution(String s) {
        String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
        String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i = 0; i < 10; i++){
            s = s.replace(num[i],nums[i]);
        }
        return Integer.parseInt(s);
    }
}
