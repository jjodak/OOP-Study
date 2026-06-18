/*
 * 파일 설명: 수업 실습 예제입니다. 격투 게임 캐릭터를 만들고 공격 흐름을 실행하는 예제입니다.
 * 학습 내용: 배열과 클래스를 이용한 게임 기초 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//1) 격투 게임 캐릭터 클래스를 만드시오
//     - 캐릭터는 이름과 체력을 가진다. (멤버 변수)
//     - 캐릭터는 공격을 할 수 있다. (메소드)
//     - 캐릭터 클래스는 생성자를 가진다.
//  2) 다음의 캐릭터 객체를 생성하세요.
//     - 이름:류, 100의 체력, 공격력 1~20의 랜덤 공격을 가지는 캐릭터
//     - 이름:켄, 200의 체력,  공격력 1~10의 랜덤 공격을 가지는 캐릭터
//  3) 매 턴마다 캐릭터의 체력을 출력하고 최종적으로 어떤 캐릭터가 이겼는지 출력하세요.

package w3.w303;

// 클래스 streetfighter: 수업 실습 예제입니다. 격투 게임 캐릭터를 만들고 공격 흐름을 실행하는 예제입니다.
public class streetfighter {
    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        hero ryu = new hero("류", 100);
        hero kan = new hero("캔", 200);

        ryu.attack(kan,20);
        kan.attack(ryu,10);

        int round = 1;

        while(true){
            System.out.println("========"+round+"라운드 ========");

            ryu.attack(kan,20);
            kan.attack(ryu,10);
            round++;

            if(ryu.hp <= 0 && kan.hp <= 0){
                System.out.println("비겼습니다.");
                break;
            } else if(ryu.hp <= 0) {
                System.out.println("캔이 이겼습니다.");
                break;
            } else if(kan.hp <= 0) {
                System.out.println("류가 이겼습니다.");
                break;
            }
        }
    }
}
