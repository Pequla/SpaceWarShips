package spacewarships;

/**
 *
 * @author Petar Kresoja
 */
public class Ship {

    // DEKLARISANJE
    private int health;
    private final int speed;
    private final int xAxis;
    private final int yAxis;

    // KONSTRUKTOR
    public Ship(int health, int speed, int xAxis, int yAxis) {
        this.health = health;
        this.speed = speed;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    // GETTER ZA (X,Y)
    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }
  
    // METODA DODELE DAMAGE-A
    public void getDamage(int damage) {
        this.health -= damage;

        if (this.health < 1) {
            System.out.println("Brod je unisten");
        }
    }

    @Override
    public String toString() {
        return "HEALTH: " + health + ", SPEED: " + speed + ", X-CORD: " + xAxis + ", Y-CORD: " + yAxis;
    }
    
}
