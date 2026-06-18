/*
 * 파일 설명: 수업 실습 예제입니다. 일반 좀비를 확장한 보스 좀비 클래스입니다.
 * 학습 내용: 상속과 클래스 확장을 연습하는 객체지향 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w4.w402;

// 클래스 zombieking: 수업 실습 예제입니다. 일반 좀비를 확장한 보스 좀비 클래스입니다.
public class zombieking extends unit{
    // zombieking(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public zombieking(String name, int pos){
        super(name, pos);
    }

    @Override
    void move() {
        pos = (int)(Math.random()*20)+1;
        System.out.println(name + "이(가) "+pos+"로 순간이동");

    }
}
