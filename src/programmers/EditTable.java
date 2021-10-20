package programmers;

import java.util.Stack;

public class EditTable {
    public String solution(int n, int k, String[] cmd) {
        //삭제 된 값을 순서대로 저장할 스택
        Stack<Integer> remove_val = new Stack<>();
        int table_size = n;

        for(int i = 0; i < cmd.length; i++){
            char c = cmd[i].charAt(0);
            //D면 정수형으로 변환해서 +
            if (c == 'D'){
                k+= Integer.parseInt(cmd[i].substring(2));
            }
            //U면 정수형으로 변환해서 -
            else if (c == 'U'){
                k-=Integer.parseInt(cmd[i].substring(2));
            }
            //C면 정수형으로 변환해서 삭제스택에다가 현재 포커스값을 넣는다.그다음 테이블 사이즈 줄여줌
            else if (c == 'C'){
                remove_val.add(k);
                table_size --;
                //만약 k값이 마지막위치에 있다면 k값을 빼준다.
                if (k == table_size){
                    k--;
                }
                //Z이면 스택에서 값을 빼낸다 만약 K값이 스택에서 나온값과 같다면 k++
            }else if (c == 'Z'){
                if (remove_val.pop()<=k){
                    k++;
                }
                //표 사이즈 늘려줌
                table_size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        //현재 표 크기만큼 0을 채워넣는다.
        for(int i = 0; i<table_size; i++){
                sb.append("O");
        }
        //스택에 k값을 넣었기때문에 insert로 k를 빼내서 k번째 자리에 X를 채워준다.
        while (!remove_val.isEmpty()){
            sb.insert(remove_val.pop(),"X");
        }
        String answer = sb.toString();

        return answer;
    }
}
