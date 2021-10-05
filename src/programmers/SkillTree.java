package programmers;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skill_tree : skill_trees) {
            String tempSkill = skill_tree;

            for(int i =0; i<skill_tree.length(); i++){
                String s = skill_tree.substring(i,i+1);
                if(!skill.contains(s)){
                    tempSkill = tempSkill.replace(s,""); //skill에 없는 문자열일 경우 공백으로 치환
                }
            }
            if(skill.indexOf(tempSkill) == 0){
                answer++;
            }
        }
        return answer;
    }
}
