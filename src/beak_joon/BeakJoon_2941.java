package beak_joon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeakJoon_2941{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int len = str.length();
        int cnt = 0;

        /**
         *ch == c이고 다음 문자가  = 또는 - 일 경우
         * */

        for(int i =0; i <len; i++){

            char ch  = str.charAt(i);

            if(ch == 'c' && i < len -1){

                if(str.charAt(i+1) == '=' || str.charAt(i+1) == '-'){
                    i++;
                }
            }
            /**
             * d-    or   dz=
             * */
            else if(ch == 'd' && i < len -1){

                if(str.charAt(i+1) == '-') {

                    i++;

                }else if(str.charAt(i + 1) == 'z' && i < len -2){

                    if(str.charAt(i + 2) == '='){
                        i += 2;
                    }
                }

            }
            /**
             * lj or nj
             * */
            else if((ch == 'l' || ch == 'n') && i < len -1){

                if(str.charAt(i+1) == 'j'){

                    i++;
                }
            }

            /**
             * s= or z=
             * */

            else if((ch == 's' || ch == 'z') && i < len -1){

                if(str.charAt(i + 1) == '='){
                    i++;
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}


class BeakJoon_2941_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String question = br.readLine();
        for (String word : words) {
            question = question.replace(word, " ");
        }
        System.out.println(question.length());
    }
}
