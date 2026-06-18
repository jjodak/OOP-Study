/*
 * 파일 설명: 기말고사 최종 답안입니다. 게임 화면 그리기, 키보드/마우스 이벤트, 스레드 루프, 충돌 판정을 처리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 게임 화면을 직접 그리는 JPanel입니다.
// 키보드 이벤트, 마우스 이벤트, 좀비 자동 이동 스레드까지 모두 처리합니다.
public class GamePanel extends JPanel implements KeyListener, MouseListener, Runnable {
    // 게임 패널 기본 크기입니다.
    private static final int DEFAULT_WIDTH = 760;
    private static final int DEFAULT_HEIGHT = 460;
    // 100점 이상이 되면 승리합니다.
    private static final int TARGET_SCORE = 100;
    // 게임 루프가 한 번 돈 뒤 잠깐 쉬는 시간입니다.
    private static final int LOOP_DELAY = 35;

    // JFrame 상단에 있는 상태 라벨을 받아와서 계속 갱신합니다.
    private final JLabel statusLabel;
    // 보물 위치와 종류, 좀비 이동 방향을 랜덤으로 고를 때 사용합니다.
    private final Random random = new Random();
    // 주인공 객체입니다.
    private final GraphicHero hero = new GraphicHero(50, getGroundY());
    // 좀비는 최소 2마리 이상이어야 하므로 List로 관리합니다.
    private final List<GraphicZombie> zombies = new ArrayList<GraphicZombie>();
    // 현재 화면에 있는 보물 1개입니다.
    private final GraphicGem gem = new GraphicGem();

    // 기본 난이도는 Normal입니다.
    private Difficulty difficulty = Difficulty.NORMAL;
    // 게임 시작 전 기본 상태는 READY입니다.
    private GameState state = GameState.READY;
    // 좀비 자동 이동과 화면 갱신을 담당하는 스레드입니다.
    private Thread gameThread;
    // 게임 루프가 계속 돌아야 하는지 나타냅니다.
    private boolean running;
    // 체크박스로 충돌 범위를 표시할지 결정합니다.
    private boolean showCollisionBounds;
    // 현재 점수입니다.
    private int score;
    // 획득한 보물 개수입니다.
    private int gemCount;
    // 이미지 애니메이션 프레임을 바꾸기 위한 카운터입니다.
    private int animationCount;
    // 상태 라벨과 게임 종료 화면에 보여줄 메시지입니다.
    private String message = "Start 버튼을 누르면 시작";

    // GamePanel(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public GamePanel(JLabel statusLabel) {
        super(new BorderLayout());
        this.statusLabel = statusLabel;
        // 패널 크기와 배경색을 설정합니다.
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(Color.BLACK);
        // 키보드 입력을 받기 위해 포커스를 받을 수 있게 합니다.
        setFocusable(true);
        // 방향키, 스페이스바 입력을 처리합니다.
        addKeyListener(this);
        // 마우스 클릭으로 보물 위치를 바꾸기 위해 등록합니다.
        addMouseListener(this);
        // 주인공, 좀비, 보물, 점수 상태를 초기화합니다.
        resetObjects();
        updateStatus();
    }

    // Start 버튼을 눌렀을 때 호출됩니다.
    public synchronized void startGame() {
        // 이미 끝난 게임에서 다시 Start를 누르면 새 게임처럼 초기화합니다.
        if (state == GameState.WON || state == GameState.GAME_OVER) {
            resetObjects();
        }
        // 기존 스레드가 살아 있으면 중복 실행하지 않습니다.
        if (gameThread != null && gameThread.isAlive()) {
            requestGameFocus();
            return;
        }
        // 상태를 진행 중으로 바꾸고 게임 루프 스레드를 시작합니다.
        state = GameState.RUNNING;
        running = true;
        message = "게임 진행 중";
        gameThread = new Thread(this, "FinalZombieGemGameLoop");
        gameThread.start();
        updateStatus();
        requestGameFocus();
    }

    // Reset 버튼을 눌렀을 때 호출됩니다.
    public synchronized void resetGame() {
        // 기존 게임 루프를 멈춥니다.
        running = false;
        if (gameThread != null) {
            gameThread.interrupt();
        }
        // 점수, 위치, 상태를 처음으로 되돌립니다.
        resetObjects();
        updateStatus();
        repaint();
        requestGameFocus();
    }

    // 라디오 버튼에서 선택한 난이도를 반영합니다.
    public synchronized void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        message = "난이도: " + difficulty.getLabel();
        updateStatus();
        requestGameFocus();
    }

    // 체크박스 선택 여부에 따라 충돌 범위 표시를 켜거나 끕니다.
    public synchronized void setShowCollisionBounds(boolean showCollisionBounds) {
        this.showCollisionBounds = showCollisionBounds;
        message = showCollisionBounds ? "충돌 범위 표시" : "충돌 범위 숨김";
        updateStatus();
        repaint();
        requestGameFocus();
    }

    // 버튼이나 라디오 버튼을 누른 뒤에도 방향키 입력이 되도록 게임 패널에 포커스를 돌려줍니다.
    public void requestGameFocus() {
        requestFocusInWindow();
    }

    // Runnable 구현 메소드입니다. 게임 스레드가 이 메소드를 반복 실행합니다.
    @Override
    // run(): 스레드가 실행할 반복 동작을 정의합니다.
    public void run() {
        // 마지막으로 좀비가 움직인 시간을 저장해 난이도별 이동 간격을 맞춥니다.
        long lastZombieMove = 0L;
        while (isRunning()) {
            long now = System.currentTimeMillis();
            synchronized (this) {
                // 주인공 걷기 애니메이션 프레임을 바꿉니다.
                animationCount++;
                // 창 크기 변화에 맞춰 주인공과 좀비의 땅 위치를 다시 계산합니다.
                hero.setGroundY(getGroundY());
                for (GraphicZombie zombie : zombies) {
                    zombie.setGroundY(getGroundY());
                }
                // 점프 중이면 y 좌표를 조금씩 바꿉니다.
                hero.updateJump();
                // 난이도에서 정한 시간이 지났을 때만 좀비를 랜덤 이동시킵니다.
                if (now - lastZombieMove >= difficulty.getZombieMoveDelay()) {
                    for (GraphicZombie zombie : zombies) {
                        zombie.randomMove(getBoardWidth());
                    }
                    lastZombieMove = now;
                }
                // 보물 획득 또는 좀비 충돌이 발생했는지 확인합니다.
                checkCollisions();
            }
            // 화면을 다시 그리도록 요청합니다.
            repaint();

            try {
                // 너무 빠르게 반복되지 않도록 잠깐 멈춥니다.
                Thread.sleep(LOOP_DELAY);
            } catch (InterruptedException e) {
                // Reset처럼 스레드를 멈추는 경우 루프를 빠져나갑니다.
                break;
            }
        }
        // 스레드가 끝난 뒤 상태 라벨을 안전하게 한 번 더 갱신합니다.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // run(): 스레드가 실행할 반복 동작을 정의합니다.
            public void run() {
                updateStatus();
            }
        });
    }

    // Swing이 화면을 다시 그릴 때 자동 호출되는 메소드입니다.
    @Override
    // paintComponent(): 패널을 다시 그릴 때 호출되어 화면 그래픽을 출력합니다.
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Graphics2D로 변환해서 더 부드러운 도형과 글자를 그립니다.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 배경, 보물, 좀비, 주인공 순서로 그립니다.
        paintBackground(g2);
        gem.paint(g2);
        for (GraphicZombie zombie : zombies) {
            zombie.paint(g2);
        }
        hero.paint(g2, animationCount);

        // 체크박스가 선택되어 있으면 충돌 범위를 표시합니다.
        if (showCollisionBounds) {
            paintCollisionBounds(g2);
        }
        // 승리 또는 게임 오버 상태이면 중앙 메시지를 표시합니다.
        if (state == GameState.WON || state == GameState.GAME_OVER) {
            paintCenterMessage(g2);
        }
        // 복사해서 만든 그래픽 객체를 정리합니다.
        g2.dispose();
    }

    // 방향키와 스페이스바 입력을 처리합니다.
    @Override
    // keyPressed(): 키보드를 눌렀을 때의 동작을 처리합니다.
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            moveHeroRight();
        } else if (key == KeyEvent.VK_LEFT) {
            moveHeroLeft();
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE) {
            jumpHero();
        }
    }

    // 이번 답안에서는 keyTyped를 사용하지 않지만 KeyListener 구현을 위해 비워 둡니다.
    @Override
    // keyTyped(): 문자 키 입력을 처리하기 위한 메소드입니다.
    public void keyTyped(KeyEvent e) {
    }

    // 이번 답안에서는 keyReleased를 사용하지 않지만 KeyListener 구현을 위해 비워 둡니다.
    @Override
    // keyReleased(): 키보드에서 손을 뗐을 때의 동작을 처리합니다.
    public void keyReleased(KeyEvent e) {
    }

    // 게임 패널을 클릭하면 현재 보물을 클릭 좌표로 옮깁니다.
    @Override
    // mousePressed(): 마우스를 눌렀을 때의 동작을 처리합니다.
    public synchronized void mousePressed(MouseEvent e) {
        gem.moveTo(e.getX(), e.getY(), getBoardWidth(), getBoardHeight());
        message = "클릭 위치: (" + e.getX() + ", " + e.getY() + ")";
        updateStatus();
        repaint();
        requestGameFocus();
    }

    // 이번 답안에서는 mouseClicked를 사용하지 않지만 MouseListener 구현을 위해 비워 둡니다.
    @Override
    // mouseClicked(): 마우스를 클릭했을 때의 동작을 처리합니다.
    public void mouseClicked(MouseEvent e) {
    }

    // 이번 답안에서는 mouseReleased를 사용하지 않지만 MouseListener 구현을 위해 비워 둡니다.
    @Override
    // mouseReleased(): 마우스 버튼을 놓았을 때의 동작을 처리합니다.
    public void mouseReleased(MouseEvent e) {
    }

    // 이번 답안에서는 mouseEntered를 사용하지 않지만 MouseListener 구현을 위해 비워 둡니다.
    @Override
    // mouseEntered(): 마우스가 컴포넌트 안으로 들어왔을 때 호출됩니다.
    public void mouseEntered(MouseEvent e) {
    }

    // 이번 답안에서는 mouseExited를 사용하지 않지만 MouseListener 구현을 위해 비워 둡니다.
    @Override
    // mouseExited(): 마우스가 컴포넌트 밖으로 나갔을 때 호출됩니다.
    public void mouseExited(MouseEvent e) {
    }

    // Left 버튼 또는 왼쪽 방향키에서 호출되는 주인공 이동 메소드입니다.
    public synchronized void moveHeroLeft() {
        // 게임 진행 중이 아니면 이동하지 않습니다.
        if (!canControlHero()) {
            requestGameFocus();
            return;
        }
        hero.moveLeft(getBoardWidth());
        checkCollisions();
        repaint();
        updateStatus();
        requestGameFocus();
    }

    // Right 버튼 또는 오른쪽 방향키에서 호출되는 주인공 이동 메소드입니다.
    public synchronized void moveHeroRight() {
        // 게임 진행 중이 아니면 이동하지 않습니다.
        if (!canControlHero()) {
            requestGameFocus();
            return;
        }
        hero.moveRight(getBoardWidth());
        checkCollisions();
        repaint();
        updateStatus();
        requestGameFocus();
    }

    // Jump 버튼, 위쪽 방향키, 스페이스바에서 호출되는 점프 메소드입니다.
    public synchronized void jumpHero() {
        // 게임 진행 중이 아니면 점프하지 않습니다.
        if (!canControlHero()) {
            requestGameFocus();
            return;
        }
        hero.jump();
        repaint();
        updateStatus();
        requestGameFocus();
    }

    // 게임 스레드가 계속 돌아야 하는지 확인합니다.
    private synchronized boolean isRunning() {
        return running;
    }

    // 주인공 조작은 RUNNING 상태에서만 허용합니다.
    private boolean canControlHero() {
        return state == GameState.RUNNING;
    }

    // 새 게임이나 Reset 때 모든 게임 데이터를 처음 상태로 되돌립니다.
    private void resetObjects() {
        score = 0;
        gemCount = 0;
        animationCount = 0;
        state = GameState.READY;
        running = false;
        message = "Start 버튼을 누르면 시작";

        // 현재 패널 크기를 기준으로 캐릭터와 보물의 초기 위치를 정합니다.
        int groundY = getGroundY();
        int width = getBoardWidth();
        hero.reset(50, groundY);
        zombies.clear();
        // 문제 조건에 맞게 좀비를 2마리 생성합니다.
        zombies.add(new GraphicZombie(Math.max(160, width / 2), groundY + GraphicHero.HEIGHT - GraphicZombie.HEIGHT));
        zombies.add(new GraphicZombie(Math.max(280, width - 150), groundY + GraphicHero.HEIGHT - GraphicZombie.HEIGHT));
        // 첫 보물을 랜덤으로 생성합니다.
        gem.randomize(random, width, getBoardHeight(), groundY);
    }

    // 주인공과 보물, 주인공과 좀비의 충돌을 검사합니다.
    private void checkCollisions() {
        if (state != GameState.RUNNING) {
            return;
        }

        // 주인공의 충돌 사각형을 기준으로 판정합니다.
        Rectangle heroBounds = hero.getBounds();
        if (heroBounds.intersects(gem.getBounds())) {
            // 보물을 먹으면 점수와 보물 개수를 올립니다.
            int earnedScore = gem.getScore();
            String earnedName = gem.getName();
            score += earnedScore;
            gemCount++;
            // 100점 이상이면 승리로 게임을 종료합니다.
            if (score >= TARGET_SCORE) {
                finishGame(GameState.WON, "보물 100점 달성");
                return;
            }
            // 아직 100점이 아니면 새 보물을 다시 생성합니다.
            message = earnedName + " 획득 +" + earnedScore + "점";
            gem.randomize(random, getBoardWidth(), getBoardHeight(), getGroundY());
            updateStatus();
        }

        // 좀비 중 한 마리라도 주인공과 충돌하면 게임 오버입니다.
        for (GraphicZombie zombie : zombies) {
            if (heroBounds.intersects(zombie.getBounds())) {
                finishGame(GameState.GAME_OVER, "좀비에게 잡혔습니다");
                return;
            }
        }
    }

    // 승리 또는 게임 오버 상태로 게임을 끝냅니다.
    private void finishGame(GameState endState, String endMessage) {
        state = endState;
        message = endMessage;
        running = false;
        updateStatus();
    }

    // 게임 배경과 왼쪽 위의 간단한 점수판을 그립니다.
    private void paintBackground(Graphics2D g) {
        int width = getWidth();
        int height = getHeight();
        int groundTop = getGroundY() + GraphicHero.HEIGHT;

        // 밤하늘 배경입니다.
        g.setColor(new Color(22, 28, 44));
        g.fillRect(0, 0, width, height);
        // 뒤쪽 건물처럼 보이는 사각형 배경입니다.
        g.setColor(new Color(32, 44, 67));
        for (int x = 0; x < width; x += 70) {
            g.fillRect(x, 75 + (x % 140) / 4, 42, 115);
        }
        // 캐릭터가 서 있는 땅입니다.
        g.setColor(new Color(79, 70, 55));
        g.fillRect(0, groundTop, width, Math.max(0, height - groundTop));
        g.setColor(new Color(108, 96, 75));
        g.fillRect(0, groundTop, width, 8);

        // 게임 화면 안에도 점수와 획득 보물 수를 표시합니다.
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        g.drawString("Score " + score + " / " + TARGET_SCORE, 18, 28);
        g.drawString("Gems " + gemCount, 18, 50);
    }

    // 체크박스가 선택되었을 때 각 객체의 충돌 사각형을 그립니다.
    private void paintCollisionBounds(Graphics2D g) {
        g.setStroke(new BasicStroke(2));
        // 주인공은 노란색, 보물은 하늘색, 좀비는 빨간색으로 표시합니다.
        g.setColor(Color.YELLOW);
        g.draw(hero.getBounds());
        g.setColor(Color.CYAN);
        g.draw(gem.getBounds());
        g.setColor(Color.RED);
        for (GraphicZombie zombie : zombies) {
            g.draw(zombie.getBounds());
        }
    }

    // 게임 승리 또는 게임 오버 메시지를 화면 중앙에 크게 그립니다.
    private void paintCenterMessage(Graphics2D g) {
        String text = message;
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 28));
        int textWidth = g.getFontMetrics().stringWidth(text);
        int x = (getWidth() - textWidth) / 2;
        int y = getHeight() / 2;
        // 글자가 잘 보이도록 반투명 배경 상자를 먼저 그립니다.
        g.setColor(new Color(0, 0, 0, 170));
        g.fillRoundRect(x - 24, y - 42, textWidth + 48, 68, 14, 14);
        // 승리와 게임 오버를 다른 색으로 표시합니다.
        g.setColor(state == GameState.WON ? new Color(255, 224, 80) : new Color(255, 105, 105));
        g.drawString(text, x, y);
    }

    // JFrame 상단 상태 라벨의 문자열을 최신 상태로 바꿉니다.
    private void updateStatus() {
        final String statusText = "점수: " + score
                + " | 보물: " + gemCount + "개"
                + " | 현재 보물: " + gem.getName() + "(" + gem.getX() + ", " + gem.getY() + ")"
                + " | 상태: " + state.getLabel()
                + " | 난이도: " + difficulty.getLabel()
                + " | " + message;
        // Swing 컴포넌트 갱신은 Event Dispatch Thread에서 수행해야 안전합니다.
        if (SwingUtilities.isEventDispatchThread()) {
            statusLabel.setText(statusText);
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                // run(): 스레드가 실행할 반복 동작을 정의합니다.
                public void run() {
                    statusLabel.setText(statusText);
                }
            });
        }
    }

    // 아직 화면 크기가 0으로 잡힌 초기 순간에는 기본 너비를 사용합니다.
    private int getBoardWidth() {
        return Math.max(getWidth(), DEFAULT_WIDTH);
    }

    // 아직 화면 크기가 0으로 잡힌 초기 순간에는 기본 높이를 사용합니다.
    private int getBoardHeight() {
        return Math.max(getHeight(), DEFAULT_HEIGHT);
    }

    // 주인공이 서 있을 기준 y 좌표입니다.
    private int getGroundY() {
        return getBoardHeight() - 120;
    }
}
