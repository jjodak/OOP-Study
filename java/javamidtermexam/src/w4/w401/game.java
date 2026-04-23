//1.다음의 격투 게임 클래스를 작성하시오.
//
//1)격투 게임 캐릭터 클래스를 만드시오
//•캐릭터는 이름과 체력을 가진다. (멤버 변수)
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•캐릭터 클래스는 생성자를 가진다.
//
//2)캐릭터 클래스를 상속 받는 보스 캐릭터 클래스를 만드시오
//•보스 캐릭터는 공격 동작과 필살기 동작을 가진다.
//•필살기 동작은 항상 최대 데미지를 입히지만 자신의 체력도 10씩 줄인다.
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•보스 캐릭터 클래스는 생성자를 가진다.
//
//3)다음의 캐릭터 객체를 생성하시오.
//•이름: 자기이름, 200의 체력, 최대 데미지 15의 랜덤 공격을 가지는 캐릭터
//•이름:보스,  300의 체력,  최대 데미지  20의 랜덤 공격을 가지는 캐릭터
//•보스 캐릭터는 20%의 확률로 필살기를 사용하도록 수정해보시오.
//•나와 보스 둘이 싸우면 누가 이기는지 실행시켜보자.

package w4.w401;

public class game {
    public static void main(String[] args) {
        character hero = new character("준혁", 200, 15);
        boss boss = new boss("보스", 300, 20);
        int round = 1;

        while(true){
            System.out.println("============="+round+"라운드=============");
            round ++;

            hero.attack(boss);
            int atkorult = (int)(Math.random()*2);

            if(atkorult == 0){
                boss.bossatk(hero);
            }else if(atkorult == 1){
                boss.ult(hero);
            }

            if(boss.hp <= 0 && hero.hp <= 0){
                System.out.println("비겼습니다.");
                break;
            }else if (boss.hp<=0){
                System.out.println(hero.name+"이(가) 이겼습니다.");
                break;
            }else if(hero.hp<=0){
                System.out.println(boss.name+"이(가) 이겼습니다.");
                break;
            }
        }
    }
}
