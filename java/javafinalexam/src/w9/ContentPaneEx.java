/*
 * 파일 설명: 기말고사 대비 예제입니다. JFrame의 content pane 사용 방법을 보여주는 예제입니다.
 * 학습 내용: Swing JFrame과 배치 관리자 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ContentPaneEx: 기말고사 대비 예제입니다. JFrame의 content pane 사용 방법을 보여주는 예제입니다.
public class ContentPaneEx extends JFrame {
    // ContentPaneEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ContentPaneEx() {
        setTitle("ContentPane과 JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(300, 150);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new ContentPaneEx();
    }

}
