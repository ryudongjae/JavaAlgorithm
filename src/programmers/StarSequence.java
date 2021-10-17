package programmers;

public class StarSequence {
    public int solution(int[] a) {
        int answer = 0;
        int[] cnt = new int[a.length+1];
        for(int i = 0; i < a.length; i++){
            cnt[a[i]]++;
        }
        for(int i = 0; i < a.length; i++){
            if (cnt[i] * 2 <=  answer)continue;
            int star = 0;
            for (int j = 0; j < a.length -1; j++){
                if ((a[j] == i || a[j+1]==i)&&(a[j] != a[j+1])){
                    star+=2;
                    j++;
                }
            }
            answer =  Math.max(answer,star);
        }
        return answer;
    }
}
