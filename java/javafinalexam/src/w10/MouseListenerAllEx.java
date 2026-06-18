/*
 * 파일 설명: 기말고사 대비 예제입니다. 마우스의 여러 이벤트를 모두 확인하는 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 MouseListenerAllEx: 기말고사 대비 예제입니다. 마우스의 여러 이벤트를 모두 확인하는 예제입니다.
public class MouseListenerAllEx extends JFrame {
    private JLabel la = new JLabel("No Mouse Event");
    private JLabel cla = new JLabel();

    // MouseListenerAllEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public MouseListenerAllEx() {
        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);

        c.add(la, BorderLayout.NORTH);
        c.add(cla, BorderLayout.CENTER);

        setSize(300, 200);
        setVisible(true);
    }

    // 클래스 MyMouseListener: 기말고사 대비 예제입니다. 마우스의 여러 이벤트를 모두 확인하는 예제입니다.
    class MyMouseListener implements MouseListener, MouseMotionListener {
        // mousePressed(): 마우스를 눌렀을 때의 동작을 처리합니다.
        public void mousePressed(MouseEvent e) {
            la.setText("Mouse Pressed (" + e.getX() + "," + e.getY() + ")");
        }

        // mouseReleased(): 마우스 버튼을 놓았을 때의 동작을 처리합니다.
        public void mouseReleased(MouseEvent e) {
            la.setText("Mouse Released (" + e.getX() + "," + e.getY() + ")");
        }

        // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
        public void mouseClicked(MouseEvent e) {
            int clicks = e.getClickCount();

            if (clicks == 1) {
                cla.setText("한 번 클릭됨!");
            } else if (clicks == 2) {
                cla.setText("더블 클릭됨!");
            }
        }

        // mouseEntered(): 마우스가 컴포넌트 안으로 들어왔을 때 호출됩니다.
        public void mouseEntered(MouseEvent e) {
            Component c = (Component) e.getSource();
            c.setBackground(Color.CYAN);
        }

        // mouseExited(): 마우스가 컴포넌트 밖으로 나갔을 때 호출됩니다.
        public void mouseExited(MouseEvent e) {
            Component c = (Component) e.getSource();
            c.setBackground(Color.YELLOW);
        }

        // mouseDragged(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseDragged(MouseEvent e) {
            la.setText("Mouse Dragged (" + e.getX() + "," + e.getY() + ")");
        }

        // mouseMoved(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseMoved(MouseEvent e) {
            la.setText("Mouse Moved (" + e.getX() + "," + e.getY() + ")");
        }

    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new MouseListenerAllEx();
    }
}
