package programmers;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();        //장르별 재생횟수를 구하기 위해 hashmap사용
        for(int i = 0; i < genres.length; i++) {                             //hashmap에 장르별 플레이 횟수 저장
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<Integer> answers = new ArrayList<Integer>();                //나중에 int[]형으로 바꿔서 리턴할 arrayList
        ArrayList<String> al = new ArrayList<String>(hm.keySet());            //Value를 내림차순으로 정리하기 위해 정의
        Collections.sort(al, (o1,o2)->(hm.get(o2).compareTo(hm.get(o1))));    //ArrayList를 hm Value 내림차순 순으로 정렬

        for(int i = 0; i < al.size(); i++) {                                //비교, 정답 추출 실행문
            String TempGenres = al.get(i);
            int firstIdx = 0;
            int secondIdx = 0;
            int max = 0;
            for(int j = 0; j < genres.length; j++) {    //첫번째 값 구하기
                if(TempGenres.equals(genres[j])) {        //높은 순으로 가져온 장르와 genres배열의 값이 같으면
                    if(plays[j]> max) {                    //max와 비교해서 최댓값 갱신
                        max = plays[j];
                        firstIdx = j;
                    }
                }
            }

            max = -1;                                     //장르가 하나일 수 있으므로 -1
            for(int j = 0; j < genres.length; j++) {    //두번째 값 구하기
                if(TempGenres.equals(genres[j])) {
                    if(j != firstIdx && plays[j] > max) {
                        max = plays[j];
                        secondIdx = j;
                    }
                }
            }
            answers.add(firstIdx);            //제일 큰 값 추가
            if(max != -1) {
                answers.add(secondIdx);            //다음 큰 값 추가
            }
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();

    }

}
