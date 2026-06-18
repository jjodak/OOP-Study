/*
 * 파일 설명: 기말고사 대비 예제입니다. 배치 관리자를 사용하지 않고 절대 좌표로 배치하는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;
import java.awt.*;

// 클래스 NullContainerEx: 기말고사 대비 예제입니다. 배치 관리자를 사용하지 않고 절대 좌표로 배치하는 예제입니다.
public class NullContainerEx extends JFrame {
    // NullContainerEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public NullContainerEx() {
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(120, 50);
        la.setSize(200, 20);
        c.add(la);

        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setLocation(i * 15, i * 15);
            btn.setSize(50, 20);
            c.add(btn);
        }

        setSize(300, 200);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new NullContainerEx();
    }
}
