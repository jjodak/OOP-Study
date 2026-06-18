/*
 * 파일 설명: 기말고사 대비 예제입니다. 체크박스 선택 이벤트를 처리하는 예제입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 CheckBoxItemEventEx: 기말고사 대비 예제입니다. 체크박스 선택 이벤트를 처리하는 예제입니다.
public class CheckBoxItemEventEx extends JFrame {
    private JCheckBox[] fruits = new JCheckBox[3];
    private String[] names = { "사과", "배", "체리" };
    private JLabel sumLabel;

    // CheckBoxItemEventEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public CheckBoxItemEventEx() {
        setTitle("체크박스 Item Event 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));

        MyItemListener listener = new MyItemListener();
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            c.add(fruits[i]);
            fruits[i].addItemListener(listener);
        }

        sumLabel = new JLabel("현재 0원 입니다.");
        c.add(sumLabel);
        setSize(250, 200);
        setVisible(true);

    }

    // 클래스 MyItemListener: 기말고사 대비 예제입니다. 체크박스 선택 이벤트를 처리하는 예제입니다.
    class MyItemListener implements ItemListener {
        private int sum = 0;

        // itemStateChanged(): 체크박스나 라디오 버튼의 선택 상태 변화를 처리합니다.
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (e.getItem() == fruits[0])
                    sum += 100;
                else if (e.getItem() == fruits[1])
                    sum += 500;
                else if (e.getItem() == fruits[2])
                    sum += 20000;

                sumLabel.setText("현재 " + sum + "원 입니다.");
            }
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new CheckBoxItemEventEx();
    }
}
