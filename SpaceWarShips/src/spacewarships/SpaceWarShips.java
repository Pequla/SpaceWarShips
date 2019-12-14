package spacewarships;

import java.util.Scanner;

/**
 *
 * @author Petar Kresoja
 */
public class SpaceWarShips {

    // DEKLARISANJE PROMENJLIVIH
    private static final int BROJ_REDOVA = 10;
    private static final int BROJ_KOLONA = 10;
    private static final String[][] MREZA = new String[BROJ_REDOVA][BROJ_KOLONA];

    public static void main(String[] args) {
        // KONZOLNO SE VRSE OPERACIJE
        // IGIRCA "PO PRINCIPU" POTAPANJA PODMORNICA
        // GITHUB: https://github.com/Pequla/SpaceWarShips
        System.out.println("Dobrodosli u SpaceWarShips !");
        System.out.println();
        System.out.println("-=) INFORMACIJE I PRAVIlA (=-");
        System.out.println("Vasi postavljeni brodovi su obelezeni sa I");
        System.out.println("Kompjuterovi postavljeni brodovi su obelezeni sa K");
        System.out.println("Pogodjeni brodovi su obelezeni sa P");
        System.out.println("Cim Command Ship biva pogodjen gubite igru");
        System.out.println("Vasi promasaji su obelezeni sa -");
        System.out.println("X kordinate su ispisane vertikalno");
        System.out.println("Y kordinate su ispisane horizontalno");
        System.out.println();

        // PRIKAZUJE PRAZNU MAPU
        System.out.println("Trenutno nema postavljenih brodova:\r\n");
        napraviMapu();

        // POSTAVLJA BRODOVE KORISNIK
        postaviBrodoveKosrisnika();

        // POSTAVLJA BRODOVE KOMPJUTER
        postaviBrodoveKompjutera();

        // GAME LOOP
        while (CommandShip.fleetSizeI() != 0 && CommandShip.fleetSizeK() != 0) {
            tokIgre();
        }

        // KRAJ
        krajIgre();

    }

    // NAPRAVI MAPU
    public static void napraviMapu() {
        // POBOLJSANJA:
        // KORISTI PRINTF
        // VRH
        System.out.print("  ");
        for (int i = 0; i < BROJ_KOLONA; i++) {
            System.out.print(i);
        }
        System.out.println();

        // SREDINA
        for (int i = 0; i < MREZA.length; i++) {
            for (int j = 0; j < MREZA[i].length; j++) {
                MREZA[i][j] = " ";
                if (j == 0) {
                    System.out.print(i + "|" + MREZA[i][j]);
                } else if (j == MREZA[i].length - 1) {
                    System.out.print(MREZA[i][j] + "|" + i);
                } else {
                    System.out.print(MREZA[i][j]);
                }
            }
            System.out.println();
        }

        // DNO (ISTO KO VRH)
        System.out.print("  ");
        for (int i = 0; i < BROJ_KOLONA; i++) {
            System.out.print(i);
        }
        System.out.println("\r\n");
    }

    // POSTAVLJA BRODOVE KORISNIKA
    public static void postaviBrodoveKosrisnika() {

        // INIT
        System.out.println("Vasi brodovi se postavljaju !\r\n");
        int x, y;

        // POSTAVLJA COMMAND SHIP
        while (true) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (postaviBrod(x, y, "I")) {
                Ship ship = new CommandShip(x, y);
                CommandShip.addToFleetI(ship);
                System.out.println(ship);
                break;
            }
        }

        // POSTAVLJA 2 BIG SHIP-A
        for (int i = 0; i < 2; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "I")) {
                    Ship ship = new BigShip(x, y);
                    CommandShip.addToFleetI(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }

        // POSTAVLJA 4 SMALL SHIP-A
        for (int i = 0; i < 4; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "I")) {
                    Ship ship = new SmallShip(x, y);
                    CommandShip.addToFleetI(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }

        // POSTAVLJA BIG CARGO SHIP
        while (true) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (postaviBrod(x, y, "I")) {
                Ship ship = new BigCargo(x, y);
                CommandShip.addToFleetI(ship);
                System.out.println(ship);
                break;
            }
        }

        // POSTAVLJA 2 SMALL CARGO SHIP
        for (int i = 0; i < 2; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "I")) {
                    Ship ship = new SmallCargo(x, y);
                    CommandShip.addToFleetI(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }
        stampajMapu();
        System.out.println();
    }

    public static void postaviBrodoveKompjutera() {

        // INIT
        System.out.println("Kompjuter postavlja brodove !\r\n");
        int x, y;

        // POSTAVLJA COMMAND SHIP
        while (true) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (postaviBrod(x, y, "K")) {
                Ship ship = new CommandShip(x, y);
                CommandShip.addToFleetK(ship);
                System.out.println(ship);
                break;
            }
        }

        // POSTAVLJA 2 BIG SHIP-A
        for (int i = 0; i < 2; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "K")) {
                    Ship ship = new BigShip(x, y);
                    CommandShip.addToFleetK(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }

        // POSTAVLJA 4 SMALL SHIP-A
        for (int i = 0; i < 4; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "K")) {
                    Ship ship = new SmallShip(x, y);
                    CommandShip.addToFleetK(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }

        // POSTAVLJA BIG CARGO SHIP
        while (true) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (postaviBrod(x, y, "K")) {
                Ship ship = new BigCargo(x, y);
                CommandShip.addToFleetK(ship);
                System.out.println(ship);
                break;
            }
        }

        // POSTAVLJA 2 SMALL CARGO SHIP
        for (int i = 0; i < 2; i++) {
            while (true) {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
                if (postaviBrod(x, y, "K")) {
                    Ship ship = new SmallCargo(x, y);
                    CommandShip.addToFleetK(ship);
                    System.out.println(ship);
                    break;
                }
            }
        }
        stampajMapu();
        System.out.println();
    }

    // DA LI SME I AKO SME POSTAVLJA BROD
    public static boolean postaviBrod(int x, int y, String vrsta) {

        if ((x >= 0 && x < BROJ_REDOVA) && (y >= 0 && y < BROJ_KOLONA) && (" ".equals(MREZA[x][y]))) {
            MREZA[x][y] = vrsta;
            return true;
        }
        return false;
    }

    // TOK BORBE
    public static void tokIgre() {
        // KORISNIK
        potezKorisnika();
        stampajMapu();

        // KOMPJUTER
        potezKompjutera();
        stampajMapu();

        // SITUACIJA NAKON POTEZA
        System.out.println("\r\nVasi brdodovi: " + CommandShip.fleetSizeI());
        CommandShip.listFleetI();
        System.out.println("\r\nBrodovi kompjutera: " + CommandShip.fleetSizeK());
        CommandShip.listFleetK();
        System.out.println();

        // STAMPAJ MAPU
        stampajMapu();
    }

    public static void potezKorisnika() {
        System.out.println("\r\nSada ste vi na potezu !");
        int x, y;
        do {
            Scanner scn = new Scanner(System.in);
            System.out.print("Unesite X kordinatu: ");
            x = scn.nextInt();
            System.out.print("Unesite Y kordinatu: ");
            y = scn.nextInt();

            // POGODAK
            if ((x < 0 || x >= BROJ_REDOVA) || (y < 0 || y >= BROJ_KOLONA)) {
                if ((x < 0 || x >= BROJ_REDOVA) || (y < 0 || y >= BROJ_KOLONA)) {
                    System.out.println("Ne moze te da postavite broj tu");
                }
            } else {
                if (null != MREZA[x][y]) {
                    switch (MREZA[x][y]) {
                        // AKO JE KOMPJUTEROV BROD POGODJEN
                        case "K":
                            System.out.println("Pogodili ste brod, cetitamo!");
                            // OBELEZAVA POGODAK SA P
                            MREZA[x][y] = "P";
                            // UKLANJA BROD KOMPJUTERA
                            CommandShip.removeFromFleetK(x, y);
                            // AKO POGODI SVOJ BROD
                            break;
                        // POGRESAN POGODAK
                        case "I":
                            System.out.println("Pogodili ste svoj brod");
                            MREZA[x][y] = "P";
                            // UKLANJA BROD KORISNIKA
                            CommandShip.removeFromFleetI(x, y);
                            break;
                        // PROMASAJ
                        case " ":
                            System.out.println("Promasili ste !");
                            MREZA[x][y] = "-";
                            break;
                        default:
                            break;
                    }
                }
            }
            // PONAVLJAJ DOK NE BUDE ISPRAVNO
        } while ((x < 0 || x >= BROJ_REDOVA) || (y < 0 || y >= BROJ_KOLONA));
    }

    public static void potezKompjutera() {
        System.out.println("\r\nSada kompjuter igra...");

        // DEKLARISE KORDINATE
        int x, y;
        // NAGADJA KORDINATE
        do {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);

            // ISPRAVNO
            if ((x >= 0 && x < BROJ_REDOVA) && (y >= 0 && y < BROJ_KOLONA)) {
                if (null != MREZA[x][y]) {
                    switch (MREZA[x][y]) {
                        // POGODIO KORISNIKOV BROD
                        case "I":
                            System.out.println("Kompjuter vam je pogodio brod");
                            MREZA[x][y] = "P";
                            CommandShip.removeFromFleetI(x, y);
                            // AKO POGODI SVOJ
                            break;
                        case "K":
                            System.out.println("Kompjuter je pogodio sopstveni brod");
                            MREZA[x][y] = "P";
                            CommandShip.removeFromFleetK(x, y);
                            // PROMASI
                            break;
                        case " ":
                            System.out.println("Kompjuter je pormasio");
                            break;
                        default:
                            break;
                    }
                }
            }
            // RADI DOK NE BUDE VALIDNO
        } while ((x < 0 || x >= BROJ_REDOVA) || (y < 0 || y >= BROJ_KOLONA));
    }

    public static void krajIgre() {
        System.out.println("Vasi brodovi: " + CommandShip.fleetSizeI());
        System.out.println("Kompjuterovi brodovi: " + CommandShip.fleetSizeK());
        if (CommandShip.fleetSizeI() > 0 && CommandShip.fleetSizeK() <= 0) {
            System.out.println("Pobedili ste !!!");
        } else {
            System.out.println("Na zalost, izgubli ste...");
        }
    }

    public static void stampajMapu() {
        System.out.println();
        // VRH
        System.out.print("  ");
        for (int i = 0; i < BROJ_KOLONA; i++) {
            System.out.print(i);
        }
        System.out.println();

        // SREDINA
        for (int x = 0; x < MREZA.length; x++) {
            System.out.print(x + "|");

            for (String item : MREZA[x]) {
                System.out.print(item);
            }

            System.out.println("|" + x);
        }

        // DNO
        System.out.print("  ");
        for (int i = 0; i < BROJ_KOLONA; i++) {
            System.out.print(i);
        }
        System.out.println();
    }
}