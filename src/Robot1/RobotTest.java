package Robot1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void test01TankRoverAttackTankRoverWithClaw() {
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        TankRover target = new TankRover();
        tankRover.attack(target, claw);
        Assert.assertEquals(190, tankRover.maxWeaponWeight);
        Assert.assertEquals(35, tankRover.speed);
        Assert.assertEquals(0, target.clawAttacksLeft);
        Assert.assertEquals(95, target.health);
    }
    @Test
    public void test02TankRoverAttackTankRoverWithBlaster() {
        TankRover tankRover = new TankRover();
        Blaster blaster = new Blaster();
        TankRover target = new TankRover();
        tankRover.attack(target, blaster);
        Assert.assertEquals(180, tankRover.maxWeaponWeight);
        Assert.assertEquals(30, tankRover.speed);
        Assert.assertEquals(50, target.health);
    }
    @Test
    public void test03TankRoverAttackAluminum3000WithClaw() {
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        Aluminum3000 target = new Aluminum3000();
        tankRover.attack(target, claw);
        Assert.assertEquals(190, tankRover.maxWeaponWeight);
        Assert.assertEquals(35, tankRover.speed);
        assertEquals(1, target.clawAttacksLeft);
        assertEquals(75, target.health);
    }
    @Test
    public void test04TankRoverAttackAluminum3000WithBlaster() {
        TankRover tankRover = new TankRover();
        Blaster blaster = new Blaster();
        Aluminum3000 target = new Aluminum3000();
        tankRover.attack(target, blaster);
        Assert.assertEquals(180, tankRover.maxWeaponWeight);
        Assert.assertEquals(30, tankRover.speed);
        assertEquals(95, target.health);
    }
    @Test
    public void test05Aluminum3000AttackAluminum3000WithClaw() {
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Claw claw = new Claw();
        Aluminum3000 target = new Aluminum3000();
        aluminum3000.attack(target, claw);
        assertEquals(80, aluminum3000.maxWeaponWeight);
        assertEquals(45, aluminum3000.speed);
        assertEquals(1, target.clawAttacksLeft);
        assertEquals(75, target.health);
    }
    @Test
    public void test06Aluminum3000AttackAluminum3000WithBlaster() {
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Blaster blaster = new Blaster();
        Aluminum3000 target = new Aluminum3000();
        aluminum3000.attack(target, blaster);
        assertEquals(70, aluminum3000.maxWeaponWeight);
        assertEquals(40, aluminum3000.speed);
        assertEquals(95, target.health);
    }
    @Test
    public void test07Aluminum3000AttackTankRoverWithClaw() {
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Claw claw = new Claw();
        TankRover target = new TankRover();
        aluminum3000.attack(target, claw);
        assertEquals(80, aluminum3000.maxWeaponWeight);
        assertEquals(45, aluminum3000.speed);
        Assert.assertEquals(0, target.clawAttacksLeft);
        Assert.assertEquals(95, target.health);
    }
    @Test
    public void test08Aluminum3000AttackTankRoverWithBlaster() {
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Blaster blaster = new Blaster();
        TankRover target = new TankRover();
        aluminum3000.attack(target, blaster);
        assertEquals(70, aluminum3000.maxWeaponWeight);
        assertEquals(40, aluminum3000.speed);
        Assert.assertEquals(50, target.health);
    }
    @Test
    public void test09ClawCanOnlyBeUsedTwiceOnAluminum3000() {
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Claw claw = new Claw();
        Aluminum3000 target = new Aluminum3000();
        aluminum3000.attack(target, claw);
        assertEquals(1, target.clawAttacksLeft);
        aluminum3000.attack(target, claw);
        assertEquals(0, target.clawAttacksLeft);
        try {
            aluminum3000.attack(target, claw);
        } catch (IllegalArgumentException e) {
            assertEquals("Can not use Robot1.Claw on this target anymore", e.getMessage());
        }

    }
    @Test
    public void test10ClawCanOnlyBeUsedOnceOnTankRover() {
        TankRover tankRover = new TankRover();
        Claw claw = new Claw();
        TankRover target = new TankRover();
        tankRover.attack(target, claw);
        Assert.assertEquals(0, target.clawAttacksLeft);
        try {
            tankRover.attack(target, claw);
        } catch (IllegalArgumentException e) {
            assertEquals("Can not use Robot1.Claw on this target anymore", e.getMessage());
        }

    }
    @Test
    public void test11WeightCanNotBeNegative(){
        Aluminum3000 aluminum3000 = new Aluminum3000();
        Blaster blaster = new Blaster();
        Aluminum3000 target = new Aluminum3000();
        aluminum3000.attack(target, blaster);
        aluminum3000.attack(target, blaster);
        try {
            aluminum3000.attack(target, blaster);
        } catch (IllegalArgumentException e) {
            assertEquals("Robot1.Weapon is too heavy", e.getMessage());
        }
    }
    @Test
    public void test12SpeedCanNotBeNegative(){
        TankRover tankRover = new TankRover();
        Blaster blaster = new Blaster();
        Aluminum3000 target = new Aluminum3000();
        tankRover.attack(target, blaster);
        tankRover.attack(target, blaster);
        tankRover.attack(target, blaster);
        tankRover.attack(target, blaster);
        try {
            tankRover.attack(target, blaster);
        } catch (IllegalArgumentException e) {
            assertEquals("Robot1.Weapon is too heavy", e.getMessage());
        }
    }

}


