/*
 * 파일 설명: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
 * 학습 내용: 배열과 클래스를 이용한 게임 기초 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w3.w303;

// 클래스 hero: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
public class hero {
    String name;
    int hp;

    // hero(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public hero(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    // attack(): 공격 동작을 처리합니다.
    public void attack(hero enemy, int max){
        int atk = (int)(Math.random()*max)+1;
        enemy.hp -= atk;

        System.out.println(name +"의 " + atk +"만큼 공격 -> " +enemy.name+ "의 남은 체력: " + enemy.hp);
    }
}
