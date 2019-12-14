package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class BigShip extends BattleShip {

    // KONSTRUKTOR
    public BigShip(int xAxis, int yAxis) {
        
        // DAMAGE 100, HEALTH 500, SPEED 2
        super(100, 500, 2, xAxis, yAxis);
    }
    
    // TO STRING
    @Override
    public String toString() {
        return "BigShip [ " + super.toString() + " ]";
    }
    

}
