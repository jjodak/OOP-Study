/*
 * 파일 설명: 기말고사 대비 예제입니다. 마우스 클릭 이벤트 처리 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 MouseListenerEx: 기말고사 대비 예제입니다. 마우스 클릭 이벤트 처리 예제입니다.
public class MouseListenerEx extends JFrame {
    private JLabel la = new JLabel("Hello");

    // MouseListenerEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public MouseListenerEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        setSize(250, 250);
        setVisible(true);
    }

    private class MyMouseListener implements MouseListener {
        // mousePressed(): 마우스를 눌렀을 때의 동작을 처리합니다.
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            la.setLocation(x, y);
        }

        // mouseReleased(): 마우스 버튼을 놓았을 때의 동작을 처리합니다.
        public void mouseReleased(MouseEvent e) {
        }

        // mouseEntered(): 마우스가 컴포넌트 안으로 들어왔을 때 호출됩니다.
        public void mouseEntered(MouseEvent e) {
        }

        // mouseExited(): 마우스가 컴포넌트 밖으로 나갔을 때 호출됩니다.
        public void mouseExited(MouseEvent e) {
        }

        // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
        public void mouseClicked(MouseEvent e) {
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new MouseListenerEx();
    }
}
