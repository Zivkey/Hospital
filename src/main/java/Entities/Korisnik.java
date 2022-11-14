package Entities;

public class Korisnik {
    private int id;
    private String ime;
    private String prezime;
    private String sifra;
    private String email;

    public Korisnik() {
    }

    public Korisnik(int id, String ime, String prezime, String sifra, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.email = email;
    }

    public Korisnik(String ime, String prezime, String sifra, String email) {
        this.ime = ime;
        this.prezime = prezime;
        this.sifra = sifra;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", sifra='" + sifra + '\'' +
                '}';
    }
}
