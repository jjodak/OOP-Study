/*
 * 파일 설명: 수업 실습 예제입니다. 격투 게임 캐릭터의 공통 정보를 담는 클래스입니다.
 * 학습 내용: 상속과 클래스 확장을 연습하는 객체지향 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//1.다음의 격투 게임 클래스를 작성하시오.
//
//1)격투 게임 캐릭터 클래스를 만드시오
//•캐릭터는 이름과 체력을 가진다. (멤버 변수)
//•캐릭터는 공격 행위를 할 수 있다. (메소드)
//•캐릭터 클래스는 생성자를 가진다.

package w4.w401;

// 클래스 character: 수업 실습 예제입니다. 격투 게임 캐릭터의 공통 정보를 담는 클래스입니다.
public class character {
    String name;
    int hp;
    int max;

    // character(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public character(String name, int hp, int max){
        this.name = name;
        this.hp = hp;
        this.max = max;
    }

    // attack(): 공격 동작을 처리합니다.
    public void attack(character enemy){
        int atk = (int)(Math.random()*max)+1;
        enemy.hp -= atk;
        System.out.println(this.name + "이(가) " + atk +"만큼 공격!! -> " + enemy.name+"의 체력: " + enemy.hp);
    }
}
