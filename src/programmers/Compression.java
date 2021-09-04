package programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Compression {
    public int[] solution(String msg) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();

        char ch = 'A';
        for(int i = 1; i < 27; i++){
            map.put(ch+"",i);
            ch++;
        }

        int startIn = 27;

        boolean flag = false;
        for(int i = 0; i < msg.length(); i++){
            String word = msg.charAt(i)+"";

            while(map.containsKey(word)){
                i++;
                if(i == msg.length()){
                    flag =true;
                    break;
                }

                word += msg.charAt(i);
            }
            if(flag){
                arr.add(map.get(word));
                break;
            }
            arr.add(map.get(word.substring(0,word.length()-1)));
            map.put(word,startIn++);
            i--;
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
