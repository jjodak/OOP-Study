//2)캐릭터 클래스를 상속 받는 보스 캐릭터 클래스를 만드시오
//•보스 캐릭터는 공격 동작과 필살기 동작을 가진다.
//•필살기 동작은 항상 최대 데미지를 입히지만 자신의 체력도 10씩 줄인다.
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•보스 캐릭터 클래스는 생성자를 가진다.

package w4.w401;

public class boss extends character{
    public boss(String name, int hp, int max){
        super(name,hp,max);
    }

    public void bossatk(character enemy){
        attack(enemy);
    }

    public void ult(character enemy){
        enemy.hp -=20;
        hp -= 10;
        System.out.println("보스의 필살기!!" + max + "만큼 확정공격!! 하지만, 본인의 체력 -10");
    }
}
