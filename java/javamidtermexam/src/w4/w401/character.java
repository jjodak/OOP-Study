//1.다음의 격투 게임 클래스를 작성하시오.
//
//1)격투 게임 캐릭터 클래스를 만드시오
//•캐릭터는 이름과 체력을 가진다. (멤버 변수)
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•캐릭터 클래스는 생성자를 가진다.

package w4.w401;

public class character {
    String name;
    int hp;
    int max;

    public character(String name, int hp, int max){
        this.name = name;
        this.hp = hp;
        this.max = max;
    }

    public void attack(character enemy){
        int atk = (int)(Math.random()*max)+1;
        enemy.hp -= atk;
        System.out.println(this.name + "이(가) " + atk +"만큼 공격!! -> " + enemy.name+"의 체력: " + enemy.hp);
    }
}
