package w7.w702;

abstract class unit {
    String name;
    int pos;
    int hp;

    public unit(String name, int pos, int hp){
        this.name = name;
        this.pos = pos;
        this.hp = hp;
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
