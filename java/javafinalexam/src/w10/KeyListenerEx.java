/*
 * 파일 설명: 기말고사 대비 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 KeyListenerEx: 기말고사 대비 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
public class KeyListenerEx extends JFrame {
    private JLabel[] keyMessage;

    // KeyListenerEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public KeyListenerEx() {
        setTitle("Key Listener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.addKeyListener(new MyKeyListener());

        keyMessage = new JLabel[3];
        keyMessage[0] = new JLabel(" getKeyCode() ");
        keyMessage[1] = new JLabel(" getKeyChar() ");
        keyMessage[2] = new JLabel(" getKeyText() ");

        for (int i = 0; i < keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.YELLOW);
        }

        setSize(300, 250);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    // 클래스 MyKeyListener: 기말고사 대비 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
    class MyKeyListener extends KeyAdapter {
        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {
            keyMessage[0].setText(Integer.toString(e.getKeyCode()));
            keyMessage[1].setText(Character.toString(e.getKeyChar()));
            keyMessage[2].setText(e.getKeyText(e.getKeyCode()));
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new KeyListenerEx();
    }
}
