/*
 * 파일 설명: 기말고사 대비 예제입니다. Swing 체크박스 사용 예제입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 CheckBoxEx: 기말고사 대비 예제입니다. Swing 체크박스 사용 예제입니다.
public class CheckBoxEx extends JFrame {
    // CheckBoxEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public CheckBoxEx() {
        setTitle("체크막스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon cherryIcon = new ImageIcon("javafinalexam/src/w11/images/cherry.jpg");
        ImageIcon selextedCherryIcon = new ImageIcon("javafinalexam/src/w11/images/selectedCherry.jpg");

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배");
        JCheckBox cherry = new JCheckBox("체리", cherryIcon);
        cherry.setBorderPainted(true);
        cherry.setSelectedIcon(selextedCherryIcon);

        c.add(apple);
        c.add(pear);
        c.add(cherry);

        setSize(250, 200);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new CheckBoxEx();
    }
}
