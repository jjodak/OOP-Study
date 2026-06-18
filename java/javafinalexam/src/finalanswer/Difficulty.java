/*
 * 파일 설명: 기말고사 최종 답안입니다. 난이도 이름과 좀비 이동 간격을 enum으로 관리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

// 난이도별 좀비 이동 속도를 관리하는 enum입니다.
// 숫자가 작을수록 좀비가 더 자주 움직이므로 난이도가 높습니다.
public enum Difficulty {
    // Easy는 1초마다 좀비가 움직입니다.
    EASY("Easy", 1000),
    // Normal은 중간 속도로 좀비가 움직입니다.
    NORMAL("Normal", 650),
    // Hard는 가장 짧은 간격으로 좀비가 움직입니다.
    HARD("Hard", 350);

    // 라디오 버튼과 상태 라벨에 보여줄 난이도 이름
    private final String label;
    // 좀비가 한 번 움직인 뒤 다음 이동까지 기다리는 시간(ms)
    private final int zombieMoveDelay;

    // 각 난이도의 표시 이름과 이동 간격을 저장합니다.
    Difficulty(String label, int zombieMoveDelay) {
        this.label = label;
        this.zombieMoveDelay = zombieMoveDelay;
    }

    // 화면에 표시할 난이도 이름을 반환합니다.
    public String getLabel() {
        return label;
    }

    // 게임 루프에서 좀비 이동 간격으로 사용할 값을 반환합니다.
    public int getZombieMoveDelay() {
        return zombieMoveDelay;
    }
}
