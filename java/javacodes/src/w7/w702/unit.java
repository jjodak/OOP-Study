/*
 * 파일 설명: 수업 실습 예제입니다. 게임 캐릭터의 공통 정보를 담는 부모 클래스입니다.
 * 학습 내용: 전화번호부와 게임 저장 구조를 연습하는 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w7.w702;

// 클래스 unit: 수업 실습 예제입니다. 게임 캐릭터의 공통 정보를 담는 부모 클래스입니다.
abstract class unit {
    String name;
    int pos;
    int hp;

    // unit(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public unit(String name, int pos, int hp){
        this.name = name;
        this.pos = pos;
        this.hp = hp;
    }

    // left(): 이 클래스의 기능을 수행하는 메소드입니다.
    public void left(){
        if(pos > 1) {
            pos--;
            System.out.println(name + "이(가) 왼쪽으로 1칸 이동");
        }
    }

    // right(): 이 클래스의 기능을 수행하는 메소드입니다.
    public void right(){
        if(pos < 50) {
            pos++;
            System.out.println(name + "이(가) 오른쪽으로 1칸 이동");
        }
    }

    abstract void move();
}
