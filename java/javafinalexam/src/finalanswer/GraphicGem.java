/*
 * 파일 설명: 기말고사 최종 답안입니다. 보물의 종류, 점수, 위치, 랜덤 생성, 그림을 관리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;

// 보물의 종류, 점수, 위치, 랜덤 생성, 그리기를 담당하는 클래스입니다.
public class GraphicGem {
    // 보물을 그릴 때 사용할 정사각형 기준 크기입니다.
    public static final int SIZE = 34;

    // 보물 이름 목록입니다.
    private static final String[] NAMES = {"Diamond", "Gold", "Silver"};
    // 보물 이름과 같은 인덱스에 있는 점수입니다.
    private static final int[] SCORES = {30, 20, 10};
    // 보물 이름과 같은 인덱스에 있는 색입니다.
    private static final Color[] COLORS = {
            new Color(60, 210, 255),
            new Color(245, 184, 39),
            new Color(185, 195, 205)
    };

    // 현재 화면에 나타난 보물 정보입니다.
    private String name = "Diamond";
    private int score = 30;
    private Color color = COLORS[0];
    private int x;
    private int y;

    // 보물 종류와 위치를 랜덤으로 다시 정합니다.
    public void randomize(Random random, int panelWidth, int panelHeight, int groundY) {
        // Diamond, Gold, Silver 중 하나를 고릅니다.
        int index = random.nextInt(NAMES.length);
        name = NAMES[index];
        score = SCORES[index];
        color = COLORS[index];

        // x 좌표는 화면 폭 안에서 랜덤으로 고릅니다.
        int maxX = Math.max(1, panelWidth - SIZE);
        x = random.nextInt(maxX);
        // y 좌표는 주인공이 닿을 수 있는 땅 주변 높이로 제한합니다.
        int minY = Math.max(30, groundY - 70);
        int maxY = Math.max(minY + 1, Math.min(panelHeight - SIZE - 20, groundY + 12));
        y = minY + random.nextInt(maxY - minY);
    }

    // 마우스로 게임 패널을 클릭했을 때 보물 중심을 클릭 위치로 옮깁니다.
    public void moveTo(int centerX, int centerY, int panelWidth, int panelHeight) {
        x = centerX - SIZE / 2;
        y = centerY - SIZE / 2;
        // 왼쪽과 위쪽 화면 밖으로 나가지 않도록 보정합니다.
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        // 오른쪽과 아래쪽 화면 밖으로 나가지 않도록 보정합니다.
        int maxX = Math.max(0, panelWidth - SIZE);
        int maxY = Math.max(0, panelHeight - SIZE);
        if (x > maxX) {
            x = maxX;
        }
        if (y > maxY) {
            y = maxY;
        }
    }

    // 보물을 다이아몬드 모양의 Polygon으로 그립니다.
    public void paint(Graphics2D g) {
        Polygon gem = new Polygon();
        gem.addPoint(x + SIZE / 2, y);
        gem.addPoint(x + SIZE - 3, y + 12);
        gem.addPoint(x + SIZE - 10, y + SIZE - 2);
        gem.addPoint(x + 10, y + SIZE - 2);
        gem.addPoint(x + 3, y + 12);

        // 보물 색으로 내부를 채우고 테두리를 진하게 그립니다.
        g.setColor(color);
        g.fillPolygon(gem);
        g.setColor(color.darker());
        g.drawPolygon(gem);
        // Diamond, Gold, Silver의 첫 글자를 보물 안에 표시합니다.
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 11));
        g.drawString(name.substring(0, 1), x + 13, y + 23);
    }

    // 주인공과의 충돌 판정에 사용할 사각형 범위를 반환합니다.
    public Rectangle getBounds() {
        return new Rectangle(x + 4, y + 4, SIZE - 8, SIZE - 8);
    }

    // 현재 보물 이름을 반환합니다.
    public String getName() {
        return name;
    }

    // 현재 보물 점수를 반환합니다.
    public int getScore() {
        return score;
    }

    // 상태 라벨에 표시할 현재 x 좌표입니다.
    public int getX() {
        return x;
    }

    // 상태 라벨에 표시할 현재 y 좌표입니다.
    public int getY() {
        return y;
    }
}
