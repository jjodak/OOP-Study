/*
 * 파일 설명: 기말고사 대비 예제입니다. 이미지 라벨을 키보드로 이동시키는 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 paladog: 기말고사 대비 예제입니다. 이미지 라벨을 키보드로 이동시키는 예제입니다.
public class paladog extends JFrame {

    private JLabel imageLabel = new JLabel();
    ImageIcon image = new ImageIcon("javacodes/src/w11/images/paladog1.png");

    // paladog(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public paladog() {
        setTitle("Paladog move");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);

        MyKeyListener keyListener = new MyKeyListener();
        c.addKeyListener(keyListener);

        imageLabel.setIcon(image);
        imageLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        c.add(imageLabel);

        c.setFocusable(true);
        c.requestFocus();
        setSize(500, 500);
        setVisible(true);

    }

    // 클래스 MyMouseListener: 기말고사 대비 예제입니다. 이미지 라벨을 키보드로 이동시키는 예제입니다.
    class MyMouseListener extends MouseAdapter {

        // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
        public void mouseClicked(MouseEvent e) {
            int clicks = e.getClickCount();

            if (clicks > 1) {
                imageLabel.setLocation(imageLabel.getX() + 10, imageLabel.getY());
            } else if (clicks == 1) {
                imageLabel.setLocation(e.getX(), e.getY());
            }
        }

        // mouseDragged(): 이 클래스의 기능을 수행하는 메소드입니다.
        public void mouseDragged(MouseEvent e) {
            imageLabel.setLocation(e.getX(), e.getY());
        }

    }

    // 클래스 MyKeyListener: 기말고사 대비 예제입니다. 이미지 라벨을 키보드로 이동시키는 예제입니다.
    class MyKeyListener extends KeyAdapter {
        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent k) {
            if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
                imageLabel.setLocation(imageLabel.getX() + 10, imageLabel.getY());
            }
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new paladog();
    }

}
