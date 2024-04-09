package progrms.codingtest_ex;

public class bandage {
   public int solution(int[] bandage, int health, int[][] attacks) {
      int answer = 0;

      int saveTime = bandage[0]; //시전 시간
      int perRecovery = bandage[1];  //초당 회복량
      int addRecovery = bandage[2];  //추가 회복량

      int max = attacks[attacks.length-1][0];

      int index = 0; //attacks index
      int MAXCOUNT = 1;
      int saveTimeCount = 0;
      int nowHealth = health;
      for(int i=1 ; i<=max ; i++){

         //공격이 있는 경우
         //1)연속 성공 = 0
         //2)health 감소
         if(attacks[index][0] == i){
            System.out.println("attacks[index][0]:"+attacks[index][0]+" ,i:"+i);
            saveTimeCount = MAXCOUNT;
            nowHealth -= attacks[index][1];
            System.out.println("nowHealth:"+nowHealth);
            index++;
         }
         else{
            //공격이 없는 경우
            //1)연속 성공 확인
            //2)초당 체력 증가

            nowHealth += perRecovery;


            if(saveTime == saveTimeCount){
               nowHealth += addRecovery;
               saveTimeCount = MAXCOUNT;
            }
            saveTimeCount++;
         }

         //health 체크
         if(nowHealth <= 0){
            return -1;
         }else if(nowHealth > health){
            nowHealth = health;
         }
         System.out.println(nowHealth);
      }

      return nowHealth;
   }
}
