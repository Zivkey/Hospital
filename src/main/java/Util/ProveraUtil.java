package Util;

public class ProveraUtil {
    /**
     * Ova metoda uzima string i proverava da li je on duzi od 3 karaktera i da li su svi slova
     * @param s string koji proveravamo
     * @return da li je string tacan ili ne
     */
    public static boolean proveraRec(String s) {
        char [] slova = s.toCharArray();
        if (slova.length < 3) {
            return false;
        }
        for (char x : slova) {
            if (!Character.isLetter(x)) {
                return false;
            }
        }
        return true;
    }
}
