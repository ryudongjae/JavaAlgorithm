package programmers;

public class Sticker {
    public int solution(int sticker[]) {
        int sl = sticker.length;

        if(sl ==1)return sticker[0];

        int []dp1 = new int[sl];
        int []dp2 = new int[sl];

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i = 2; i < sl -1; i++){
            dp1[i] = Math.max(dp1[i-1],dp1[i-2] + sticker[i]);
        }
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2; i < sl; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + sticker[i]);
        }

        int answer = Math.max(dp1[sl-2], dp2[sl-1]);

        return answer;
    }
}
