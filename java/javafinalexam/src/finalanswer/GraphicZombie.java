/*
 * 파일 설명: 기말고사 최종 답안입니다. 좀비의 좌표, 랜덤 이동, 그림, 충돌 범위를 관리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

// 좀비의 위치, 랜덤 이동, 그리기, 충돌 범위를 관리하는 클래스입니다.
public class GraphicZombie {
    // 좀비를 화면에 그릴 때 사용할 기본 크기입니다.
    public static final int WIDTH = 44;
    public static final int HEIGHT = 48;
    // 랜덤 이동 한 번에 움직일 거리입니다.
    private static final int MOVE_STEP = 28;

    // 좀비의 현재 좌표입니다.
    private int x;
    private int y;
    // 두 이미지를 번갈아 그리기 위한 값입니다.
    private boolean toggle;
    // 랜덤 이동 방향을 고르기 위한 객체입니다.
    private final Random random = new Random();
    // 수업 시간 예제의 좀비 이미지입니다.
    private final Image image1;
    private final Image image2;

    // GraphicZombie(): 객체가 생성될 때 초기 상태와 화면 구성을 설정합니다.
    public GraphicZombie(int x, int y) {
        // 이미지가 없더라도 paint()에서 도형으로 대체되므로 프로그램은 종료되지 않습니다.
        image1 = ImageUtil.loadImage("javacodes/src/w14/Images/enemy1.png",
                "../javacodes/src/w14/Images/enemy1.png");
        image2 = ImageUtil.loadImage("javacodes/src/w14/Images/enemy2.png",
                "../javacodes/src/w14/Images/enemy2.png");
        reset(x, y);
    }

    // 새 게임 또는 Reset 때 좀비를 지정한 위치로 되돌립니다.
    public void reset(int x, int y) {
        this.x = x;
        this.y = y;
        this.toggle = false;
    }

    // 창 크기가 바뀌어도 좀비가 땅 위에 놓이도록 y 좌표를 맞춥니다.
    public void setGroundY(int groundY) {
        y = groundY + GraphicHero.HEIGHT - HEIGHT;
    }

    // -1, 0, 1 중 하나를 뽑아 왼쪽, 정지, 오른쪽 이동을 처리합니다.
    public void randomMove(int panelWidth) {
        int direction = random.nextInt(3) - 1;
        x += direction * MOVE_STEP;
        // 화면 왼쪽 경계 밖으로 나가지 못하게 합니다.
        if (x < 0) {
            x = 0;
        }
        // 화면 오른쪽 경계 밖으로 나가지 못하게 합니다.
        int maxX = Math.max(0, panelWidth - WIDTH);
        if (x > maxX) {
            x = maxX;
        }
        // 이동할 때마다 이미지를 바꿔 간단한 애니메이션처럼 보이게 합니다.
        toggle = !toggle;
    }

    // 좀비를 화면에 그립니다. 이미지가 없으면 초록색 도형으로 대체합니다.
    public void paint(Graphics2D g) {
        Image image = toggle ? image1 : image2;
        if (image != null) {
            g.drawImage(image, x, y, WIDTH, HEIGHT, null);
            return;
        }

        // 이미지 로딩 실패 시 사용할 대체 좀비 그림입니다.
        g.setColor(new Color(72, 160, 82));
        g.fillRoundRect(x + 5, y + 9, WIDTH - 10, HEIGHT - 12, 10, 10);
        g.setColor(new Color(55, 110, 60));
        g.fillOval(x + 8, y, WIDTH - 16, 24);
        g.setColor(Color.RED);
        g.fillOval(x + 14, y + 9, 5, 5);
        g.fillOval(x + 25, y + 9, 5, 5);
    }

    // 주인공과의 충돌 판정에 사용할 사각형 범위를 반환합니다.
    public Rectangle getBounds() {
        return new Rectangle(x + 5, y + 5, WIDTH - 10, HEIGHT - 6);
    }
}
