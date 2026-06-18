/*
 * 파일 설명: 수업 실습 예제입니다. Swing JFrame과 배치 관리자 실습 코드입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// 클래스 w901: 수업 실습 예제입니다. Swing JFrame과 배치 관리자 실습 코드입니다.
public class w901 extends JFrame {
    // w901(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public w901() {
        setTitle("조준혁의 전화");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(new JTextField(15), BorderLayout.NORTH);

        JPanel dial = new JPanel();
        dial.setLayout(new GridLayout(4, 3, 5, 5));
        add(dial, BorderLayout.CENTER);
        dial.add(new JButton("1"));
        dial.add(new JButton("2"));
        dial.add(new JButton("3"));
        dial.add(new JButton("4"));
        dial.add(new JButton("5"));
        dial.add(new JButton("6"));
        dial.add(new JButton("7"));
        dial.add(new JButton("8"));
        dial.add(new JButton("9"));
        dial.add(new JButton("*"));
        dial.add(new JButton("0"));
        dial.add(new JButton("#"));

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        bottom.add(new JButton("키패드"));
        bottom.add(new JButton("최근기록"));
        bottom.add(new JButton("연락처"));
        add(bottom, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(w901::new);
    }
}
