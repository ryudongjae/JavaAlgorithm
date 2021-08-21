package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {
    static boolean[] use;
    static ArrayList<String>answers;
    public String[] solution(String[][] tickets) {
        use = new boolean[tickets.length];
        answers = new ArrayList<String>();
        int count =0;
        dfs("ICN","ICN",count,tickets);
        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    public void dfs(String prev,String answer,int count,String[][] tickets){
        if(count == tickets.length){
            answers.add(answer);
            return;
        }

        for (int i = 0; i< tickets.length; i++){
            if (!use[i] &&tickets[i][0].equals(prev)){
                use[i] =true;
                dfs(tickets[i][1],answer+" "+tickets[i][1],count+1,tickets);
                use[i] =false;
            }
        }
        return;
    }
}
