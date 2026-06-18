/*
 * 파일 설명: 수업 실습 예제입니다. 주인공의 좌표, 이동, 점프, 그림, 충돌 범위를 관리합니다.
 * 학습 내용: 스레드와 그래픽 객체를 활용한 좀비 게임 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 GraphicHero: 수업 실습 예제입니다. 주인공의 좌표, 이동, 점프, 그림, 충돌 범위를 관리합니다.
public class GraphicHero {
    final int MOVE_STEP = 5;
    final int MAX_X = 500;
    final int MAX_Y = 300;

    int x;
    int y;
    int imgWidth = 20;
    int imgHeight = 26;
    int count;
    int jumpcount = 1;
    int dir;
    boolean toggle;
    boolean jump = false;

    ImageIcon heroImgIcon[] = new ImageIcon[6];
    Image img[] = new Image[6];

    // GraphicHero(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public GraphicHero(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;

        for (int i = 0; i < 6; i++) {
            heroImgIcon[i] = new ImageIcon("javacodes/src/w14/Images/hero0" + (i + 1) + ".png");
            img[i] = heroImgIcon[i].getImage();
        }
    }

    // moveLeft(): 객체를 왼쪽으로 이동시킵니다.
    public void moveLeft() {
        x = x - MOVE_STEP;
        if (x < 0)
            x = 0;
        dir = 2;
    }

    // moveRight(): 객체를 오른쪽으로 이동시킵니다.
    public void moveRight() {
        x = x + MOVE_STEP;
        if (x > MAX_X - imgWidth)
            x = MAX_X - imgWidth;
        dir = 1;
    }

    // heroMove(): 이 클래스의 기능을 수행하는 메소드입니다.
    public boolean heroMove() {
        count++;

        if (jump == true) {
            if (jumpcount <= 5) {
                y -= 10;
                jumpcount++;
            } else if (jumpcount <= 10) {
                y += 10;
                jumpcount++;
            }
            if (jumpcount == 11) {
                jumpcount = 1;
                jump = false;
            }
        }
        if (x >= MAX_X - imgWidth)
            return true;
        else
            return false;

    }

    // paint(): 객체를 화면에 그립니다.
    public void paint(Graphics g) {
        if (dir == 1) {
            if (jump == true) {
                g.drawImage(img[2], x, y, null);
            } else {
                g.drawImage(img[count % 2], x, y, null);
            }
        } else if (dir == 2) {
            if (jump == true) {
                g.drawImage(img[5], x, y, null);
            } else {
                g.drawImage(img[count % 2 + 3], x, y, null);
            }
        }
    }

    // crush(): 두 객체가 충돌했는지 확인합니다.
    public boolean crush(GraphicZombie zombie) {
        int cx = x + 10;
        int cy = y + 13;
        int zx = zombie.x + 10;
        int zy = zombie.y + 13;

        double distance = Math.sqrt(Math.pow(cx - zx, 2) + Math.pow(cy - zy, 2));

        if (distance < 20)
            return true;
        else
            return false;
    }
}
