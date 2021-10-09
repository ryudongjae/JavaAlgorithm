package programmers;

import java.util.ArrayList;

public class EndingInEnglish {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> result = new ArrayList<>();
        boolean check = true;

        for(int i = 0; i < words.length; i++){
            if(result.contains(words[i])){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                check = false;
                break;
            }
            result.add(words[i]);

            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                check = false;
                break;
            }
        }
        if (check){
            return new int[]{0,0};
        }
        return answer;
    }
}
