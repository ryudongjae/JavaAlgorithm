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

        for (String s : set) {
            if (!isSameStr(s, banned_id[a++])) {
                return false;
            }
        }

        return true;
    }


    private boolean isSameStr(String x, String y){
        if(x.length() != y.length()){
            return false;
        }

        for(int i = 0; i < x.length(); i++){
            if (y.charAt(i) == '*')continue;

            if (x.charAt(i) != y.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
