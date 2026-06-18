/*
 * 파일 설명: 수업 실습 예제입니다. 주인공과 좀비가 움직이는 그래픽 게임 예제입니다.
 * 학습 내용: paintComponent와 마우스 입력을 활용한 그래픽 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ZombieGame: 수업 실습 예제입니다. 주인공과 좀비가 움직이는 그래픽 게임 예제입니다.
public class ZombieGame extends JFrame {
    GamePanel My = new GamePanel();

    // ZombieGame(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ZombieGame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(My);
        this.setSize(500, 300);
        this.setVisible(true);
        My.setFocusable(true);
        My.requestFocus();
    }

    // 클래스 GamePanel: 수업 실습 예제입니다. 주인공과 좀비가 움직이는 그래픽 게임 예제입니다.
    class GamePanel extends JPanel implements KeyListener {

        ImageIcon icon1 = new ImageIcon("javacodes/src/w13/Images/hero01.png");
        ImageIcon icon2 = new ImageIcon("javacodes/src/w13/Images/hero04.png");

        Image heroRight = icon1.getImage();
        Image heroLeft = icon2.getImage();

        // 주인공 좌표
        int x = 0;
        int y = 170;
        // 주인공 방향 0: 오른쪽, 1: 왼쪽
        int dir = 0;

        // GamePanel(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
        public GamePanel() {
            this.addKeyListener(this);
        }

        // paintComponent(): 패널을 다시 그릴 때 호출되어 화면 그래픽을 출력합니다.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.ORANGE);
            g.fillRect(0, 200, getWidth(), getHeight());

            if (dir == 0)
                g.drawImage(heroRight, x, y, this);
            else if (dir == 1)
                g.drawImage(heroLeft, x, y, this);
        }

        // keyTyped(): 문자 키 입력을 처리하기 위한 메소드입니다.
        public void keyTyped(KeyEvent e) {

        }

        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                dir = 0;
                x += 10;
            } else if (key == KeyEvent.VK_LEFT) {
                dir = 1;
                x -= 10;
            }
            repaint();
        }

        // keyReleased(): 키보드에서 손을 뗐을 때의 동작을 처리합니다.
        public void keyReleased(KeyEvent e) {

        }

    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new ZombieGame();
    }

}
