/*
 * 파일 설명: 수업 실습 예제입니다. Swing 이벤트와 컴포넌트를 연습하는 과제 코드입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 클래스 assignment: 수업 실습 예제입니다. Swing 이벤트와 컴포넌트를 연습하는 과제 코드입니다.
public class assignment extends JFrame {
    private JLabel la = new JLabel();
    private int lastX = -1;
    private int lastY = -1;

    // assignment(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public assignment() {
        setTitle("팔라독 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ic = new ImageIcon("java/javacodes/src/w11/images/paladog1.png");
        la.setIcon(ic);

        Container c = getContentPane();

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);
        la.addMouseListener(listener);
        la.addMouseMotionListener(listener);

        c.setLayout(null);
        la.setSize(250, 250);
        la.setLocation(30, 30);
        c.add(la);

        setSize(500, 500);
        setVisible(true);
    }

    // 클래스 MyMouseListener: 수업 실습 예제입니다. Swing 이벤트와 컴포넌트를 연습하는 과제 코드입니다.
    class MyMouseListener extends MouseAdapter {
        // getPoint(): 이 클래스의 기능을 수행하는 메소드입니다.
        private Point getPoint(MouseEvent e) {
            if (e.getSource() == la) {
                return new Point(e.getX() + la.getX(), e.getY() + la.getY());
            }
            return new Point(e.getX(), e.getY());
        }

        @Override
        // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
        public void mouseClicked(MouseEvent e) {
            Point p = getPoint(e);
            // 같은 위치에서 클릭 시 1씩 전진, 아니면 해당 위치로 이동
            if (lastX == p.x && lastY == p.y) {
                la.setLocation(la.getX() + 10, la.getY());
            } else {
                la.setLocation(p.x, p.y);
            }
            lastX = p.x;
            lastY = p.y;
        }

        @Override
        // mouseDragged(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseDragged(MouseEvent e) {
            Point p = getPoint(e);
            // 마우스 드래그 시 해당 위치로 이동
            la.setLocation(p.x, p.y);
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new assignment();
    }
}
