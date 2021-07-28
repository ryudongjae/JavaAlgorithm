package programmers;

import java.util.HashSet;

public class PocketMon {
    public int solution(int[] nums) {
        java.util.HashSet<Integer> pocket = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            pocket.add(nums[i]);
        }
        int answer = 0;
        if(pocket.size() > nums.length/2){
            answer = nums.length/2;
        }
        else if(pocket.size() < nums.length/2){
            answer = pocket.size();;
        }
        else if(pocket.size() == nums.length/2){
            answer = pocket.size();
        }
        return answer;
    }
}
