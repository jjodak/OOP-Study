/*
 * 파일 설명: 기말고사 최종 답안입니다. 메인 JFrame을 만들고 상태 라벨, 게임 패널, 조작 패널을 배치합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

// 프로그램의 메인 JFrame 클래스입니다.
// BorderLayout으로 상태 표시 영역, 게임 화면, 조작 버튼 영역을 배치합니다.
public class FinalZombieGemGame extends JFrame {
    // 현재 점수, 보물 정보, 상태, 난이도를 보여주는 라벨입니다.
    private final JLabel statusLabel = new JLabel();
    // 실제 게임 그림, 이벤트, 스레드 로직은 GamePanel이 담당합니다.
    private final GamePanel gamePanel = new GamePanel(statusLabel);

    // FinalZombieGemGame(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public FinalZombieGemGame() {
        // 문제에서 요구한 창 제목입니다.
        setTitle("Final Zombie Gem Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(6, 6));

        // 상단 상태 라벨을 설정하고 JFrame의 NORTH 영역에 배치합니다.
        statusLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        statusLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 10, 8, 10));
        add(statusLabel, BorderLayout.NORTH);

        // 중앙에는 직접 그림을 그리는 게임 패널을 배치합니다.
        add(gamePanel, BorderLayout.CENTER);
        // 하단에는 버튼, 라디오 버튼, 체크박스가 들어갑니다.
        add(createControlPanel(), BorderLayout.SOUTH);

        // 컴포넌트 크기에 맞게 창을 만들고 화면 가운데에 띄웁니다.
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // 창이 뜬 뒤 키보드 입력이 바로 게임 패널로 가도록 포커스를 요청합니다.
        gamePanel.requestGameFocus();
    }

    // Start, Reset, 이동 버튼, 난이도 선택, 충돌 범위 체크박스를 만드는 메소드입니다.
    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));

        // 각 버튼에는 텍스트와 ImageIcon을 함께 넣어 문제 조건을 만족합니다.
        JButton startButton = new JButton("Start", ImageUtil.createRoundIcon(new Color(48, 170, 90), "S"));
        JButton resetButton = new JButton("Reset", ImageUtil.createRoundIcon(new Color(210, 90, 75), "R"));
        JButton leftButton = new JButton("Left", ImageUtil.createRoundIcon(new Color(80, 130, 210), "L"));
        JButton jumpButton = new JButton("Jump", ImageUtil.createRoundIcon(new Color(225, 155, 48), "J"));
        JButton rightButton = new JButton("Right", ImageUtil.createRoundIcon(new Color(80, 130, 210), "R"));

        // 버튼 클릭 이벤트를 GamePanel의 게임 동작 메소드와 연결합니다.
        startButton.addActionListener(e -> gamePanel.startGame());
        resetButton.addActionListener(e -> gamePanel.resetGame());
        leftButton.addActionListener(e -> gamePanel.moveHeroLeft());
        jumpButton.addActionListener(e -> gamePanel.jumpHero());
        rightButton.addActionListener(e -> gamePanel.moveHeroRight());

        // 난이도 선택 라디오 버튼 3개를 만들고 ButtonGroup으로 하나만 선택되게 합니다.
        JRadioButton easyButton = new JRadioButton("Easy");
        JRadioButton normalButton = new JRadioButton("Normal", true);
        JRadioButton hardButton = new JRadioButton("Hard");
        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyButton);
        difficultyGroup.add(normalButton);
        difficultyGroup.add(hardButton);

        // 난이도를 바꾸면 좀비 이동 간격과 상태 라벨이 함께 갱신됩니다.
        easyButton.addActionListener(e -> gamePanel.setDifficulty(Difficulty.EASY));
        normalButton.addActionListener(e -> gamePanel.setDifficulty(Difficulty.NORMAL));
        hardButton.addActionListener(e -> gamePanel.setDifficulty(Difficulty.HARD));

        // 체크박스가 선택되면 hero, zombie, gem의 충돌 사각형을 화면에 표시합니다.
        JCheckBox collisionBox = new JCheckBox("Collision");
        collisionBox.addItemListener(e -> gamePanel.setShowCollisionBounds(collisionBox.isSelected()));

        // 만든 컨트롤들을 하단 패널에 순서대로 추가합니다.
        panel.add(startButton);
        panel.add(resetButton);
        panel.add(leftButton);
        panel.add(jumpButton);
        panel.add(rightButton);
        panel.add(easyButton);
        panel.add(normalButton);
        panel.add(hardButton);
        panel.add(collisionBox);
        return panel;
    }

    // Swing GUI는 Event Dispatch Thread에서 시작하는 것이 안전합니다.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // run(): 스레드가 실행할 반복 동작을 정의합니다.
            public void run() {
                new FinalZombieGemGame();
            }
        });
    }
}
