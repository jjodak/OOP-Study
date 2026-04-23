//1. (배열) 좀비게임을 다음과 같이 수정하세요.
//
//   - 좀비를 5개 만들고 맵의 크기를 30으로 확장하여 보자.
//
//   - 배열을 이용하여 좀비의 위치를 저장하세요.

package w3;

import java.util.*;

public class w301 {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int zombie[] = {5,10,15,20,25};
        int hpos = 1;
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
                    if(hpos < 30){
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
                default:
                    System.out.println("잘못 된 입력입니다.");
            }

            System.out.println("플레이어 위치 : " + hpos);

            System.out.println("================");
            for(int i = 0; i < zombie.length; i++){
                int zmove = (int)(Math.random()*2);

                if(zmove == 0){
                    if(zombie[i] > 1){
                        zombie[i] --;
                    }
                }else{
                    if(zombie[i] < 30){
                        zombie[i] ++;
                    }
                }
                System.out.println("좀비"+(i+1)+" 위치: " + zombie[i]);
            }
            System.out.println("================");

            if(hpos >= 30){
                System.out.println("미션 클리어!! 목적지에 도착했습니다");
                break;
            }else{
                for(int i = 0; i < zombie.length; i++){
                    if(hpos == zombie[i]){
                        System.out.println("좀비에게 잡혔습니다. 처음으로 돌아갑니다.");
                        hpos = 1;
                    }
                }
            }

        }


    }
}
