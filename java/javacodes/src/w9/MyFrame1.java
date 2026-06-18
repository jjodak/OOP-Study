/*
 * 파일 설명: 수업 실습 예제입니다. 기본 JFrame 창을 만드는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import java.awt.*;
import javax.swing.*;

// 클래스 MyFrame: Swing JFrame과 배치 관리자 실습 코드
public class MyFrame1 extends JFrame {
    // MyFrame(): 객체가 생성될 때 초기 상태와 화면 구성을 설정
    public MyFrame1() {
        setTitle("Container & Component");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setLayout(null);
        add(mainPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        leftPanel.setBackground(Color.YELLOW);
        leftPanel.setBounds(20, 20, 200, 250);
        leftPanel.add(new JLabel("Type ID"));
        leftPanel.add(new JTextField(15));
        leftPanel.add(new JLabel("Type Password"));
        leftPanel.add(new JTextField(15));

        mainPanel.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        rightPanel.setBackground(Color.GREEN);
        rightPanel.setBounds(250, 20, 200, 250);
        rightPanel.add(new JLabel("Please Check!!! "));
        rightPanel.add(new JCheckBox("C#JCheckbox"));
        rightPanel.add(new JCheckBox("C++JCheckbox"));

        mainPanel.add(rightPanel);

        JButton ok = new JButton("ok");
        ok.setBounds(180, 300, 100, 30);
        mainPanel.add(ok);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new MyFrame1();
    }
}
