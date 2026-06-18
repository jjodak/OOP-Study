/*
 * 파일 설명: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
 * 학습 내용: 기초 문법, 입력, 조건문, 반복문 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//(실습과제 2-1 자료유형) 화면에 출력하기
//
//자신의 이름(문자열),
//자신의 나이(정수형)
//자신의 생년월일 8자리(정수형)
//자신의 키(실수형)
//각각의 자료유형으로 저장하고 그 값을 출력하세요.

package w2;

// 클래스 w201: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
public class w201 {
    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        String name = "조준혁";
        int age = 23;
        int birth = 20040602;
        float hight = 173;

        System.out.println(name);
        System.out.println(age);
        System.out.println(birth);
        System.out.println(hight);
    }
}
