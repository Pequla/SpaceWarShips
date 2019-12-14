package spacewarships;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author Petar Kresoja
 */
public class CommandShip extends BattleShip {

    // DEKLARISANJE
    private final int shield;
    private static ArrayList<Ship> korisnik = new ArrayList<Ship>();
    private static ArrayList<Ship> kompjuter = new ArrayList<Ship>();

    // KONSTRUKTOR
    public CommandShip(int xAxis, int yAxis) {

        // DAMAGE 150, HEALTH 1000, SPEED 3
        super(150, 1000, 3, xAxis, yAxis);
        this.shield = 20;
    }

    // TO STRING
    @Override
    public String toString() {
        return "CommandShip [ " + super.toString() + ", SHIELD: " + this.shield + " ]";
    }

    // DODAJE BROD FLOTI KORISNIKA
    public static void addToFleetI(Ship s) {
        korisnik.add(s);
        System.out.println("Brod je dodat u flotu korisnika");
    }

    // SKLANJA BROD IZ FLOTE KORISNIKA
    public static void removeFromFleetI(int x, int y) {
        try {
            for (Ship s : korisnik) {
                if (s.getxAxis() == x && s.getyAxis() == y) {
                    if (s.getClass() == CommandShip.class) {
                        System.out.println("\r\nPogodjen vam je Command Ship");
                        System.out.println("Na zalost izgubli ste igru !!!");
                        System.exit(0);
                    } else {
                        korisnik.remove(s);
                        System.out.println("Brod je uklonjen iz flote korisnika");
                    }
                }
            }
        } catch (ConcurrentModificationException ex) {
            //System.err.println("ConcurrentModificationException");
        }
    }

    // DODAJE BROD FLOTI KOMPJUTERA
    public static void addToFleetK(Ship s) {
        kompjuter.add(s);
        System.out.println("Brod je dodat u flotu kompjutera");
    }

    // SKLANJA BROD IZ FLOTE KOMPJUTERA
    public static void removeFromFleetK(int x, int y) {
        try {
            for (Ship s : kompjuter) {
                if (s.getxAxis() == x && s.getyAxis() == y) {
                    if (s.getClass() == CommandShip.class) {
                        System.out.println("\r\nPogodjen je Command Ship kompjutera");
                        System.out.println("Cestitamo, pobedili ste !!!");
                        System.exit(0);
                    } else {
                        kompjuter.remove(s);
                        System.out.println("Brod je uklonjen iz flote kompjutera");
                    }
                }
            }
        } catch (ConcurrentModificationException ex) {
            //System.err.println("ConcurrentModificationException");
        }
    }

    // ISPISUJE SVE BRODOVE IZ FLOTE KORSINIKA
    public static void listFleetI() {
        System.out.println();
        // METOD JE BRZI OD MANUELNOG ISPISA
        korisnik.forEach((n) -> System.out.println(n));
        System.out.println();
    }

    // ISPISUJE SVE BRODOVE IZ FLOTE KOMPJUTERA
    public static void listFleetK() {
        System.out.println();
        // METOD JE BRZI OD MANUELNOG ISPISA
        kompjuter.forEach((n) -> System.out.println(n));
        System.out.println();
    }

    // VRACA BROJ BRODOVA
    public static int fleetSizeI() {
        return korisnik.size();
    }

    public static int fleetSizeK() {
        return kompjuter.size();
    }
}
