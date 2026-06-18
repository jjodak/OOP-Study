/*
 * 파일 설명: 수업 실습 예제입니다. 주인공과 좀비가 움직이는 그래픽 게임 예제입니다.
 * 학습 내용: 스레드와 그래픽 객체를 활용한 좀비 게임 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w14;

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
    class GamePanel extends JPanel implements KeyListener, Runnable {

        GraphicZombie zombie1 = new GraphicZombie(150, 170);
        GraphicZombie zombie2 = new GraphicZombie(300, 170);
        GraphicHero hero = new GraphicHero(0, 170, 1);

        boolean heroDead1, heroDead2;

        boolean playgame = true;

        boolean gameover;

        // GamePanel(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
        public GamePanel() {
            hero.dir = 1;
            this.addKeyListener(this);
            new Thread(this).start();
        }

        @Override
        // run(): 스레드가 실행할 반복 동작을 정의합니다.
        public void run() {
            while (playgame) {
                gameover = hero.heroMove();

                if (gameover == true) {
                    repaint();
                    break;
                }

                zombie1.randomMove();
                zombie2.randomMove();

                heroDead1 = zombie1.crush(hero);
                heroDead2 = zombie2.crush(hero);

                repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // paintComponent(): 패널을 다시 그릴 때 호출되어 화면 그래픽을 출력합니다.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.black);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.ORANGE);
            g.fillRect(0, 200, getWidth(), getHeight());

            if (gameover == true) {
                g.drawString("목적지에 도달하였습니다. 게임종료", 200, 150);
                playgame = false;
            }

            if (heroDead1 || heroDead2) {
                g.setColor(Color.red);
                g.drawString("좀비에게 잡혔습니다.", 200, 150);
                playgame = false;
            }

            hero.paint(g);
            zombie1.paint(g);
            zombie2.paint(g);
        }

        // keyTyped(): 문자 키 입력을 처리하기 위한 메소드입니다.
        public void keyTyped(KeyEvent e) {

        }

        // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
        public void keyPressed(KeyEvent e) {

            if (heroDead1 || heroDead2 || gameover) {
                return;
            }

            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                hero.moveRight();
            } else if (key == KeyEvent.VK_LEFT) {
                hero.moveLeft();
            } else if (key == KeyEvent.VK_UP) {
                hero.jump = true;
            }
            heroDead1 = hero.crush(zombie1);
            heroDead2 = hero.crush(zombie2);

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
