/*
 * 파일 설명: 수업 실습 예제입니다. 마우스 드래그 좌표를 저장하고 선을 그리는 예제입니다.
 * 학습 내용: paintComponent와 마우스 입력을 활용한 그래픽 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

// 클래스 MouseDrawLine: 수업 실습 예제입니다. 마우스 드래그 좌표를 저장하고 선을 그리는 예제입니다.
public class MouseDrawLine extends JFrame {

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new MouseDrawLine();

    }

    // 클래스 MyPanel: 수업 실습 예제입니다. 마우스 드래그 좌표를 저장하고 선을 그리는 예제입니다.
    class MyPanel extends JPanel {
        private Vector<Point> vStart = new Vector<Point>();
        private Vector<Point> vEnd = new Vector<Point>();

        // MyPanel(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
        public MyPanel() {
            this.addMouseListener(new MouseAdapter() {
                // mousePressed(): 마우스를 눌렀을 때의 동작을 처리합니다.
                public void mousePressed(MouseEvent e) {
                    Point startP = e.getPoint();
                    vStart.add(startP);
                }

                // mouseReleased(): 마우스 버튼을 놓았을 때의 동작을 처리합니다.
                public void mouseReleased(MouseEvent e) {
                    Point endP = e.getPoint();
                    vEnd.add(endP);
                    repaint();
                }
            });
        }

        // paintComponent(): 패널을 다시 그릴 때 호출되어 화면 그래픽을 출력합니다.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            for (int i = 0; i < vStart.size(); i++) {
                Point s = vStart.elementAt(i);
                Point e = vEnd.elementAt(i);
                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
            }
        }
    }
}
