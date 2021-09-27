package programmers;

public class CaesarCipher {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z'){
                ch = (char) (ch+n);
                if(ch > 'z'){
                    ch -= 26;
                }
            }else if (ch >= 'A' && ch <= 'Z'){
                ch = (char)  (ch+n);
                if(ch > 'Z'){
                    ch -= 26;
                }
            }

            sb.append(ch);
        }
        return sb.toString();
    }
}
