/*
 * 파일 설명: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
 * 학습 내용: 전화번호부와 게임 저장 구조를 연습하는 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w7.w702;

import java.util.Scanner;

// 클래스 hero: 수업 실습 예제입니다. 게임의 주인공 캐릭터 정보를 담는 클래스입니다.
public class hero extends unit {
    Scanner sc = new Scanner(System.in);

    // hero(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public hero(String name, int pos, int hp) {
        super(name, pos, hp);
    }

    @Override
    void move() {
        System.out.println("1: 왼쪽, 2: 오른쪽, 3: 점프");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                left();
                break;
            case 2:
                right();
                break;
            case 3:
                int jump = (int) (Math.random() * 3) + 1;
                pos += jump;
                System.out.println(name + "이(가) 점프하여 " + jump + "만큼 이동함");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }

    }
}
