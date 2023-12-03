package Robot2;

public class Claw extends Weapon {

    public Claw() {
        super(10, 5);
    }

    @Override
    public int calculateDamage(Robot robot) {
        return robot.getClawDamage();

}
}
