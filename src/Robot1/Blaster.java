package Robot1;

import Robot1.Aluminum3000;

public class Blaster extends Weapon {
    public Blaster() {
        super(20, 10);
    }
    @Override
    public int calculateDamage(Robot robot) {
        if (robot instanceof TankRover) {
            return 50;
        } else if (robot instanceof Aluminum3000) {
            return 5;
        } else {
            return 0;
        }
    }
}
