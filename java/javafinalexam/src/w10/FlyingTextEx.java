/*
 * 파일 설명: 기말고사 대비 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 FlyingTextEx: 기말고사 대비 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
public class FlyingTextEx extends JFrame {
    private final int FLYING_UNIT = 10;
    private JLabel la = new JLabel("HELLO");

    // FlyingTextEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public FlyingTextEx() {
        setTitle("상,하,좌,우키를 이용하여 텍스트 움직이기");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        c.addKeyListener(new MyKeyListener());

        la.setLocation(50, 50);
        la.setSize(100, 20);
        c.add(la);

        setSize(300, 300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();

        c.addMouseListener(new MouseAdapter() {
            // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
            public void mouseClicked(MouseEvent e) {
                Component com = (Component) e.getSource();
                com.setFocusable(true);
                com.requestFocus();
            }
        });

    }

    // 클래스 MyKeyListener: 기말고사 대비 예제입니다. 키보드 방향키로 화면의 텍스트를 이동시키는 예제입니다.
    class MyKeyListener extends KeyAdapter {
        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
                    break;
                case KeyEvent.VK_DOWN:
                    la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
                    break;
                case KeyEvent.VK_LEFT:
                    la.setLocation(la.getX() - FLYING_UNIT, la.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    la.setLocation(la.getX() + FLYING_UNIT, la.getY());
                    break;
            }
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new FlyingTextEx();
    }

}
