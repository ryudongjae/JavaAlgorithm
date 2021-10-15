package programmers;

public class LongestPalindrome {
    public int solution(String s){
        int answer = 1;
        if(s.length() == 1){
            return 1;
        }
        for(int i = 0; i < s.length(); i++){
            char start = s.charAt(i);
            loof:for(int j = i+1; j< s.length(); j++){
                if (s.charAt(j) == start && answer <= j-i+1){
                    int a = i;
                    int b = j;
                    while (a <= b){
                        if (s.charAt(a++) != s.charAt(b--)){
                            continue loof;
                        }
                    }
                    if (answer < j-i+1){
                        answer = j-i+1;
                    }
                }
            }
        }
        return answer;
    }
}
