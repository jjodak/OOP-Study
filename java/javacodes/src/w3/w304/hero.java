/*
 * 파일 설명: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
 * 학습 내용: 배열과 클래스를 이용한 게임 기초 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//   2) 주인공 Hero 클래스를 만드세요.
//      (1) 주인공의  이름, 현재위치, 생명개수의 속성을 가진다. (멤버변수)
//      (2) 좀비를 피하기 위한 점프 기능(jump)을 가진다. (메소드)
//           - 점프를 하면 현재 위치에서 1~3 사이의 랜덤 값을 가지고 주인공의 좌표값이 오른쪽으로 이동하게 된다.
//           - 점프 메소드를 호출하면  예를 들어 “주인공” 이 3 만큼 점프하였습니다.” 가 출력되도록 하세요
//      (3) Hero 클래스는  왼쪽으로 움직이기(leftMove) 기능이 있다. (메소드)
//           - 예) “주인공” 이  왼쪽으로 이동하여 현재위치는  “5” 입니다.  출력
//      (4)Hero 클래스는  오른쪽으로 움직이기(rightMove) 기능이 있다. (메소드)
//           - 예) “주인공” 이  오른쪽으로 이동하여 현재위치는  “6” 입니다.  출력
//      (5)Hero 클래스는 생성자(이름, 현재위치, 생명개수)를 가진다.

package w3.w304;

// 클래스 hero: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
public class hero {
    String name;
    int pos;
    int hp;

    // hero(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public hero(String name, int pos, int hp){
        this.name = name;
        this.pos = pos;
        this.hp = hp;
    }

    void jump(){
        int herojump = (int)(Math.random()*3)+1;
        pos += herojump;
        System.out.println(name + "이(가)" + herojump + "만큼 점프했습니다. 현재위치는 " + pos + "입니다.");
    }

    void leftmove(){
        if(pos > 1) {
            pos--;
            System.out.println(name + "이(가) 왼쪽으로 이동했습니다. 현재위치는 " + pos + "입니다.");
        }else{
            System.out.println("잘못 된 이동");
        }
    }

    void rightmove(){
        if(pos < 30){
            pos ++;
            System.out.println(name + "이(가) 오른쪽으로 이동했습니다. 현재위치는 " + pos + "입니다.");
        }else{
            System.out.println("잘못 된 이동");
        }
    }

}
