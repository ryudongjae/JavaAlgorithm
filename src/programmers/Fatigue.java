package programmers;

public class Fatigue {

    boolean [] isVisited;
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dungeonsCount(dungeons, k , 1);
        return max;
    }

    private void dungeonsCount(int[][] dungeons, int k, int depth) {
        for(int i = 0; i < dungeons.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                if(k >= dungeons[i][0]){
                    max = Math.max(max,depth);
                    dungeonsCount(dungeons, k - dungeons[i][1], depth+1);

                }
                isVisited[i] =  false;
            }
        }
    }
}
