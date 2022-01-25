package programmers;

public class LyricsSearch {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            String c = queries[i].replace("?","");
            for(int j = 0; j < words.length; j++){
                if(words[j].contains(c)){
                    answer[i]+=1;
                }
            }
        }
        return answer;
    }

}
