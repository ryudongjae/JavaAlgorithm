package programmers;

//앞으로 10초 (10초 이하로 지나왔다면 처음으로
//뒤로 10초 (10초 이하로 남았다면 끝으로
//오프닝 건너뛰기: 현재 재생 위치가 오프닝 구간(op_start ≤ 현재 재생 위치 ≤ op_end)인 경우 자동으로 오프닝이 끝나는 위치로 이동합니다.
public class moveVideo {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoFullTime = convertStringToSeconds(video_len);
        int openingStartTime = convertStringToSeconds(op_start);
        int openingEndTime = convertStringToSeconds(op_end);
        int positionTime = convertStringToSeconds(pos);
        for (String command : commands) {
            //동작이 prev인 경우
            if (command.equals("prev")) {
                //int prevCalc = positionTime - 10;
                //10초 뒤로갔을때 0이 되는 경우
                if (positionTime - 10 <= 0) {
                    //뒤로갔을때 0보다 작지만 오프닝이  0 이라면 영역에 걸리기때문에 오프닝 끝으로 간다.
                    if (openingStartTime == 0){
                        positionTime = openingEndTime;

                    }else{
                        positionTime = 0;
                        //그게 아닌 상황외에는 0으로 간다.
                    }
                }else{
                    //0보다 작아지지 않는 경우
                    //오프닝에 포함 되는지
                    if (openingCheck(positionTime,openingStartTime,openingEndTime)){
                        positionTime = openingEndTime;
                    }else if(openingCheck(positionTime -10,openingStartTime,openingEndTime)){
                        positionTime = openingEndTime;
                    }else{
                        //오프닝에 포함 안되면 -10
                        positionTime = positionTime - 10;
                    }
                }
            } else {
               /*
                더하는 곳에서 고려 사항
                end 값을 넘어간다면 end값으로 설정
                오프닝에 포함되었다면 오프닝 끝에서 + 10
                그 외에는 그냥 +10
                */
                if (openingCheck(positionTime,openingStartTime,openingEndTime)){
                    positionTime = openingEndTime + 10;
                    if (positionTime > videoFullTime){
                        positionTime = videoFullTime;
                    }
                }else{
                    positionTime = positionTime + 10;
                    if (openingCheck(positionTime,openingStartTime,openingEndTime)){
                        positionTime = openingEndTime;
                    }
                    if (positionTime > videoFullTime){
                        positionTime = videoFullTime;
                    }
                }

            }
        }
        return convertSecondsToString(positionTime);
    }

    private int convertStringToSeconds(String stringTime) {
        String[] split = stringTime.split(":");
        //분을 모두 초로 바꿔서 리턴
        return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);

    }

    private String convertSecondsToString(int totalSeconds) {
        // mm:ss 형식으로 출력
        return String.format("%02d:%02d", totalSeconds / 60, totalSeconds % 60);

    }

    private boolean openingCheck(int pos , int startTime, int endTime){
        return pos >= startTime && pos <= endTime;
    }

}
// "30:00", "29:55", "01:00", "01:30", ["next"] 30
//"30:00", "01:55", "01:00", "01:30", ["next"]
//기댓값 〉 "02:05"
//"34:33", "09:50", "10:00", "13:00", ["next", "next", "next", "prev"] 기댓값 "13:10"