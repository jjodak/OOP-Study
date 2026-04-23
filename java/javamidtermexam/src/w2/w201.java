//(실습과제 2-1 자료유형) 화면에 출력하기
//
//자신의 이름(문자열),
//자신의 나이(정수형)
//자신의 생년월일 8자리(정수형)
//자신의 키(실수형)
//각각의 자료유형으로 저장하고 그 값을 출력하세요.

package w2;

public class w201 {
    public static void main(String[] args) {
        String name = "조준혁";
        int age = 23;
        int birth = 20040602;
        float hight = 173;

        System.out.println(name);
        System.out.println(age);
        System.out.println(birth);
        System.out.println(hight);
    }
}
