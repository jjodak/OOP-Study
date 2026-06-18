/*
 * 파일 설명: 기말고사 대비 예제입니다. Swing 컴포넌트의 공통 속성과 그리기 기능을 확인하는 예제입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 JComponentEx: 기말고사 대비 예제입니다. Swing 컴포넌트의 공통 속성과 그리기 기능을 확인하는 예제입니다.
public class JComponentEx extends JFrame {
    // JComponentEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public JComponentEx() {
        super("JComponent의 공통 메소드 예제");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton("Disabled Button");
        JButton b3 = new JButton("getX(), getY()");

        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.MAGENTA);
        b1.setFont(new Font("Arial", Font.ITALIC, 20));
        b2.setEnabled(false);
        b3.addActionListener(new ActionListener() {
            // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                JComponentEx frame = (JComponentEx) b.getTopLevelAncestor();
                frame.setTitle(b.getX() + "," + b.getY());
            }
        });
        c.add(b1);
        c.add(b2);
        c.add(b3);

        setSize(250, 250);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new JComponentEx();
    }
}
