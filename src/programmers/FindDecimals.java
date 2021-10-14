package programmers;

import java.util.ArrayList;

public class FindDecimals {
    static int answer = 0;
    static ArrayList <Integer> arr = new ArrayList<>();
    static boolean[]visited = new boolean[7]; //방문 체크

    public int solution(String numbers) {
        String temp = "";

        for(int i = 1; i <= numbers.length(); i++ ){
            recur(numbers,temp,i);
        }
        for (int x : arr) {
            calc(x);
        }

        return answer;
    }

    private void recur(String numbers, String temp, int i) {
        if (temp.length() == i){
            if(!arr.contains(Integer.parseInt(temp))) arr.add(Integer.parseInt(temp));
            return;
        }

        for(int j = 0; j < numbers.length(); j++){
            if (visited[j]){
                continue;
            }
            temp += numbers.charAt(j);

            visited[j] = true;
            recur(numbers,temp,i);
            visited[j] = false;
            temp = temp.substring(0,temp.length()-1);
        }
    }

    private void calc(int x) {
        if(x == 0)return;
        if(x == 1)return;

        for(int i = 2; i <=Math.sqrt(x); i++){
            if (x%i == 0)return;
        }
        answer++;
    }
}
