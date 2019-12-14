package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class SmallCargo extends CargoShip {

    // KONSTRUKTOR
    public SmallCargo(int xAxis, int yAxis) {

        // CAPACITY 1000, HEALTH 100, SPEED
        super(1000, 100, 1, xAxis, yAxis);
    }

    // TO STRING
    @Override
    public String toString() {
        return "SmallCargo [ " + super.toString() + " ]";
    }

}
