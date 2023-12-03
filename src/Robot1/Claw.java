package Robot1;

import Robot1.Aluminum3000;
import Robot1.Robot;

public class Claw extends Weapon {

    public Claw() {
        super(10, 5);
    }
    @Override
    public int calculateDamage(Robot robot) {
        if (robot instanceof TankRover) {
            return 5;
        } else if (robot instanceof Aluminum3000) {
            return 25;
        } else {
            return 0;
        }
    }

}
