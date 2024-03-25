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

        //skill을 queue에 넣고 queue 출력 값으로 skill 확인
        //skill_trees에 skill이 몇 개 있는지 갯수확인
        //skill_trees에 있는 skill의 순서와 queue에 있는 skill이 일치해서
        //queue에서 출력할 때마다 1씩 증가, 특정 값이 순서대로 빠져나오는 queue성질 이용
        //queue 출력 값과 skill 갯수 일치하면 answer증가

        //skill을 queue에 입력
        Queue<Character> skillQueue = new LinkedList<>();

        int answer = 0; //가능한 스킬트리

        //skill_trees에 skill 몇개 있는지 확인
        for(int i=0 ; i<skill_trees.length ; i++){

            makeQueue(skillQueue, skill); //skillQueue셋팅

            int sCount = 0; //skill_trees에 있는 skill 갯수
            int count = 0; //skill_trees에서 차례로 빠져나온 skill 갯수

            for(Character c : skill_trees[i].toCharArray()){
                if(skillQueue.contains(c)) sCount++;
            }

            for(Character c : skill_trees[i].toCharArray()){
                if(!skillQueue.isEmpty()){
                    if(c == skillQueue.peek()){ //skill_trees의 skill과 skill의 출력 순서가 같은지 peek로 확인
                        skillQueue.poll();
                        count++;
                    }
                }
            }

            if(sCount == count) answer++;
        }

        return answer;
    }

    void makeQueue(Queue<Character> q, String s){
        while(!q.isEmpty()){
            q.poll();
        }

        for(Character c : s.toCharArray()){
            q.offer(c);
        }
    }

    public int solution4(String skill, String[] skill_trees) {
        int answer = 0;

        //skill을 문자 배열로 만들기
        //skill_trees에 문자열에서 skill 갯수 저장 배열
        //skill 순서와 일치하면 index++

        //1)
        char[] skillArray = skill.toCharArray();

        //2)
        int[] skillCount = new int[skill_trees.length];
        for(int i=0 ; i<skill_trees.length ; i++){
            String s = skill_trees[i];
            int count = 0;
            for(char c : s.toCharArray()){

                //skill_trees에 있는 문자열 중 skill 갯수 세기
                for(char c2 : skillArray){
                    if(c == c2) count++;
                }
            }
            skillCount[i] = count;
        }

        //3)
        for(int i=0 ; i<skill_trees.length ; i++){
            String s = skill_trees[i];

            int index = 0;
            for(char c : s.toCharArray()){
                if(skillArray.length > index){
                    if(skillArray[index] == c){
                        index++;
                    }
                }
            }

            if(skillCount[i] == index) answer++;
        }

        return answer;
    }
}
