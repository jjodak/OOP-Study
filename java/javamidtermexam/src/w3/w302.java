//  1) 5 * 5 배열의 맵을 만들고 그 맵을 길과 벽으로 구성하세요.
//  2) 사용자로부터 상하좌우를 입력 받아 이동할 수 있도록 하세요.
//  3) 내 캐릭터는 길로만 움직일 수 있으며 맵 밖으로 나가거나 길 밖으로 나갈 수 없도록 하세요.
//      ("맵 밖으로 나갈 수 없습니다", "벽이 있어서 이동할 수 없습니다.")
//  4) 마지막 목적지 위치 (4,4)에 도착하면 끝나도록 하세요.
//  5) 사용자가 입력한 횟수를 세어 몇 번 만에 목적지에 도착하는지 출력하세요.

package w3;
import java.util.*;

public class w302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int map [][] = {{0,0,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,0,1,1,1},
                        {1,0,0,0,0}};

        int x = 0;
        int y = 0;
        int xmax = 4, ymax = 4;
        int xmin = 0, ymin = 0;

        int round = 0;

        while(true){
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map.length; j++){
                    if(i == y && j == x){
                        System.out.print("p ");
                    }else{
                        System.out.print(map[i][j] + " ");
                    }
                }
                System.out.println();
            }

            System.out.println("wasd를 활용해서 움직이세요.");
            String input = sc.next();

            if(input.equals("w")){
                y--;
                if(y < ymin || map[y][x] == 1) {
                    System.out.println("막혔습니다.");
                    y++;
                }

            }else if(input.equals("s")){
                y++;
                if(y > ymax || map[y][x] == 1){
                    System.out.println("막혔습니다.");
                    y--;
                }
            }else if(input.equals("a")){
                x--;
                if(x < xmin || map[y][x] == 1){
                    System.out.println("막혔습니다.");
                    x++;
                }
            }else if(input.equals("d")){
                x++;
                if(x > xmax || map[y][x] == 1){
                    System.out.println("막혔습니다.");
                x--;
                }
            }

            round ++;

            if(x == 4 && y == 4){
                System.out.println("탈출 성공!! " + round + "만에 성공");
                break;
            }
        }

    }
}
