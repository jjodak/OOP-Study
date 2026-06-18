/*
 * 파일 설명: 수업 실습 예제입니다. 격투 게임 캐릭터를 확장한 보스 클래스입니다.
 * 학습 내용: 상속과 클래스 확장을 연습하는 객체지향 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//2)캐릭터 클래스를 상속 받는 보스 캐릭터 클래스를 만드시오
//•보스 캐릭터는 공격 동작과 필살기 동작을 가진다.
//•필살기 동작은 항상 최대 데미지를 입히지만 자신의 체력도 10씩 줄인다.
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•보스 캐릭터 클래스는 생성자를 가진다.

package w4.w401;

// 클래스 boss: 수업 실습 예제입니다. 격투 게임 캐릭터를 확장한 보스 클래스입니다.
public class boss extends character{
    // boss(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public boss(String name, int hp, int max){
        super(name,hp,max);
    }

    // bossatk(): 이 클래스의 기능을 수행하는 메소드입니다.
    public void bossatk(character enemy){
        attack(enemy);
    }

    // ult(): 이 클래스의 기능을 수행하는 메소드입니다.
    public void ult(character enemy){
        enemy.hp -=20;
        hp -= 10;
        System.out.println("보스의 필살기!!" + max + "만큼 확정공격!! 하지만, 본인의 체력 -10");
    }
}
