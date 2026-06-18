/*
 * 파일 설명: 기말고사 대비 예제입니다. 기본 JFrame 창을 만드는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;

// 클래스 MyFrame: 기말고사 대비 예제입니다. 기본 JFrame 창을 만드는 예제입니다.
public class MyFrame extends JFrame {
    // MyFrame(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public MyFrame() {
        setTitle("300X300 스윙 프레임 만들기");
        setSize(300, 300);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new MyFrame1();
    }

}
