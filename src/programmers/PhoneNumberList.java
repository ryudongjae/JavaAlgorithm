package programmers;

import java.util.HashMap;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String,Integer> map = new HashMap<>();
        //배열 해싱 (해시맵에 추가)
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i],i);
        }

        for(int i = 0; i< phone_book.length; i++){
            for(int j = 1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}

