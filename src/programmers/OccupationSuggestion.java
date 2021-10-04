package programmers;

public class OccupationSuggestion {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = 0;
        for(int i = 0; i <  table.length; i++){
            String[] jobLength = table[i].split(" ");
            String job = "";
            int sum = 0;

            for(int j = 0; j < jobLength.length; j++){
                int point = jobLength.length-j;
                if(j == 0){
                    job = jobLength[j];
                    continue;
                }

                for(int k = 0; k < languages.length; k++){
                    if(languages[k].equals(jobLength[j])){
                        sum+= preference[k]*point;
                    }
                }
            }

            if(max <= sum) {
                if(max == sum){
                    if (answer.compareTo(job)<0){
                        continue;
                    }
                }

                max = sum;
                answer =job;
            }
        }
        return answer;
    }

}
