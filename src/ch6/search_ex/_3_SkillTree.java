package ch6.search_ex;

import java.util.*;

public class _3_SkillTree {
    public int solution1(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees){
            String str = s.replaceAll("[^"+skill+"]","");
            if(skill.startsWith(str)) answer++;
        }
        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {

        for(int i=0 ; i<skill_trees.length ; i++){
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]","");
        }

        char[] charSkill = skill.toCharArray();
        int answer = 0;
        for(String s : skill_trees){
            int cnt = 0;
            boolean chk = true;
            for(char c : s.toCharArray()){
                if(c != charSkill[cnt]){
                    chk = false;
                    break;
                }
                cnt++;
            }
            if(chk) answer++;
        }
        return answer;
    }

    public int solution3(String skill, String[] skill_trees) {
        int answer = 0;

        //skill을 queue에 넣고 queue 출력 값으로 skill 확인
        //skill_trees에 skill이 몇 개 있는지 갯수확인
        //queue 출력할 때마다 1씩 증가, 특정 값이 순서대로 빠져나오는 queue성질 이용
        //queue 출력 값과 skill 갯수 일치하면 answer증가

        Queue<Character> queue = new LinkedList<>();

        //skill로부터 queue생성
        queueMake(queue,skill);

        for(int i=0 ; i<skill_trees.length ; i++){
            int sCount = 0; //skill_trees에 속해있는 skill 갯수
            for(char c : skill_trees[i].toCharArray()){
                if(queue.contains(c)) ++sCount;
            }

            int count = 0; //skill에서 순서대로 빠져나온 갯수
            for(char c : skill_trees[i].toCharArray()){
                if(!queue.isEmpty()){ //CBD가 다 빠졌을 때 queue.peek()자체가 에러발생
                    if(c == queue.peek()) {
                        queue.poll();
                        count++;
                    }
                }
            }

            if(sCount == count) answer++;

            queueMake(queue,skill); //남아있는 queue를 비우고 다시 채움
        }
        return answer;
    }

    public void queueMake(Queue<Character> queue, String skill) {

        while (!queue.isEmpty()) queue.poll();

        for (char c : skill.toCharArray()) {
            queue.offer(c);
        }
    }
}
