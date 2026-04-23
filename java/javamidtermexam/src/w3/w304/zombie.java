//  1) 좀비(Zombie) 클래스를 만드세요.
//      (1) Zombie 클래스는  이름,  현재위치를 멤버변수로 가진다.
//      (2) Zombie 클래스는 움직이기(move) 기능이 있다.(메소드)
//           - 랜덤하게 왼쪽 한 칸, 오른쪽으로 한 칸 움직이거나 그 자리에 그냥 있을 수 있다
//           - 랜덤하게 움직이지만 현재위치 값이 화면 밖으로 나가지 않도록 한다.
//           - 움직이기 메소드를 호출하면 예를들어  “좀비1” 의  현재위치는  “10” 입니다. 라고 출력되도록 한다.
//           - 움직이기 메소드를 호출하여 현재위치를 바꿀 수 있다.
//      (3) Zombie 클래스는 생성자를 가진다.(이름, 현재위치)

package w3.w304;

public class zombie {
    String name;
    int pos;

    public zombie(String name, int pos){
        this.name = name;
        this.pos = pos;
    }

    void move(){
        int zmove = (int)(Math.random()*3);

        switch(zmove){
            case 0:
                if(pos > 1){
                    pos --;
                }
                break;
            case 1:
                if(pos < 30){
                    pos ++;
                }
                break;
            default:
                break;
        }

        System.out.println("현재 "+name+"의 위치는 "+pos+"입니다.");
    }
}
