/*
 * 파일 설명: 수업 실습 예제입니다. 가위바위보 이미지를 버튼과 랜덤 결과로 처리하는 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 gawibawibo: 수업 실습 예제입니다. 가위바위보 이미지를 버튼과 랜덤 결과로 처리하는 예제입니다.
public class gawibawibo extends JFrame {

    private JButton gawiBtn;
    private JButton bawiBtn;
    private JButton bobtn;

    private JLabel userLabel;
    private JLabel comLabel;
    private JLabel resultLabel;

    private ImageIcon[] image = {
            new ImageIcon("java/javacodes/src/w12/images/gawi.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/bawi.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/bo.jpg")
    };

    private int user = 0;
    private int com = 0;

    // gawibawibo(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public gawibawibo() {
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        gawiBtn = new JButton(image[0]);
        bawiBtn = new JButton(image[1]);
        bobtn = new JButton(image[2]);

        MyButtonListener listener = new MyButtonListener();
        gawiBtn.addActionListener(listener);
        bawiBtn.addActionListener(listener);
        bobtn.addActionListener(listener);

        userLabel = new JLabel(image[0]);
        comLabel = new JLabel(image[0]);

        resultLabel = new JLabel("Same !!!");
        resultLabel.setForeground(Color.red);

        JPanel userPanel = new JPanel();
        userPanel.setBackground(Color.gray);
        userPanel.add(gawiBtn);
        userPanel.add(bawiBtn);
        userPanel.add(bobtn);
        c.add(userPanel, BorderLayout.NORTH);

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.yellow);
        resultPanel.add(userLabel);
        resultPanel.add(new JLabel("me "));
        resultPanel.add(comLabel);
        resultPanel.add(new JLabel("com "));
        resultPanel.add(resultLabel);
        c.add(resultPanel, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);

    }

    // 클래스 MyButtonListener: 수업 실습 예제입니다. 가위바위보 이미지를 버튼과 랜덤 결과로 처리하는 예제입니다.
    class MyButtonListener implements ActionListener {
        // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
        public void actionPerformed(ActionEvent e) {

            com = (int) (Math.random() * 3);

            if (e.getSource() == gawiBtn) {
                user = 0;
                if (com == 0) {
                    resultLabel.setText("Same !!!");
                } else if (com == 1) {
                    resultLabel.setText("Lose !!!");
                } else {
                    resultLabel.setText("Win !!!");
                }
            } else if (e.getSource() == bawiBtn) {
                user = 1;
                if (com == 0) {
                    resultLabel.setText("Win !!!");
                } else if (com == 1) {
                    resultLabel.setText("Same !!!");
                } else {
                    resultLabel.setText("Lose !!!");
                }
            } else if (e.getSource() == bobtn) {
                user = 2;
                if (com == 0) {
                    resultLabel.setText("Lose !!!");
                } else if (com == 1) {
                    resultLabel.setText("Win !!!");
                } else {
                    resultLabel.setText("Same !!!");
                }
            }

            userLabel.setIcon(image[user]);
            comLabel.setIcon(image[com]);
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new gawibawibo();
    }

}
