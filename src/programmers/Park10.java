package programmers;

/*
1 ≤ mats의 길이 ≤ 10
1 ≤ mats의 원소 ≤ 20
mats는 중복된 원소를 가지지 않습니다.
1 ≤ park의 길이 ≤ 50
1 ≤ park[i]의 길이 ≤ 50
park[i][j]의 원소는 문자열입니다.
park[i][j]에 돗자리를 깐 사람이 없다면 "-1", 사람이 있다면 알파벳 한 글자로 된 값을 갖습니다.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 일단 정렬이 필요하다,
 */
public class Park10 {
    public int solution(int[] mats, String[][] park) {
        // 1. mats 배열을 내림차순으로 정렬 (큰 돗자리부터 시도)
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            // 2. 해당 크기의 돗자리가 공원에 배치 가능한지 확인
            if (canPlaceMat(size, park)) {
                return size; // 가장 큰 크기를 찾으면 반환
            }
        }
        // 3. 아무 돗자리도 배치할 수 없는 경우
        return -1;
    }

    private boolean canPlaceMat(int size, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;

        // 2D 탐색: 돗자리가 공원 내에서 가능한지 확인
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (isAreaAvailable(i, j, size, park)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAreaAvailable(int x, int y, int size, String[][] park) {
        // (x, y)에서 size x size 범위가 모두 "-1"인지 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false; // 범위 내에 사람이 있으면 불가능
                }
            }
        }
        return true; // 모두 가능
    }
}
