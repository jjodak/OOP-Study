/*
 * 파일 설명: 수업 실습 예제입니다. 라디오 버튼 선택 이벤트로 이미지를 바꾸는 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 RadioButtonItemEventEx: 수업 실습 예제입니다. 라디오 버튼 선택 이벤트로 이미지를 바꾸는 예제입니다.
public class RadioButtonItemEventEx extends JFrame {
    private JRadioButton[] radio = new JRadioButton[3];
    private String[] text = { "사과", "배", "체리" };
    private ImageIcon[] image = {
            new ImageIcon("java/javacodes/src/w12/images/apple.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/pear.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/cherry.jpg")
    };
    private JLabel imagelabel = new JLabel();

    // RadioButtonItemEventEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public RadioButtonItemEventEx() {
        setTitle("라디오 버튼 Item Event 에제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel radioPanel = new JPanel();
        radioPanel.setBackground(Color.gray);
        ButtonGroup g = new ButtonGroup();

        for (int i = 0; i < radio.length; i++) {
            radio[i] = new JRadioButton(text[i]);
            g.add(radio[i]);
            radioPanel.add(radio[i]);
            radio[i].addItemListener(new MyItemListener());
        }

        radio[2].setSelected(true);
        c.add(radioPanel, BorderLayout.NORTH);
        c.add(imagelabel, BorderLayout.CENTER);

        imagelabel.setHorizontalAlignment(SwingConstants.CENTER);
        setSize(250, 200);
        setVisible(true);
    }

    // 클래스 MyItemListener: 수업 실습 예제입니다. 라디오 버튼 선택 이벤트로 이미지를 바꾸는 예제입니다.
    class MyItemListener implements ItemListener {
        // itemStateChanged(): 체크박스나 라디오 버튼의 선택 상태 변화를 처리합니다.
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (radio[0].isSelected()) {
                    imagelabel.setIcon(image[0]);
                } else if (radio[1].isSelected()) {
                    imagelabel.setIcon(image[1]);
                } else if (radio[2].isSelected()) {
                    imagelabel.setIcon(image[2]);
                }
            }
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new RadioButtonItemEventEx();
    }
}
