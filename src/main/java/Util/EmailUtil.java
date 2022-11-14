package Util;

import Database.DoktorController;
import Database.KorisnikController;
import Entities.Doktor;
import Entities.Korisnik;

import java.util.ArrayList;
import java.util.List;

public class EmailUtil {
    public static boolean proveriMail(String mail) {
        List<String> mailovi = new ArrayList<>();
        List<Korisnik> koricnici = KorisnikController.citajKorisnike();
        for (Korisnik x : koricnici) {
            mailovi.add(x.getEmail());
        }
        List<Doktor> doktori = DoktorController.citajDoktore();
        for (Doktor x : doktori) {
            mailovi.add(x.getEmail());
        }
        for (String x : mailovi) {
            if (x.equals(mail)) {
                return false;
            }
        }
        return true;
    }
}
