package Robot2;

public class TankRover extends Robot {

    public TankRover() {
        super(100, 40, 200, 1);
    }

    @Override
    public void attack(Robot target, Weapon weapon) {
        if (weapon instanceof Claw) {
                if (target.clawAttacksLeft > 0) {
                    target.clawAttacksLeft--;
                    super.attack(target, weapon);
                } else {
                    throw new IllegalArgumentException("Can not use Claw on this target anymore");
                }
            } else if (weapon instanceof Blaster) {
                super.attack(target, weapon);

        }
    }
    @Override
    public int getClawDamage() {
        return 5;
    }
    @Override
    public int getBlasterDamage() {
        return 50;
    }
}
