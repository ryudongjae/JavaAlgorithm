package programmers;

public class MutualEvaluation {

    public String solution(int[][] scores) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {

            int sum = 0;
            int max = -1;
            int min = 101;
            int length = scores.length;
            boolean isUnique = true;
            int myScore = scores[i][i];

            for (int j = 0; j < scores.length; j++) {

                min = Math.min(scores[j][i], min);
                max = Math.max(scores[j][i], max);

                if (i != j &&  myScore == scores[j][i]) {
                    isUnique = false;
                }

                sum += scores[j][i];

            }
            if (isUnique && (max == myScore || min == myScore)) {
                length -= 1;
                sum -= myScore;
            }
            sb.append(this.scoreToGrade(sum / length));
        }

        return sb.toString();
    }

    private String scoreToGrade(int score) {

        switch (score / 10) {
            case 10:
            case 9:
                return "A";
            case 8:
                return "B";
            case 7:
                return "C";
            case 6:
            case 5:
                return "D";
            default:
                return "F";
        }

    }
}

