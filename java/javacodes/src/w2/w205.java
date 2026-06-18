/*
 * 파일 설명: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
 * 학습 내용: 기초 문법, 입력, 조건문, 반복문 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//(실습과제 2-5 조건문) 좀비게임 만들기 - 내 캐릭터 움직이기
//
//1. 주인공은 사용자로부터 입력을 받아 움직인다. 1~3 사이의 숫자를 받아 다음과 같이 움직이도록 하자.
//주인공의 시작위치는 1
//1번이 입력되면 움직이기(왼쪽)이고 위치 출력 ("왼쪽으로 움직였습니다. 현재 위치는 00 입니다.")
//2번이 입력되면 움직이기(오른쪽)이고 위치 출력 ("오른쪽으로 움직였습니다. 현재 위치는 00 입니다.")
//3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하고 위치를 출력 ("점프했습니다. 현재 위치는 00 입니다.")

package w2;

import java.util.*;

// 클래스 w205: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
public class w205 {
    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hpos = 1;

        System.out.println("행동을 입력하세요. 1: 왼쪽, 2: 오른쪽, 3: 점프");
        int hmove = sc.nextInt();

        switch(hmove){
            case 1:
                hpos --;
                System.out.println("왼쪽으로 움직였습니다. 현재 위치는" + hpos +"입니다.");
                break;
            case 2:
                hpos ++;
                System.out.println("오른쪽으로 움직였습니다. 현재 위치는" + hpos +"입니다.");
                break;
            case 3:
                int jmove = (int)(Math.random()*3)+1;
                hpos += jmove;
                System.out.println("점프했습니다. 현재 위치는" + hpos +"입니다.");
                break;
            default:
                System.out.println("잘못 된 입력입니다.");
        }

    }
}
