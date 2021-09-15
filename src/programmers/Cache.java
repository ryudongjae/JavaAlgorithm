package programmers;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class Cache {
    static final int hit = 1;
    static final int miss = 5;
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0)return cities.length * 5;
        int answer = 0;

        LinkedList<String>cache = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toUpperCase();

            if(cache.remove(city)){ //객체가 있으면 true 반환
                cache.addFirst(city);
                answer+=hit;
            }else{
                int currentSize = cache.size();

                if(currentSize == cacheSize){
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer+=miss;
            }
        }
        return answer;
    }
}
