package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class BigCargo extends CargoShip {
    
    // DEKLARISANJE
    private final int shield;

    // KONSTRUKTOR
    public BigCargo(int xAxis, int yAxis) {
        
        // CAPACITY, HEALTH, SPEED, SHIELD
        super(5000, 200, 2, xAxis, yAxis);
        this.shield = 10;
    }
    
    // TO STRING
    @Override
    public String toString() {
        return "BigCargo [ " + super.toString() + ", SHIELD: " + this.shield + " ]";
    }
    
    
}
