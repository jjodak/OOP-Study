/*
 * 파일 설명: 기말고사 대비 예제입니다. 마우스 클릭과 더블클릭을 구분하는 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ClickAndDoubleClickEx: 기말고사 대비 예제입니다. 마우스 클릭과 더블클릭을 구분하는 예제입니다.
public class ClickAndDoubleClickEx extends JFrame {
    // ClickAndDoubleClickEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ClickAndDoubleClickEx() {
        setTitle("Click and Double Click 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());
        setSize(300, 200);
        setVisible(true);
    }

    // 클래스 MyMouseListener: 기말고사 대비 예제입니다. 마우스 클릭과 더블클릭을 구분하는 예제입니다.
    class MyMouseListener extends MouseAdapter {
        // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);
                Component c = (Component) e.getSource();
                c.setBackground(new Color(r, g, b));
            }
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new ClickAndDoubleClickEx();
    }

}
