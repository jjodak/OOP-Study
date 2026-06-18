/*
 * 파일 설명: 수업 실습 예제입니다. 게임의 좀비 캐릭터 정보를 담는 클래스입니다.
 * 학습 내용: 상속과 클래스 확장을 연습하는 객체지향 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//2) 주인공(Hero) 클래스와 좀비(Zombie) 클래스가 Unit 클래스를 상속받아 구현되도록 기존 코드를 수정하세요.
//• Unit이라는 추상클래스를 상속받았기 때문에 move 라는 추상메소드를 반드시 구현해야함
//• Hero 클래스의 move 메소드 안에는 입력을 받아 왼쪽, 오른쪽, 또는 점프할 수 있도록 구현
//• Zombie 클래스의 move 메소드 안에는 왼쪽, 오른쪽으로 랜덤하게 이동하도록만 구현
//

package w4.w402;

// 클래스 zombie: 수업 실습 예제입니다. 게임의 좀비 캐릭터 정보를 담는 클래스입니다.
public class zombie extends unit{
    // zombie(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public zombie(String name, int pos){
        super(name, pos);
    }

    @Override
    void move() {
        int zmove = (int)(Math.random()*2);
        if (zmove == 0){
            left();
        }else if(zmove == 1){
            right();
        }
    }
}
