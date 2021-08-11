package programmers;

public class Carpet {
    public int[] solution(int brown, int red) {

        int height = 0;
        int width = 0;
        for (height = 3; height <= (int) (brown + 4) / 2; height++) {

            width = ((brown + 4) / 2) - height;
            if (width < height) {
                break;
            }

            int redCount = (width - 2) * (height - 2);
            if (red == redCount) {
                break;
            }
        }

        int[] answer = new int[] { width, height };
        return answer;
    }
}
