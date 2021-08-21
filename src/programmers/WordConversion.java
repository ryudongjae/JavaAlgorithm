package programmers;

public class WordConversion {
    static int answer = 51;
    static boolean [] used;
    public int solution(String begin, String target, String[] words) {
        used = new boolean[words.length];
        dfs(begin,target,words,0);
        return answer == 51?0 : answer;
    }
    public static void dfs(String begin, String target, String[] words,int count){
        if(begin.equals(target)){
            answer = (answer>count) ? count:answer;
            return;
        }

        for (int i = 0; i< words.length; i++){
            if(used[i]){
                continue;
            }

            int c = 0;
            for(int j = 0; j < begin.length(); j++){
                if (begin.charAt(j)  == words[i].charAt(j)){
                    c++;
                }
            }
            if (c == begin.length() -1){
                used[i] = true;
                dfs(words[i],target,words,count+1 );
                used[i] = false;
            }
        }



    }
}
