/*
 * 파일 설명: 수업 실습 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 FlyingTextEx: 수업 실습 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
public class FlyingTextEx extends JFrame {

    JLabel la = new JLabel("안녕");

    // FlyingTextEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public FlyingTextEx() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = this.getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());

        la.setLocation(50, 50);
        la.setSize(100, 20);
        c.add(la);

        this.setSize(300, 300);
        this.setVisible(true);

        c.setFocusable(true);
    }

    // 클래스 MyKeyListener: 수업 실습 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
    class MyKeyListener implements KeyListener {
        @Override
        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_UP) {
                la.setLocation(la.getX(), la.getY() - 10);
            } else if (keyCode == KeyEvent.VK_DOWN) {
                la.setLocation(la.getX(), la.getY() + 10);
            } else if (keyCode == KeyEvent.VK_LEFT) {
                la.setLocation(la.getX() - 10, la.getY());
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                la.setLocation(la.getX() + 10, la.getY());
            }
        }

        @Override
        // keyReleased(): 키보드에서 손을 뗐을 때의 동작을 처리합니다.
        public void keyReleased(KeyEvent e) {

        }

        @Override
        // keyTyped(): 문자 키 입력을 처리하기 위한 메소드입니다.
        public void keyTyped(KeyEvent e) {

        }

    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new FlyingTextEx();
    }
}
