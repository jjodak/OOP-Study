/*
 * 파일 설명: 기말고사 대비 예제입니다. FlowLayout으로 컴포넌트를 배치하는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;
import java.awt.*;

// 클래스 FlowLayoutEx: 기말고사 대비 예제입니다. FlowLayout으로 컴포넌트를 배치하는 예제입니다.
public class FlowLayoutEx extends JFrame {
    // FlowLayoutEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public FlowLayoutEx() {
        setTitle("FlowLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        // FlowLayout.정렬위치, 수평간격, 수직간격

        c.add(new JButton("add"));
        c.add(new JButton("sub"));
        c.add(new JButton("Ignores"));
        c.add(new JButton("mul"));
        c.add(new JButton("Calculate"));

        setSize(300, 200);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new FlowLayoutEx();
    }

}
