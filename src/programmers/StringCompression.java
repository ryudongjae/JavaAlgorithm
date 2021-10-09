package programmers;

public class StringCompression {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1)return 1;

        for(int i = 1; i <=  s.length()/2; i++){
            String str = "";

            String template = "";

            int cnt = 1;

            for(int j = 0; j < s.length()/i; j++){

                if (template.equals(s.substring(j*i,(j*i)+i))){
                    cnt++;
                    continue;
                }
                if (cnt > 1){
                    str +=  cnt + template;
                    cnt = 1;
                }else{
                    str += template;
                }

                template =s.substring(j*i,(j*i)+i);
            }

            if(cnt > 1){
                str +=  cnt + template;
                cnt = 1;
            }else{
                str +=  template;
            }


            if (s.length()%i != 0){
                str +=  s.substring(s.length() - s.length()%i, s.length());
            }
            answer = answer >  str.length() ? str.length() : answer;
        }
        return answer;
    }
}
