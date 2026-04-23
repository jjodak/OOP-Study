//1) 게임 확장을 위해 먼저 게임에 나오는 모든 캐릭터의 부모인 유닛(Unit) 클래스를 만드시오.
//• Unit  클래스는 추상 클래스이다.
//• Unit  클래스는  이름(name),  현재위치(pos)를 멤버변수로 가진다.
//• 왼쪽으로 위치를 1 움직이는 left(), 오른쪽으로 위치를 1 움직이는 right() 메소드를 가진다. (화면 1~20 밖으로 나가지 않도록 처리)
//• Unit  클래스는 움직이기(move) 기능을 추상 메소드로 가진다.
//• Unit 클래스는 생성자를 가진다.(이름, 현재위치)
//

package w4.w402;

abstract class unit {
    String name;
    int pos;

    public unit(String name, int pos){
        this.name = name;
        this.pos = pos;
    }

    public void left(){
        if(pos > 1) {
            pos--;
            System.out.println(name + "이(가) 왼쪽으로 1칸 이동");
        }
    }

    public void right(){
        if(pos < 50) {
            pos++;
            System.out.println(name + "이(가) 오른쪽으로 1칸 이동");
        }
    }

    abstract void move();
}
