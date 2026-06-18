/*
 * 파일 설명: 기말고사 최종 답안입니다. 주인공의 좌표, 이동, 점프, 그림, 충돌 범위를 관리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

// 주인공의 위치, 방향, 점프 상태, 그리기, 충돌 범위를 관리하는 클래스입니다.
public class GraphicHero {
    // 주인공을 화면에 그릴 때 사용할 기본 크기입니다.
    public static final int WIDTH = 42;
    public static final int HEIGHT = 56;
    // 한 번 키를 누르거나 버튼을 눌렀을 때 이동하는 거리입니다.
    private static final int MOVE_STEP = 18;
    // 점프 애니메이션을 몇 단계로 나누어 처리할지 정합니다.
    private static final int JUMP_TOTAL_STEP = 24;
    // 점프할 때 최고 높이입니다.
    private static final int JUMP_HEIGHT = 86;

    // 주인공의 현재 좌표입니다.
    private int x;
    private int y;
    // 땅 위에 서 있을 때의 y 좌표입니다.
    private int groundY;
    // 1이면 오른쪽, -1이면 왼쪽을 바라봅니다.
    private int direction = 1;
    // 현재 점프 애니메이션이 몇 번째 단계인지 저장합니다.
    private int jumpStep;
    // 점프 중인지 여부입니다.
    private boolean jumping;
    // 오른쪽으로 볼 때 사용할 이미지 3장입니다.
    private final Image[] rightImages = new Image[3];
    // 왼쪽으로 볼 때 사용할 이미지 3장입니다.
    private final Image[] leftImages = new Image[3];

    // GraphicHero(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public GraphicHero(int x, int groundY) {
        // 수업 시간 w14 이미지 파일을 우선 사용하고, 경로가 달라도 한 번 더 시도합니다.
        rightImages[0] = ImageUtil.loadImage("javacodes/src/w14/Images/hero01.png",
                "../javacodes/src/w14/Images/hero01.png");
        rightImages[1] = ImageUtil.loadImage("javacodes/src/w14/Images/hero02.png",
                "../javacodes/src/w14/Images/hero02.png");
        rightImages[2] = ImageUtil.loadImage("javacodes/src/w14/Images/hero03.png",
                "../javacodes/src/w14/Images/hero03.png");
        leftImages[0] = ImageUtil.loadImage("javacodes/src/w14/Images/hero04.png",
                "../javacodes/src/w14/Images/hero04.png");
        leftImages[1] = ImageUtil.loadImage("javacodes/src/w14/Images/hero05.png",
                "../javacodes/src/w14/Images/hero05.png");
        leftImages[2] = ImageUtil.loadImage("javacodes/src/w14/Images/hero06.png",
                "../javacodes/src/w14/Images/hero06.png");
        reset(x, groundY);
    }

    // 새 게임 또는 Reset 때 주인공을 시작 위치로 되돌립니다.
    public void reset(int startX, int groundY) {
        this.x = startX;
        this.groundY = groundY;
        this.y = groundY;
        this.direction = 1;
        this.jumpStep = 0;
        this.jumping = false;
    }

    // 창 크기가 바뀌어도 땅 위치에 맞게 주인공 y 좌표를 조정합니다.
    public void setGroundY(int groundY) {
        this.groundY = groundY;
        if (!jumping) {
            y = groundY;
        }
    }

    // 왼쪽으로 이동하고, 화면 밖으로 나가지 않도록 x 좌표를 제한합니다.
    public void moveLeft(int panelWidth) {
        direction = -1;
        x -= MOVE_STEP;
        if (x < 0) {
            x = 0;
        }
    }

    // 오른쪽으로 이동하고, 패널 너비 안에서만 움직이도록 제한합니다.
    public void moveRight(int panelWidth) {
        direction = 1;
        x += MOVE_STEP;
        int maxX = Math.max(0, panelWidth - WIDTH);
        if (x > maxX) {
            x = maxX;
        }
    }

    // 이미 점프 중일 때는 중복 점프가 시작되지 않게 합니다.
    public void jump() {
        if (!jumping) {
            jumping = true;
            jumpStep = 1;
        }
    }

    // 게임 루프에서 반복 호출되어 점프 곡선을 만듭니다.
    public void updateJump() {
        if (!jumping) {
            return;
        }

        // sin 곡선을 사용해 자연스럽게 올라갔다가 내려오도록 y 좌표를 계산합니다.
        double ratio = Math.sin(Math.PI * jumpStep / JUMP_TOTAL_STEP);
        y = groundY - (int) (ratio * JUMP_HEIGHT);
        jumpStep++;
        if (jumpStep > JUMP_TOTAL_STEP) {
            jumping = false;
            jumpStep = 0;
            y = groundY;
        }
    }

    // 주인공을 화면에 그립니다. 이미지가 없으면 색깔 도형으로 대체합니다.
    public void paint(Graphics2D g, int animationCount) {
        Image image = getCurrentImage(animationCount);
        if (image != null) {
            g.drawImage(image, x, y, WIDTH, HEIGHT, null);
            return;
        }

        // 이미지 로딩 실패 시 방향에 따라 다른 색 도형을 그립니다.
        g.setColor(direction == 1 ? new Color(64, 128, 255) : new Color(255, 140, 60));
        g.fillRoundRect(x + 7, y + 10, WIDTH - 14, HEIGHT - 16, 12, 12);
        g.setColor(new Color(255, 224, 184));
        g.fillOval(x + 8, y, WIDTH - 16, 24);
        g.setColor(Color.WHITE);
        if (direction == 1) {
            g.fillOval(x + 25, y + 8, 5, 5);
        } else {
            g.fillOval(x + 12, y + 8, 5, 5);
        }
    }

    // 충돌 판정에 사용할 사각형 범위를 반환합니다.
    public Rectangle getBounds() {
        return new Rectangle(x + 4, y + 5, WIDTH - 8, HEIGHT - 7);
    }

    // 현재 x 좌표를 반환합니다.
    public int getX() {
        return x;
    }

    // 현재 y 좌표를 반환합니다.
    public int getY() {
        return y;
    }

    // 방향과 점프 상태에 맞는 이미지를 고릅니다.
    private Image getCurrentImage(int animationCount) {
        Image[] images = direction == 1 ? rightImages : leftImages;
        // 점프 중에는 점프 이미지, 평소에는 두 장의 걷기 이미지를 번갈아 사용합니다.
        int index = jumping ? 2 : animationCount % 2;
        return images[index];
    }
}
