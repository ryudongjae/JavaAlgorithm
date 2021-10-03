package programmers;

public class BinaryChange {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")){
            answer[0]++;
            String value = s.replace("0","");
            answer[1] += s.length() - value.length();
            s = Integer.toBinaryString(value.length()).toString();
        }
        return answer;
    }
}
