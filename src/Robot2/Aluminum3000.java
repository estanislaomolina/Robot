package Robot2;

public class Aluminum3000 extends Robot {
    public Aluminum3000() {
        super(100, 90, 50,2);
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
        return 25;
    }
    @Override
    public int getBlasterDamage() {
        return 5;
    }
}
