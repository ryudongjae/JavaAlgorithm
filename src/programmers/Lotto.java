package programmers;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int result = 0, cnt = 0;
        int[] answer = new int[2];
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                cnt++;
            }
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    result++;
                    break;
                }
            }
        }
        answer[0] = locheck(result + cnt);
        answer[1] = locheck(result);

        return answer;
    }

    private static int locheck(int val) {
        switch (val){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                 return 5;
            default:
                return 6;
        }
    }
}
