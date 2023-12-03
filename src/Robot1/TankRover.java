package Robot1;

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
                    maxWeaponWeight -= 10;
                    speed -= 5;
                } else {
                    throw new IllegalArgumentException("Can not use Robot1.Claw on this target anymore");
                }
            } else if (weapon instanceof Blaster) {
                super.attack(target, weapon);
                maxWeaponWeight -= 20;
                speed -= 10;
        }
    }
}
