package w7.w702;

public class zombie extends unit {
    public zombie(String name, int pos, int hp) {
        super(name, pos, hp);
    }

    @Override
    void move() {
        int zmove = (int) (Math.random() * 2);
        if (zmove == 0) {
            if (pos > 1) {
                left();
            } else {
                right();
            }
        } else if (zmove == 1) {
            if (pos < 50) {
                right();
            } else {
                left();
            }
        }
    }
}
