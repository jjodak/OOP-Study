/*
 * 파일 설명: 기말고사 대비 예제입니다. 내부 클래스로 이벤트 리스너를 작성하는 예제입니다.
 * 학습 내용: Swing 이벤트 처리 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 InnerClassListener: 기말고사 대비 예제입니다. 내부 클래스로 이벤트 리스너를 작성하는 예제입니다.
public class InnerClassListener extends JFrame {
    // InnerClassListener(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        setSize(350, 150);
        setVisible(true);

    }

    private class MyActionListener implements ActionListener {

        // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("Action")) {
                b.setText("액션");
            } else {
                b.setText("Action");
            }
            InnerClassListener.this.setTitle(b.getText());
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new InnerClassListener();
    }

}
