/*
 * 파일 설명: 기말고사 최종 답안입니다. 이미지 로딩과 버튼용 아이콘 생성을 돕는 유틸 클래스입니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

import javax.swing.ImageIcon;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

// 이미지 로딩과 버튼용 간단한 아이콘 생성을 담당하는 보조 클래스입니다.
public final class ImageUtil {
    // 객체를 만들 필요가 없는 유틸 클래스라서 생성자를 막습니다.
    private ImageUtil() {
    }

    // 여러 경로를 차례대로 시도해서 실제로 읽힌 이미지만 반환합니다.
    // 이미지를 못 읽으면 null을 반환하고, 그래픽 클래스가 도형으로 대체 출력합니다.
    public static Image loadImage(String... paths) {
        for (String path : paths) {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() > 0 && icon.getIconHeight() > 0) {
                return icon.getImage();
            }
        }
        return null;
    }

    // 문제 조건의 ImageIcon 사용을 만족하기 위해 버튼에 넣을 작은 원형 아이콘을 직접 만듭니다.
    public static ImageIcon createRoundIcon(Color color, String text) {
        // 투명 배경 이미지 위에 원과 글자를 그립니다.
        BufferedImage image = new BufferedImage(22, 22, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 아이콘의 원형 배경을 그립니다.
        g.setColor(color);
        g.fillOval(2, 2, 18, 18);
        g.setStroke(new BasicStroke(2));
        g.setColor(color.darker());
        g.drawOval(2, 2, 18, 18);

        // 원 안에 버튼을 구분하는 한 글자를 가운데 정렬합니다.
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        int x = (22 - g.getFontMetrics().stringWidth(text)) / 2;
        int y = (22 - g.getFontMetrics().getHeight()) / 2 + g.getFontMetrics().getAscent();
        g.drawString(text, x, y);
        g.dispose();
        return new ImageIcon(image);
    }
}
