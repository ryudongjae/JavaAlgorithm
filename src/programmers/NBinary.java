package programmers;

public class NBinary {
    public String solution(int n, int t, int m, int p) {
         StringBuilder sb = new StringBuilder();
         StringBuilder answer = new StringBuilder();

         int num = 0;

         while(sb.length() < t*m){
             sb.append(Integer.toString(num++,n));
         }
         for(int i = p-1;  i<t*m; i = i + m){
             answer.append(sb.charAt(i));
         }
        return answer.toString().toUpperCase();
    }
}
