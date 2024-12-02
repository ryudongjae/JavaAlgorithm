package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> pointMap = new HashMap<>();
        List<Integer> valueList = new ArrayList<>();
        for(int i=0; i<name.length; i++) {
            pointMap.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            int score = 0;
            for (int j=0; j<photo[i].length; j++) {
                String compareName = photo[i][j];
                Integer orDefault = pointMap.getOrDefault(compareName, 0);
                score = score+orDefault;

            }
            valueList.add(score);
        }
        return valueList.stream().mapToInt(Integer::intValue).toArray();
    }
}
