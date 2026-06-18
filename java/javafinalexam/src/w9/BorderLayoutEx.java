/*
 * 파일 설명: 기말고사 대비 예제입니다. BorderLayout으로 컴포넌트를 배치하는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;
import java.awt.*;

// 클래스 BorderLayoutEx: 기말고사 대비 예제입니다. BorderLayout으로 컴포넌트를 배치하는 예제입니다.
public class BorderLayoutEx extends JFrame {
    // BorderLayoutEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public BorderLayoutEx() {
        setTitle("Borderlayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout());
        c.add(new JButton("Calculate"), BorderLayout.CENTER);
        c.add(new JButton("add"), BorderLayout.NORTH);
        c.add(new JButton("sub"), BorderLayout.SOUTH);
        c.add(new JButton("mul"), BorderLayout.EAST);
        c.add(new JButton("div"), BorderLayout.WEST);

        setSize(300, 200);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new BorderLayoutEx();
    }

}
