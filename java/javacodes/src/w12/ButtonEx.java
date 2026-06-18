/*
 * 파일 설명: 수업 실습 예제입니다. 이미지 아이콘이 들어간 Swing 버튼 사용 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ButtonEx: 수업 실습 예제입니다. 이미지 아이콘이 들어간 Swing 버튼 사용 예제입니다.
public class ButtonEx extends JFrame {
    // ButtonEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ButtonEx() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Button Example");
        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon normalIcone = new ImageIcon("java/javacodes/src/w12/images/normalIcon.gif");
        ImageIcon pressedIcon = new ImageIcon("java/javacodes/src/w12/images/pressedIcon.gif");
        ImageIcon rolloverIcon = new ImageIcon("java/javacodes/src/w12/images/rolloverIcon.gif");

        JButton btn = new JButton("call~~", normalIcone);
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
