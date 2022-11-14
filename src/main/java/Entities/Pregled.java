package Entities;

public class Pregled {
    private int id;
    private Doktor doktor;
    private Korisnik pacijent;
    private String opis;
    private boolean odobren;

    public Pregled() {
    }

    public Pregled(Doktor doktor, Korisnik pacijent, String opis, boolean odobren) {
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.opis = opis;
        this.odobren = odobren;
    }

    public Pregled(int id, Doktor doktor, Korisnik pacijent, String opis, boolean odobren) {
        this.id = id;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.opis = opis;
        this.odobren = odobren;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Korisnik getPacijent() {
        return pacijent;
    }

    public void setPacijent(Korisnik pacijent) {
        this.pacijent = pacijent;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isOdobren() {
        return odobren;
    }

    public void setOdobren(boolean odobren) {
        this.odobren = odobren;
    }

    @Override
    public String toString() {
        return "Pregled{" +
                "id=" + id +
                ", doktor=" + doktor +
                ", pacijent=" + pacijent +
                ", opis='" + opis + '\'' +
                ", odobren=" + odobren +
                '}';
    }
}

