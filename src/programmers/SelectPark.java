package programmers;

import java.util.stream.IntStream;

public class SelectPark {
    public int[] solution(String[] park, String[] routes) {
        // 초기화
        int sx = 0, sy = 0, xl = park[0].length(), yl = park.length;
        char[][] board = new char[yl][xl];

        // 보드 생성 및 시작 위치 찾기
        for (int i = 0; i < yl; i++) {
            board[i] = park[i].toCharArray();
            if (park[i].contains("S")) {
                sy = i;
                sx = park[i].indexOf('S');
            }
        }

        // 이동 처리
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0];
            int steps = Integer.parseInt(parts[1]);

            int nx = sx, ny = sy;
            for (int j = 1; j <= steps; j++) {
                int tx = sx, ty = sy;
                switch (direction) {
                    case "E": tx += j; break;
                    case "W": tx -= j; break;
                    case "S": ty += j; break;
                    case "N": ty -= j; break;
                }

                // 범위를 벗어나거나 장애물 발견 시 중단
                if (tx < 0 || tx >= xl || ty < 0 || ty >= yl || board[ty][tx] == 'X') {
                    nx = sx; ny = sy; break;
                }
                nx = tx; ny = ty;
            }

            // 이동 성공 시 갱신
            sx = nx; sy = ny;
        }

        return new int[]{sy, sx};
    }
}
