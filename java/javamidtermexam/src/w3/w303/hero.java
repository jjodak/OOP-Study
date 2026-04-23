package w3.w303;

public class hero {
    String name;
    int hp;

    public hero(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    public void attack(hero enemy, int max){
        int atk = (int)(Math.random()*max)+1;
        enemy.hp -= atk;

        System.out.println(name +"의 " + atk +"만큼 공격 -> " +enemy.name+ "의 남은 체력: " + enemy.hp);
    }
}
