package Robot2;

public abstract class Robot {
    protected int health;
    protected int speed;
    protected int maxWeaponWeight;
    protected int clawAttacksLeft;
    public Robot(int health, int speed, int maxWeaponWeight, int clawAttacksLeft) {
        this.health = health;
        this.speed = speed;
        this.maxWeaponWeight = maxWeaponWeight;
        this.clawAttacksLeft = clawAttacksLeft;
    }

    public void attack(Robot target, Weapon weapon) {


        if (weapon.getWeight() <= maxWeaponWeight && weapon.getSpeedDecrease() <= speed) {
            maxWeaponWeight -= weapon.getWeight();
            speed -= weapon.getSpeedDecrease();
            int damage = weapon.calculateDamage(target);
            target.decreaseLife(damage);
        }
        else {
            throw new IllegalArgumentException("Weapon is too heavy");
        }
    }

    public void decreaseLife(int amount) {
        health -= amount;
    }

    public int getClawDamage() {
        return 0;
    }

    public int getBlasterDamage() {
        return 0;
    }
}