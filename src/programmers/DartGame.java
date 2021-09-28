package programmers;

public class DartGame {
    public int solution(String dartResult) {
        int [] scr = new int[3];
        char[] darts = dartResult.toCharArray();
        int answer = -1;

        for(int i = 0; i < darts.length; i++){
            if (darts[i] >= '0' && darts[i] <= '9'){
                answer++;
                if(darts[i] == '1' && darts[i+1] =='0'){
                    scr[answer] = 10;
                    i++;
                }else{
                    scr[answer] = darts[i] -'0';
                }
            }else if (darts[i] == 'D'){
                scr[answer] *= scr[answer];
            }else if (darts[i] == 'T') {
                scr[answer] *= scr[answer] *scr[answer];
            }else if (darts[i] == '*'){
                if(answer > 0){
                    scr[answer-1] *=2;
                }
                scr[answer] *= 2;
            }else if(darts[i] == '#'){
                scr[answer]*= -1;
            }
        }
        return scr[0] +scr[1] + scr[2];
    }
}
