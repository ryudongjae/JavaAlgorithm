package Softeer.level2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetingRoomReservation {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = String.valueOf(br.readLine()).split(" ");
        //예약정보 추출
        int roomCnt = Integer.parseInt(info[0]);
        int reserveCnt = Integer.parseInt(info[1]);
        Map<String,Map<Integer,Boolean>> reserveMap = new LinkedHashMap<>();
        //회의실명과 룸 현황 추가
        for (int i = 0; i < roomCnt; i++) {
            Map<Integer, Boolean> map = IntStream.rangeClosed(9, 18)
                    .boxed()
                    .collect(Collectors.toMap(s -> s, s -> false));
            String roomName = br.readLine();
            reserveMap.put(roomName,map);
        }
        //회의실 현황 변경
        for (int i = 0; i < reserveCnt; i++){
            String[] roomReserveTime = br.readLine().split(" ");
            //회의실명
            String roomName = roomReserveTime[0];
            Map<Integer, Boolean> booleanMap = reserveMap.get(roomName);
            int startTime = Integer.parseInt(roomReserveTime[1]);
            int endDate = Integer.parseInt(roomReserveTime[2]);
            for (int j = startTime; j <=endDate; j++){
                //예약된 회의실은 true로 변경
                booleanMap.put(j,true);
            }
        }

        System.out.println(reserveMap);
    }
}
