//2) 주인공(Hero) 클래스와 좀비(Zombie) 클래스가 Unit 클래스를 상속받아 구현되도록 기존 코드를 수정하세요.
//• Unit이라는 추상클래스를 상속받았기 때문에 move 라는 추상메소드를 반드시 구현해야함
//• Hero 클래스의 move 메소드 안에는 입력을 받아 왼쪽, 오른쪽, 또는 점프할 수 있도록 구현
//• Zombie 클래스의 move 메소드 안에는 왼쪽, 오른쪽으로 랜덤하게 이동하도록만 구현
//

package w6;

import java.util.Scanner;

public class hero extends unit {
    Scanner sc = new Scanner(System.in);

    public hero(String name, int pos) {
        super(name, pos);
    }

    @Override
    void move() {
        System.out.println("1: 왼쪽, 2: 오른쪽, 3: 점프");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                left();
                break;
            case 2:
                right();
                break;
            case 3:
                int jump = (int) (Math.random() * 3) + 1;
                pos += jump;
                System.out.println(name + "이(가) 점프하여 " + jump + "만큼 이동함");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }

    }
}
