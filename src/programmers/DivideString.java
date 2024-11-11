package programmers;

public class DivideString {
    public int solution(String s) {
        int answer = 0;
        int sameCount = 0;
        int diffCount = 0;
        char charAt = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (sameCount == diffCount) {
                answer++;
                charAt = s.charAt(i);
            }
            if (charAt == s.charAt(i)){
                sameCount++;
            } else{
                diffCount++;
            }
        }
        return answer;
    }
}
