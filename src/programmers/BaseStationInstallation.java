package programmers;

public class BaseStationInstallation {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; //추가될 기지국 수
        int si = 0; //station index
        int position = 1; //1동부터 돌기

        while (position <= n){
            if(si < stations.length && position >=  stations[si] - w) {
                position = stations[si] + w + 1;
                si++;
            }else {
                answer += 1; //기지국 설치

                //왼쪽 전파범위 + 기지국 설치(1) + 오른쪽 전파 범위
                position+=(w*2)+1;
            }
        }
        return answer;
    }
}
