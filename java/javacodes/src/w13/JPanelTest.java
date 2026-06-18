/*
 * 파일 설명: 수업 실습 예제입니다. JPanel의 paintComponent에서 이미지를 직접 그리는 예제입니다.
 * 학습 내용: paintComponent와 마우스 입력을 활용한 그래픽 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// 클래스 JPanelTest: 수업 실습 예제입니다. JPanel의 paintComponent에서 이미지를 직접 그리는 예제입니다.
public class JPanelTest extends JFrame {
    MyPanel my = new MyPanel();

    // JPanelTest(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public JPanelTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(my);
        this.setSize(250, 200);
        this.setVisible(true);
    }

    // 클래스 MyPanel: 수업 실습 예제입니다. JPanel의 paintComponent에서 이미지를 직접 그리는 예제입니다.
    class MyPanel extends JPanel implements MouseMotionListener {
        ImageIcon icon = new ImageIcon("javacodes/src/w12/images/apple.jpg");
        Image img = icon.getImage();

        int x = 0;
        int y = 0;

        // MyPanel(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
        public MyPanel() {
            this.addMouseMotionListener(this);
        }

        // paintComponent(): 패널을 다시 그릴 때 호출되어 화면 그래픽을 출력합니다.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setClip(x, y, 100, 100);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(10, 10, 50, 50);
            g.setColor(Color.red);
            g.drawRect(90, 90, 50, 50);
            g.setColor(Color.black);
            g.drawString("Java is fucking \"No Jam\"", 50, 50);
            g.drawLine(30, 30, 100, 100);
            g.drawOval(20, 20, 80, 80);
            g.drawRoundRect(200, 200, 120, 80, 40, 60);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        // mouseDragged(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseDragged(MouseEvent e) {
        }

        // mouseMoved(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new JPanelTest();
    }
}
