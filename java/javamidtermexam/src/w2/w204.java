//(실습과제 2-4 입력받기) 주사위 게임 만들기
//
//1. 두 사람이 주사위를 던져서 더 큰 숫자가 나오는 사람이 이기는 프로그램을 만드세요.
//
//2. 이 때 먼저 던지는 사람의 이름을 입력받고 주사위 던진 결과를 출력하도록 하세요
//
//(예 :  이름 : 손오공 (입력) 던진 주사위 숫자는 6
//
//         이름 : 저팔계 (입력) 던진 주사위 숫자는 3
//
//         이긴 사람은 손오공)

package w2;

import java.util.*;

public class w204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째 사람의 이름을 입력해주세요.");
        String p1 = sc.next();
        int p1dice = (int)(Math.random()*6)+1;
        System.out.println("이름 : " + p1 + " 던진 주사위 숫자는 " + p1dice);

        System.out.println("두 번째 사람의 이름을 입력해주세요.");
        String p2 = sc.next();
        int p2dice = (int)(Math.random()*6)+1;
        System.out.println("이름 : " + p2 + " 던진 주사위 숫자는 " + p2dice);

        if(p1dice > p2dice){
            System.out.println("이긴 사람은 " + p1);
        }else if(p1dice == p2dice ){
            System.out.println("비겼습니다.");
        }else if(p2dice > p1dice){
            System.out.println("이긴 사람은 " + p2);
        }
    }
}
