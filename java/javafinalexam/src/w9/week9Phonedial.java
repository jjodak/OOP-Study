/*
 * 파일 설명: 기말고사 대비 예제입니다. GridLayout으로 전화 다이얼 형태의 버튼 화면을 만드는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;
import java.awt.*;

// 클래스 week9Phonedial: 기말고사 대비 예제입니다. GridLayout으로 전화 다이얼 형태의 버튼 화면을 만드는 예제입니다.
public class week9Phonedial extends JFrame {
    // week9Phonedial(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public week9Phonedial() {
        setTitle("전화번호 다이얼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 3));

    }

}
