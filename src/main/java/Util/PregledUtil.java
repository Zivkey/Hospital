package Util;

import Database.PregledController;
import Entities.Korisnik;
import Entities.Pregled;

import java.util.ArrayList;
import java.util.List;

public class PregledUtil {
    public static List<Pregled> listaPregleda(Korisnik k) {
        List<Pregled> pregledi = PregledController.citajPreglede();
        List<Pregled> noviPregledi = new ArrayList<>();
        for (Pregled x : pregledi) {
            if (x.getPacijent().getId() == k.getId()) {
                noviPregledi.add(x);
            }
        }
        return noviPregledi;
    }
}
