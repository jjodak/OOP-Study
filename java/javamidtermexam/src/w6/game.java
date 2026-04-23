//1) 게임 확장을 위해 먼저 게임에 나오는 모든 캐릭터의 부모인 유닛(Unit) 클래스를 만드시오.
//• Unit  클래스는 추상 클래스이다.
//• Unit  클래스는  이름(name),  현재위치(pos)를 멤버변수로 가진다.
//• 왼쪽으로 위치를 1 움직이는 left(), 오른쪽으로 위치를 1 움직이는 right() 메소드를 가진다. (화면 1~20 밖으로 나가지 않도록 처리)
//• Unit  클래스는 움직이기(move) 기능을 추상 메소드로 가진다.
//• Unit 클래스는 생성자를 가진다.(이름, 현재위치)
//
//2) 주인공(Hero) 클래스와 좀비(Zombie) 클래스가 Unit 클래스를 상속받아 구현되도록 기존 코드를 수정하세요.
//• Unit이라는 추상클래스를 상속받았기 때문에 move 라는 추상메소드를 반드시 구현해야함
//• Hero 클래스의 move 메소드 안에는 입력을 받아 왼쪽, 오른쪽, 또는 점프할 수 있도록 구현
//• Zombie 클래스의 move 메소드 안에는 왼쪽, 오른쪽으로 랜덤하게 이동하도록만 구현
//
//3) 좀비킹 이라는 새로운 캐릭터를 하나 추가해보자
//• 좀비킹은 기존 좀비와 다르게 순간 이동을 할 수 있어 1~20사이의 어느 위치로든 바로 이동할 수 있음
//• 추상메소드 move를 다르게 구현하여 기능을 만들어보고 실행해보자
package w6;

import java.util.HashMap;

public class game {
    public static void main(String[] args) {
        hero hero = new hero("준혁",1);
        zombie z1 = new zombie("1번",10, hero);
        zombie z2 = new zombie("2번", 25, hero);

        Thread thread1 = new Thread(z1);
        Thread thread2 = new Thread(z2);

        thread1.start();
        thread2.start();

        while(true){
            hero.move();

            System.out.println("내 위치 : " + hero.pos);
            System.out.println("1번 위치 : " + z1.pos);
            System.out.println("2번 위치 : " + z2.pos);

            if (hero.pos == 20) {
                System.out.println("목적지까지 무사히 도착했습니다! 승리!");

                z1.running = false;
                z2.running = false;
                break;
            }
        }
    }
}
