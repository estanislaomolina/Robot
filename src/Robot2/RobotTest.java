package Robot2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.function.Executable;




public class RobotTest {
    private Robot robot;
    private Claw claw;
    private Blaster blaster;
    private TankRover tankRover;
    private TankRover targetTankRover;
    private Aluminum3000 aluminum3000;
    private Aluminum3000 targetAluminum3000;
    private static final String clawError = "Can not use Claw on this target anymore";
    private static final String weaponError = "Weapon is too heavy";

    @Before
    public void setUp() {
        tankRover = new TankRover();
        claw = new Claw();
        blaster = new Blaster();
        aluminum3000 = new Aluminum3000();
        targetTankRover = new TankRover();
        targetAluminum3000 = new Aluminum3000();

    }

    @Test
    public void test01TankRoverAttackTankRoverWithClaw() {
        tankRover.attack(targetTankRover, claw);
        assertEquals(190, tankRover.maxWeaponWeight);
        assertEquals(35, tankRover.speed);
        assertEquals(0, targetTankRover.clawAttacksLeft);
        assertEquals(95, targetTankRover.health);
    }
    @Test
    public void test02TankRoverAttackTankRoverWithBlaster() {
        tankRover.attack(targetTankRover, blaster);
        assertEquals(180, tankRover.maxWeaponWeight);
        assertEquals(30, tankRover.speed);
        assertEquals(50, targetTankRover.health);
    }
    @Test
    public void test03TankRoverAttackAluminum3000WithClaw() {
        tankRover.attack(targetAluminum3000, claw);
        assertEquals(190, tankRover.maxWeaponWeight);
        assertEquals(35, tankRover.speed);
        assertEquals(1, targetAluminum3000.clawAttacksLeft);
        assertEquals(75, targetAluminum3000.health);
    }
    @Test
    public void test04TankRoverAttackAluminum3000WithBlaster() {
        tankRover.attack(targetAluminum3000, blaster);
        assertEquals(180, tankRover.maxWeaponWeight);
        assertEquals(30, tankRover.speed);
        assertEquals(95, targetAluminum3000.health);
    }
    @Test
    public void test05Aluminum3000AttackAluminum3000WithClaw() {
        aluminum3000.attack(targetAluminum3000, claw);
        assertEquals(40, aluminum3000.maxWeaponWeight);
        assertEquals(85, aluminum3000.speed);
        assertEquals(1, targetAluminum3000.clawAttacksLeft);
        assertEquals(75, targetAluminum3000.health);
    }
    @Test
    public void test06Aluminum3000AttackAluminum3000WithBlaster() {
        aluminum3000.attack(targetAluminum3000, blaster);
        assertEquals(30, aluminum3000.maxWeaponWeight);
        assertEquals(80, aluminum3000.speed);
        assertEquals(95, targetAluminum3000.health);
    }
    @Test
    public void test07Aluminum3000AttackTankRoverWithClaw() {
        aluminum3000.attack(targetTankRover, claw);
        assertEquals(40, aluminum3000.maxWeaponWeight);
        assertEquals(85, aluminum3000.speed);
        assertEquals(0, targetTankRover.clawAttacksLeft);
        assertEquals(95, targetTankRover.health);
    }
    @Test
    public void test08Aluminum3000AttackTankRoverWithBlaster() {
        aluminum3000.attack(targetTankRover, blaster);
        assertEquals(30, aluminum3000.maxWeaponWeight);
        assertEquals(80, aluminum3000.speed);
        assertEquals(50, targetTankRover.health);
    }
    @Test
    public void test09ClawCanOnlyBeUsedTwiceOnAluminum3000() {
        aluminum3000.attack(targetAluminum3000, claw);
        assertEquals(1, targetAluminum3000.clawAttacksLeft);
        aluminum3000.attack(targetAluminum3000, claw);
        assertEquals(0, targetAluminum3000.clawAttacksLeft);
        assertThrowsLike(() -> aluminum3000.attack(targetAluminum3000, claw), clawError);


    }
    @Test
    public void test10ClawCanOnlyBeUsedOnceOnTankRover() {
        tankRover.attack(targetTankRover, claw);
        assertEquals(0, targetTankRover.clawAttacksLeft);
        assertThrowsLike(() -> tankRover.attack(targetTankRover, claw), clawError);


    }
    @Test
    public void test11WeightCanNotBeNegative(){
        aluminum3000.attack(targetAluminum3000, blaster); //aluminum3000 maxWeaponWeight = 30
        aluminum3000.attack(targetAluminum3000, blaster); //aluminum3000 maxWeaponWeight = 10
        assertThrowsLike(() -> aluminum3000.attack(targetAluminum3000, blaster), weaponError);
    }
    @Test
    public void test12SpeedCanNotBeNegative(){
        tankRover.attack(targetAluminum3000, blaster); //tankRover speed = 30
        tankRover.attack(targetAluminum3000, blaster); //tankRover speed = 20
        tankRover.attack(targetAluminum3000, blaster); //tankRover speed = 10
        tankRover.attack(targetAluminum3000, blaster); //tankRover speed = 0
        assertThrowsLike(() -> tankRover.attack(targetAluminum3000, blaster), weaponError);

    }
    private void assertThrowsLike(Executable executable, String expectedMessage){
        assertEquals (expectedMessage, assertThrows(IllegalArgumentException.class, executable).getMessage());
    }
}



