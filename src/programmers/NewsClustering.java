package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> unionList = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        for(int i = 0; i < str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if(Character.isLetter(a)&& Character.isLetter(b)){
                String string  = Character.toString(a)+Character.toString(b);
                list1.add(string);
            }
        }

        for(int i = 0; i < str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if(Character.isLetter(a)&& Character.isLetter(b)){
                String string  = Character.toString(a)+Character.toString(b);
                list2.add(string);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for (String s : list1) {
            if(list2.remove(s)){
                intersection.add(s);
            }
            unionList.add(s);
        }

        for (String s : list2) {
            unionList.add(s);
        }

        double a = intersection.size();
        double b = unionList.size();

        double jakard = 0;

        if (unionList.size() == 0){
            jakard = 1;
        }else {
            jakard = a/b;
        }


        return (int) (jakard*65536);
    }
}
