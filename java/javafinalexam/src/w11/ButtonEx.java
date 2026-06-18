/*
 * 파일 설명: 기말고사 대비 예제입니다. 이미지 아이콘이 들어간 Swing 버튼 사용 예제입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ButtonEx: 기말고사 대비 예제입니다. 이미지 아이콘이 들어간 Swing 버튼 사용 예제입니다.
public class ButtonEx extends JFrame {
    // ButtonEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ButtonEx() {
        setTitle("이미지 버튼 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon normalIcon = new ImageIcon("javafinalexam/src/w11/images/normalIcon.gif");
        ImageIcon rolloverIcon = new ImageIcon("javafinalexam/src/w11/images/rolloverIcon.gif");
        ImageIcon pressedIcon = new ImageIcon("javafinalexam/src/w11/images/pressedIcon.gif");

        JButton btn = new JButton("Call~~", normalIcon);
        btn.setPressedIcon(pressedIcon);
        btn.setRolloverIcon(rolloverIcon);

        c.add(btn);
        setSize(250, 150);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new ButtonEx();
    }
}
