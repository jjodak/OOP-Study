//1.좀비 게임을 만들어보자.
//맵은 1~20까지이며 맵에 있는 좀비를 피해 20까지 도착하는 종료하는 게임
//“좀비1”은 맵 위치 7 ,“좀비2”, 맵 위치 15 을 가지는 좀비를 생성하자.
//주인공은 사용자로부터 입력을 받아  1번이 입력되면 움직이기(왼쪽), 2번이 입력되면 움직이기(오른쪽), 3번이 입력되면 점프하기(랜덤하게 오른쪽으로 1~3움직임)를 실행하도록 하자
//내가 먼저 이동하고 좀비들은 한턴마다 랜덤하게 좌우로 1씩 움직이기 동작을 실행하도록 하자.
//주인공의 위치와 좀비의 위치가 같아 부딪치면 “좀비에게 잡혔습니다. 처음위치에서 다시 시작합니다.” 라고 출력하세요.
//주인공이 20에 다다르면 “미션 클리어!!! 목적지에 도착했습니다” 출력
//매 턴마다 주인공과 좀비의 위치를 출력하세요.

package w2;
import java.util.*;

public class w208 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hpos = 1;
        int z1pos = 7;
        int z2pos = 15;
        int round = 1;

        while(true){
            System.out.println("========" + round + "라운드 ========");

            round ++;
            System.out.println("1: 왼쪽, 2: 오른쪽, 3: 점프");
            int playerinput = sc.nextInt();

            switch(playerinput){
                case 1:
                    if(hpos > 1){
                        hpos --;
                        System.out.println("왼쪽으로 한 칸 이동");
                    }else{
                        System.out.println("잘못 된 이동");
                    }
                    break;
                case 2:
                    if(hpos < 20){
                        hpos ++;
                        System.out.println("오른쪽으로 한 칸 이동");
                    }else{
                        System.out.println("잘못 된 이동");
                    }
                    break;
                case 3:
                    int jmove = (int)(Math.random()*3)+1;
                    hpos += jmove;
                    System.out.println("점프하여 오른쪽으로 " + jmove + "칸 이동");
                    break;
            }

            int z1move = (int)(Math.random()*2);
            int z2move = (int)(Math.random()*2);

            switch(z1move){
                case 0:
                    if(z1pos > 1){
                        z1pos --;
                    }
                    break;
                case 1:
                    if(z1pos < 20){
                        z1pos ++;
                    }
                    break;
            }

            switch(z2move){
                case 0:
                    if(z2pos > 1){
                        z2pos --;
                    }
                    break;
                case 1:
                    if(z2pos < 20){
                        z2pos ++;
                    }
                    break;
            }

            System.out.println("========================");
            System.out.println("플레이어 위치 : " + hpos);
            System.out.println("좀비 1 위치 : " + z1pos + " || 좀비 2 위치 : " + z2pos);
            System.out.println("========================");

            if(hpos == z1pos || hpos == z2pos){
                System.out.println("좀비에게 잡혔습니다. 처음으로 돌아갑니다.");
                hpos = 1;
            }else if(hpos == 20){
                System.out.println("미션 클리어!!! 목적지에 도착했습니다");
                break;
            }
        }
    }
}
