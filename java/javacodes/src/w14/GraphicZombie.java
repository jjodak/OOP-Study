/*
 * 파일 설명: 수업 실습 예제입니다. 좀비의 좌표, 랜덤 이동, 그림, 충돌 범위를 관리합니다.
 * 학습 내용: 스레드와 그래픽 객체를 활용한 좀비 게임 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 GraphicZombie: 수업 실습 예제입니다. 좀비의 좌표, 랜덤 이동, 그림, 충돌 범위를 관리합니다.
public class GraphicZombie {
    final int MOVE_STEP = 5;
    final int MAX_X = 500;
    final int MAX_Y = 300;

    int x;
    int y;
    int imgWidth = 20;
    int imgHeight = 20;
    int dir;
    boolean toggle;

    ImageIcon zombieImgIcon[] = new ImageIcon[2];
    Image img[] = new Image[2];

    // GraphicZombie(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public GraphicZombie(int x, int y) {
        this.x = x;
        this.y = y;

        for (int i = 0; i < 2; i++) {
            zombieImgIcon[i] = new ImageIcon("javacodes/src/w14/Images/enemy" + (i + 1) + ".png");
            img[i] = zombieImgIcon[i].getImage();
        }
    }

    // moveLeft(): 객체를 왼쪽으로 이동시킵니다.
    public void moveLeft() {
        x -= MOVE_STEP;
        if (x < 0)
            x = 0;
    }

    // moveRight(): 객체를 오른쪽으로 이동시킵니다.
    public void moveRight() {
        x += MOVE_STEP;
        if (x > MAX_X - imgWidth)
            x = MAX_X - imgWidth;
    }

    // randomMove(): 랜덤 방향으로 객체를 이동시킵니다.
    public void randomMove() {
        dir = (int) (Math.random() * 3);
        if (dir == 0)
            ;
        else if (dir == 1)
            moveLeft();
        else if (dir == 2)
            moveRight();

        toggle = !toggle;
    }

    // paint(): 객체를 화면에 그립니다.
    public void paint(Graphics g) {
        if (toggle)
            g.drawImage(img[0], x, y, null);
        else
            g.drawImage(img[1], x, y, null);
    }

   // crush(): 두 객체가 충돌했는지 확인합니다.
   public boolean crush(GraphicHero hero) {
        int cx = x + 10;
        int cy = y + 13;
        int zx = hero.x + 10;
        int zy = hero.y + 13;
        
        double distance = Math.sqrt(Math.pow(cx-zx, 2) + Math.pow(cy-zy,2));

        if(distance<20) return true;
        else return false;
    }
}
