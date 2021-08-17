package programmers;

/**
 * 카펫
 */
public class Carpet {
    public int[] solution(int brown, int red) {
        int[] answer = {};
        int sum = brown + red;

        for(int i = 3; i <= sum; i++){
            if(sum %i == 0){
                int col = sum /i; //가로
                int row = sum / col; //세로


                int a = col -2;  //red의 가로
                int b = row -2;  //red의 세로

                if(a*b ==red && col >= row){
                    return new int[]{col,row};
                }
            }
        }

        return answer;
    }
}
