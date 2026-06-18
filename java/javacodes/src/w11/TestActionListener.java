/*
 * 파일 설명: 수업 실습 예제입니다. ActionListener 동작을 확인하는 테스트 코드입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 클래스 TestActionListener: 수업 실습 예제입니다. ActionListener 동작을 확인하는 테스트 코드입니다.
public class TestActionListener extends JFrame {
    // TestActionListener(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public TestActionListener() {
        this.setTitle("이벤트리스너 에제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        this.setSize(350, 150);
        this.setVisible(true);
    }

    // 클래스 MyActionListener: 수업 실습 예제입니다. ActionListener 동작을 확인하는 테스트 코드입니다.
    class MyActionListener implements ActionListener {
        @Override
        // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            btn.setText("Action");

        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new TestActionListener();
    }
}

// 클래스 MyActionListener: 수업 실습 예제입니다. ActionListener 동작을 확인하는 테스트 코드입니다.
class MyActionListener implements ActionListener {
    @Override
    // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
    public void actionPerformed(ActionEvent e) {
        JButton a = (JButton) e.getSource();
        if (a.getText().equals("Action"))
            a.setText("액션");
        else
            a.setText("Action");
    }
}
