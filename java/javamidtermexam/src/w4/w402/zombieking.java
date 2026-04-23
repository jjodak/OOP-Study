package w4.w402;

public class zombieking extends unit{
    public zombieking(String name, int pos){
        super(name, pos);
    }

    @Override
    void move() {
        pos = (int)(Math.random()*20)+1;
        System.out.println(name + "이(가) "+pos+"로 순간이동");

    }
}
