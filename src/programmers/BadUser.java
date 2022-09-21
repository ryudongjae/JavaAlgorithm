package programmers;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser {
     java.util.Set<Set<String>> value;

    public int solution(String[] user_id, String[] banned_id) {
        value = new HashSet<>();
        dfs(user_id,banned_id,new LinkedHashSet<>());
        return value.size();
    }

    private void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        if (set.size() == banned_id.length){
            //문자열을 비교한뒤 true면 넣는다//set이기에 중복 허용 X
            if (isBannedUser(set,banned_id)){
                value.add(new HashSet<>(set));
            }
            return;
        }

        for (String userId : user_id) {
            if(!set.contains(userId)){
                set.add(userId);
                dfs(user_id,banned_id,set);
                set.remove(userId);
            }
        }
    }

    private boolean isBannedUser(Set<String> set, String[] banned_id) {
        int a = 0;

        //set에 넣은 문자열 비교
        for (String s : set) {
            if (!isSameStr(s, banned_id[a++])) {
                return false;
            }
        }

        return true;
    }


    private boolean isSameStr(String x, String y){
        //문자열 길이가 다르면 비교할 필요 없음
        if(x.length() != y.length()){
            return false;
        }

        for(int i = 0; i < x.length(); i++){
            //*은 건너뜀
            if (y.charAt(i) == '*')continue;
            //하나라도 다르면 false 반환
            if (x.charAt(i) != y.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
