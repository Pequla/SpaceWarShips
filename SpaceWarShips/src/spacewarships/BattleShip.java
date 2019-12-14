package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class BattleShip extends Ship {

    // DEKLARISANJE
    private int damage;

    // KONSTRUKTOR
    public BattleShip(int damage, int health, int speed, int xAxis, int yAxis) {
        super(health, speed, xAxis, yAxis);
        this.damage = damage;
    }

    // DAMAGE
    public int canDamage() {
        return damage;
    }

    // TO STRING
    @Override
    public String toString() {
        return super.toString() + ", DAMAGE: " + this.damage;
    }

    // NAPAD
    public void attack(Ship ship) {
        ship.getDamage(damage);
    }
}
