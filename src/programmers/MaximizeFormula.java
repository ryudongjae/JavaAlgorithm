package programmers;

import java.util.ArrayList;

public class MaximizeFormula {
    char [] operation = {'*','+','-'};
    ArrayList<Long> number;
    ArrayList<Character> operations;
    long answer;
    boolean[] visited = new boolean[3];

    public long solution(String expression) {
        number = new ArrayList<>();
        operations = new ArrayList<>();
        answer = 0;
        String num = "";
        for(int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                num += expression.charAt(i);
            }else{
                number.add(Long.parseLong(num));
                operations.add(expression.charAt(i));
                num = "";
            }

        }
        number.add(Long.parseLong(num));

        dfs(0,new char[3]);
        return answer;
    }

    private void dfs(int cnt, char[] ch) {
        if(cnt == 3){
            ArrayList<Long> copyNumber = new ArrayList<>(number);
            ArrayList<Character> copyOperation = new ArrayList<>(operations);

            for(int i = 0; i < ch.length; i++){
                for(int j = 0; j < copyOperation.size(); j++){
                    if(copyOperation.get(j) == ch[i]){
                        Long result = calc(copyNumber.remove(j),copyNumber.remove(j),ch[i]);
                        copyNumber.add(j,result);
                        copyOperation.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer,Math.abs(copyNumber.get(0)));
            return;
        }
        for(int i = 0; i < 3; i++){
            if(!visited[i]){
                visited[i] =true;
                ch[cnt] = operation[i];
                dfs(cnt+1,ch);
                visited[i] = false;
            }
        }
    }

    public Long calc(Long num1,Long num2,char operation){
        if(operation == '*'){
            return num1 * num2;
        }else if(operation == '+'){
            return num1 + num2;
        }else {
            return num1 - num2;
        }
    }
}
