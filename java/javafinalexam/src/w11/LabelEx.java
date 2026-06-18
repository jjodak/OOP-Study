/*
 * 파일 설명: 기말고사 대비 예제입니다. JLabel과 이미지 라벨 사용 예제입니다.
 * 학습 내용: Swing 컴포넌트, 버튼, 라디오 버튼, 체크박스 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 LabelEx: 기말고사 대비 예제입니다. JLabel과 이미지 라벨 사용 예제입니다.
public class LabelEx extends JFrame {
    // LabelEx(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public LabelEx() {
        setTitle("레이블 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("사랑합니다.");

        ImageIcon img = new ImageIcon("javafinalexam/src/w11/images/beauty.jpg");
        JLabel imageLabel = new JLabel(img);

        ImageIcon normalIcon = new ImageIcon("javafinalexam/src/w11/images/normalIcon.gif");
        JLabel label = new JLabel("보고싶으면 전화하세요", normalIcon, SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);

        setSize(400, 600);
        setVisible(true);
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new LabelEx();
    }

}