package programmers;

public class TargetNumber {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers,target,0,0);

        return answer;
    }

    public void dfs(int[]numbers,int target,int index,int sum){
        //모든 정수를 탐색 후  누적합이 타겟값과 동일하면 ++해준다.
        if(index == numbers.length){
            if(sum == target)answer++;
                return;
        }
        // 현재 인덱스의 정수를 합해줌
        sum += numbers[index];

        //탐색
        dfs(numbers,target,index+1,sum);

        // 더해준 정수를 다시 빼준다.
        sum -= numbers[index];

        //현재 인덱스 정수를 빼준다.
        sum +=(-1* numbers[index]);

        //탐색
        dfs(numbers,target,index+1,sum);
    }
}
