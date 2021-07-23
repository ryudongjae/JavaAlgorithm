package programmers;

public class Gymsuit {
}

class solution {
    public int solution(int n, int[] lost, int[] reserve) {
       int[] all = new int[n];

       for(int i : reserve){
           all[i-1]++;
       }

       for(int i : lost){
           all[i-1]--;
       }

       for(int i = 0; i< all.length; i++){
           if(all[i] < 0){
               if (i != all.length -1 && all[i+1] > 0 ){
                   all[i]++;
                   all[i+1]--;
               }else if(i != 0 && all[i-1] > 0){
                   all[i]++;
                   all[i-1]--;
               }
           }
       }
       int answer = 0;

       for(int i = 0; i < all.length; i++){
           if (all[i] >=0){
               answer++;
           }
       }
       return answer;
    }
}
