/*
 * 파일 설명: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
 * 학습 내용: 기초 문법, 입력, 조건문, 반복문 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

//(실습과제 2-3 랜덤/연산자) 주사위 던져서 나온 숫자의 합과 평균 출력
//주사위를 2개 던져서 나온 숫자의 합을 출력하세요.
//그 평균도 출력하세요. 소숫점으로 나오도록 하세요

package w2;

// 클래스 w203: 수업 실습 예제입니다. 기초 문법, 입력, 조건문, 반복문 실습 코드입니다.
public class w203 {
    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        int dice1 = (int)(Math.random()*6)+1;
        int dice2 = (int)(Math.random()*6)+1;

        System.out.println("주사위1 : " + dice1);
        System.out.println("주사위2 : " + dice2);

        int sumdice = dice1 + dice2;
        System.out.println("주사위 합 : " + sumdice);

        float avgdice = (float)sumdice / 2;
        System.out.println("주사위 평균 : " + avgdice);
    }
}
