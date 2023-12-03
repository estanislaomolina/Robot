package Robot2;

public class Blaster extends Weapon {
    public Blaster() {
        super(20, 10);
    }

    @Override
    public int calculateDamage(Robot robot) {
        return robot.getBlasterDamage();
    }
}
