/*
 * 파일 설명: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
 * 학습 내용: 기초 문법, 입력, 조건문, 반복문 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//(실습과제 2-6 조건문/반복문) 컴퓨터와 하는 가위바위보 게임을 만드세요.
//
//사용자로부터 가위(1), 바위(2), 보(3) 입력을 받으세요.
//컴퓨터는 랜덤으로 가위(1), 바위(2), 보(3)를 선택하도록 하세요.
//사용자의 입력과 컴퓨터의 랜덤 수를 비교하여 누가 이겼는지 출력하세요.
//"나는 가위, 컴퓨터는 바위를 냈습니다. 컴퓨터가 이겼습니다." 출력

package w2;

import java.util.*;

// 클래스 w206: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
public class w206 {
    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1: 가위 2: 바위 3: 보");
        int player = sc.nextInt();

        int computer = (int)(Math.random() * 3) + 1;

        if (player == 1) {
            if (computer == 1) {
                System.out.println("나 가위, 컴퓨터 가위 -> 비겼습니다.");
            } else if (computer == 2) {
                System.out.println("나 가위, 컴퓨터 바위 -> 컴퓨터가 이겼습니다.");
            } else {
                System.out.println("나 가위, 컴퓨터 보 -> 내가 이겼습니다.");
            }
        }

        else if (player == 2) {
            if (computer == 1) {
                System.out.println("나 바위, 컴퓨터 가위 -> 내가 이겼습니다.");
            } else if (computer == 2) {
                System.out.println("나 바위, 컴퓨터 바위 -> 비겼습니다.");
            } else {
                System.out.println("나 바위, 컴퓨터 보 -> 컴퓨터가 이겼습니다.");
            }
        }

        else if (player == 3) {
            if (computer == 1) {
                System.out.println("나 보, 컴퓨터 가위 -> 컴퓨터가 이겼습니다.");
            } else if (computer == 2) {
                System.out.println("나 보, 컴퓨터 바위 -> 내가 이겼습니다.");
            } else {
                System.out.println("나 보, 컴퓨터 보 -> 비겼습니다.");
            }
        }

    }
}
