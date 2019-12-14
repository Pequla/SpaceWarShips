package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class SmallShip extends BattleShip {

    // KONSTRUKTOR
    public SmallShip(int xAxis, int yAxis) {

        // DAMAGE 50, HEALTH 300, SPEED 1
        super(50, 300, 1, xAxis, yAxis);
    }

    // TO STRING
    @Override
    public String toString() {
        return "SmallShip [ " + super.toString() + " ]";
    }
}
