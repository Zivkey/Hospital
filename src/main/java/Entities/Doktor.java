package Entities;

import Enums.Struka;

public class Doktor {
    private int id;
    private String ime;
    private String prezime;
    private String email;
    private Struka struka;
    private String sifra;

    public Doktor() {
    }

    public Doktor(int id, String ime, String prezime, String email, Struka struka, String sifra) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.struka = struka;
        this.sifra = sifra;
    }

    public Doktor(String ime, String prezime, String email, Struka struka, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.struka = struka;
        this.sifra = sifra;
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

    public Struka getStruka() {
        return struka;
    }

    public void setStruka(Struka struka) {
        this.struka = struka;
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
        return "Dr." + ime + " " + prezime + " po stuci: " + struka;
    }
}
