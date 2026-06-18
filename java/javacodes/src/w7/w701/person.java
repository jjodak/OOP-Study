/*
 * 파일 설명: 수업 실습 예제입니다. 전화번호부에서 한 사람의 정보를 저장하는 클래스입니다.
 * 학습 내용: 전화번호부와 게임 저장 구조를 연습하는 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w7.w701;

// 클래스 person: 수업 실습 예제입니다. 전화번호부에서 한 사람의 정보를 저장하는 클래스입니다.
public class person {
    String name;
    String phone;
    String email;

    // person(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public person(){

    }

    // person(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public person(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
