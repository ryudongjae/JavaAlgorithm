package programmers;

import java.util.HashSet;

public class VisitLength {
    public int solution(String dirs) {
        java.util.HashSet<String> set = new HashSet<>();
        int cx = 0,cy = 0;
        for (int i = 0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            int nx = cx;
            int ny = cy;

            if (c == 'U' && cy+1 <= 5)cy++;
            else if (c == 'D' && cy-1 >= -5)cy--;
            else if(c=='R' && cx+1 <= 5)cx++;
            else if(c == 'L' && cx-1 >= -5)cx--;

            if(nx == cx && cy ==ny){
                continue;
            }
            set.add(cx+"" + cy+"" +nx+""+ny);
            set.add(nx+"" + ny+"" +cx+""+cy);
        }

        return set.size()/2;
    }
}
