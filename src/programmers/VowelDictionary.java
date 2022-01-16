package programmers;

public class VowelDictionary {
    public int solution(String word) {
        String words = "AEIOU";
        int[] var = {781,156,31,6,1};
        int index = word.length();
        int value = word.length();
        for(int i = 0; i< word.length(); i++){
            index = words.indexOf(word.charAt(i));
            value += var[i]*index;
        }
        return value;
    }
}
