package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class CargoShip extends Ship {

    // DEKLARISANJE
    private int capacity;

    // KONSTRUKTOR
    public CargoShip(int capacity, int health, int speed, int xAxis, int yAxis) {
        super(health, speed, xAxis, yAxis);
        this.capacity = capacity;
    }
    
    // TO STRING
    @Override
    public String toString() {
        return super.toString() + ", CAPACITY: " + this.capacity;
    }
}
