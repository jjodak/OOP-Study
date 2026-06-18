/*
 * 파일 설명: 기말고사 최종 답안입니다. 게임 진행 상태를 enum으로 관리합니다.
 * 학습 내용: 기말고사 문제를 해결한 최종 Swing 좀비 보물 게임 답안 코드
 * 주석 목적: 코드의 역할과 실행 흐름을 쉽게 이해하기 위해 설명을 추가했습니다.
 */

package finalanswer;

// 게임의 현재 진행 상태를 나타내는 enum입니다.
// 상태 라벨에 출력할 한글 이름을 함께 보관합니다.
public enum GameState {
    // 아직 시작하지 않은 상태
    READY("준비"),
    // Start 버튼을 눌러 게임 스레드가 동작 중인 상태
    RUNNING("진행 중"),
    // 점수 100점 이상을 달성한 상태
    WON("승리"),
    // 좀비와 충돌해서 게임이 끝난 상태
    GAME_OVER("게임 오버");

    // 화면에 표시할 상태 이름
    private final String label;

    // enum 상수마다 표시 문자열을 연결합니다.
    GameState(String label) {
        this.label = label;
    }

    // 상태 라벨에서 사용할 문자열을 반환합니다.
    public String getLabel() {
        return label;
    }
}
