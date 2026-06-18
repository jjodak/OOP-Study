/*
 * 파일 설명: 수업 실습 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 KeyListenerEx: 수업 실습 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
public class KeyListenerEx extends JFrame {
    private JLabel[] keyMessage;

    // KeyListenerEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public KeyListenerEx() {
        super("KeyListener 예제");
        initUI();
    }

    // initUI(): 이 클래스의 기능을 수행하는 메소드입니다.
    private void initUI() {
        setTitle("KeyListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.addKeyListener(new MyKeyListner());

        keyMessage = new JLabel[3];
        keyMessage[0] = new JLabel(" getKeyCode()");
        keyMessage[1] = new JLabel(" getKeyChar()");
        keyMessage[2] = new JLabel(" getKeyText()");

        for (int i = 0; i < keyMessage.length; i++) {
            c.add(keyMessage[i]);
            keyMessage[i].setOpaque(true);
            keyMessage[i].setBackground(Color.yellow);
        }

        setSize(300, 150);
        setVisible(true);
    }

    // 클래스 MyKeyListner: 수업 실습 예제입니다. 키보드 입력 이벤트 처리 예제입니다.
    class MyKeyListner extends KeyAdapter {
        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            char keyChar = e.getKeyChar();

            keyMessage[0].setText(Integer.toString(keyCode));
            keyMessage[1].setText(Character.toString(keyChar));
            keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new KeyListenerEx();
    }
}
