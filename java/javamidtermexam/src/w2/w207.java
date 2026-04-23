//(실습과제 2-7 반복문) 격투 게임 만들기 (죽을 때까지 싸우기)
//내 마법사는 체력이 100이고 적 전사는 체력 200으로 수정하세요.
//"공격하려면 1을 누르세요" 라고 출력하고 1을 누르면 공격해서 적의 체력을 줄이세요.
//내 마법사의 공격력은 15-25 사이의 랜덤 공격이고 적 전사의 공격력은 5-15 사이의 랜덤 공격이다.
//누가 승리하였는지 출력하세요. 동시에 체력이 0 이하가 될 경우에는 비겼습니다를 출력하세요.

package w2;

import java.util.*;

public class w207 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int player = 100;
        int warrior = 200;

        while(true){
            System.out.println("공격하려면 1을 누르세요");
            int inputnum = sc.nextInt();
            int playerattack = 0;
            int warriorattack = 0;

            if(inputnum == 1){
                playerattack = (int)(Math.random()*11)+15;
            }

            warriorattack = (int)(Math.random()*11)+5;

            player -= warriorattack;
            warrior -= playerattack;

            System.out.println("내 공격 : " + playerattack + " -> 전사 남은 체력 : " + warrior);
            System.out.println("전사 공격 : " + warriorattack + " -> 내 남은 체력 : " + player);

            if(player <= 0 && warrior <= 0){
                player = 0;
                warrior = 0;
                System.out.println("비겼습니다.");
                break;
            }else if (player <= 0){
                System.out.println("전사가 이겼습니다.");
                break;
            }else if (warrior <= 0){
                System.out.println("내가 이겼습니다.");
                break;
            }
        }

    }
}
