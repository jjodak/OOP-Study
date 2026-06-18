/*
 * 파일 설명: 수업 실습 예제입니다. 이미지 갤러리와 버튼 이벤트를 연결하는 예제입니다.
 * 학습 내용: 이미지, 버튼 이벤트, 키보드 이벤트를 활용한 Swing 실습 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package w12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 클래스 ImageGallery: 수업 실습 예제입니다. 이미지 갤러리와 버튼 이벤트를 연결하는 예제입니다.
public class ImageGallery extends JFrame {

    private JButton leftbtn;
    private JButton rightbtn;

    private JLabel imageLabel = new JLabel();

    private ImageIcon[] image = {
            new ImageIcon("java/javacodes/src/w12/images/image0.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/image1.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/image2.jpg"),
            new ImageIcon("java/javacodes/src/w12/images/image3.jpg")
    };

    private int index = 0;

    // ImageGallery(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public ImageGallery() {
        setTitle("이미지 갤러리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        leftbtn = new JButton(new ImageIcon("java/javacodes/src/w12/images/left.png"));
        rightbtn = new JButton(new ImageIcon("java/javacodes/src/w12/images/right.png"));

        MyButtonListener listener = new MyButtonListener();
        leftbtn.addActionListener(listener);
        rightbtn.addActionListener(listener);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftbtn);
        buttonPanel.add(rightbtn);
        buttonPanel.setBackground(Color.gray);
        c.add(buttonPanel, BorderLayout.SOUTH);

        imageLabel.setIcon(image[0]);
        c.add(imageLabel, BorderLayout.CENTER);

        setSize(300, 300);
        setVisible(true);
    }

    // 클래스 MyButtonListener: 수업 실습 예제입니다. 이미지 갤러리와 버튼 이벤트를 연결하는 예제입니다.
    class MyButtonListener implements ActionListener {
        // actionPerformed(): 버튼이나 메뉴 같은 액션 이벤트를 처리합니다.
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == leftbtn) {
                index--;
                if (index < 0) {
                    index = 3;
                }
            } else if (e.getSource() == rightbtn) {
                index++;
                if (index >= 4) {
                    index = 0;
                }
            }
            imageLabel.setIcon(image[index]);
        }
    }

    // main(): 프로그램 실행 시작점입니다.
    public static void main(String[] args) {
        new ImageGallery();
    }
}
