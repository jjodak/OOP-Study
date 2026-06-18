/*
 * 파일 설명: 수업 실습 예제입니다. 게임 캐릭터의 공통 정보를 담는 부모 클래스입니다.
 * 학습 내용: Vector와 HashMap 같은 컬렉션을 활용한 게임 확장 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//1) 게임 확장을 위해 먼저 게임에 나오는 모든 캐릭터의 부모인 유닛(Unit) 클래스를 만드시오.
//• Unit  클래스는 추상 클래스이다.
//• Unit  클래스는  이름(name),  현재위치(pos)를 멤버변수로 가진다.
//• 왼쪽으로 위치를 1 움직이는 left(), 오른쪽으로 위치를 1 움직이는 right() 메소드를 가진다. (화면 1~20 밖으로 나가지 않도록 처리)
//• Unit  클래스는 움직이기(move) 기능을 추상 메소드로 가진다.
//• Unit 클래스는 생성자를 가진다.(이름, 현재위치)
//

package w5.vectortest;

// 클래스 unit: 수업 실습 예제입니다. 게임 캐릭터의 공통 정보를 담는 부모 클래스입니다.
abstract class unit {
    String name;
    int pos;

    // unit(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public unit(String name, int pos){
        this.name = name;
        this.pos = pos;
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
