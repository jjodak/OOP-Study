/*
 * 파일 설명: 수업 실습 예제입니다. 게임의 좀비 캐릭터 정보를 담는 클래스입니다.
 * 학습 내용: 전화번호부와 게임 저장 구조를 연습하는 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w7.w702;

// 클래스 zombie: 수업 실습 예제입니다. 게임의 좀비 캐릭터 정보를 담는 클래스입니다.
public class zombie extends unit {
    // zombie(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public zombie(String name, int pos, int hp) {
        super(name, pos, hp);
    }

    @Override
    void move() {
        int zmove = (int) (Math.random() * 2);
        if (zmove == 0) {
            if (pos > 1) {
                left();
            } else {
                right();
            }
        } else if (zmove == 1) {
            if (pos < 50) {
                right();
            } else {
                left();
            }
        }
    }
}
