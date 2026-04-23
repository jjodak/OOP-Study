package w7.w702;

import java.util.Scanner;

public class hero extends unit {
    Scanner sc = new Scanner(System.in);

    public hero(String name, int pos, int hp) {
        super(name, pos, hp);
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
