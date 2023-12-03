package Robot1;

import Robot1.Robot;

public class Weapon {
    protected int weight;
    protected int speedDecrease;
    public Weapon(int weight, int speedDecrease) {
    }
    public int getWeight() {
        return weight;
    }
    public int getSpeedDecrease() {
        return speedDecrease;
    }
    public int calculateDamage(Robot robot) {
        return 0;
 }
}
