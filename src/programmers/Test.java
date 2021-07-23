package programmers;

import java.util.ArrayList;

/**
 * 모의고사
 */
public class Test {
    public int[] solution(int[] answers) {

        int [] per1 = {1,2,3,4,5};
        int [] per2 = {2,1,2,3,2,4,2,5};
        int [] per3 = {3,3,1,1,2,2,4,4,5,5};

        int [] cnt = {0,0,0};

        for(int i = 0; i< answers.length; i++){
            if(per1[i% per1.length] == answers[i])cnt[0]++;
            if(per2[i% per2.length] == answers[i])cnt[1]++;
            if(per3[i% per3.length] == answers[i])cnt[2]++;
        }
        int max = 0;
        for(int i = 0; i < 3; i++){
            if (cnt[i] > max){
                max = cnt[i];
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(cnt[i] == max){
                temp.add(i+1);
            }
        }

        int[] answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}
