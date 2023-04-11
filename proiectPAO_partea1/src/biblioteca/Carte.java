package biblioteca;

import utile.Tuple;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Carte {
    private String titlu;
    private String autor;
    private String editura;
    private String genLiterar;
    private int numarPagini;
    private int anAparitie;
    private Map<String, ArrayList<Tuple>> dictionarIduriExemplare = new HashMap<>();

    public Carte() { }
    public Carte(String titlu, String autor, String editura, String genLiterar, int numarPagini, int anAparitie, Map<String, ArrayList<Tuple>> dictionarIduriExemplare) {
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.genLiterar = genLiterar;
        this.numarPagini = numarPagini;
        this.anAparitie = anAparitie;
        this.dictionarIduriExemplare = dictionarIduriExemplare;
    }

    public Carte(String titlu, String autor, String editura, String genLiterar, int numarPagini, int anAparitie) {
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.genLiterar = genLiterar;
        this.numarPagini = numarPagini;
        this.anAparitie = anAparitie;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditura() {
        return editura;
    }

    public String getGenLiterar() {
        return genLiterar;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public Map<String, ArrayList<Tuple>> getDictionarIduriExemplare() {
        return dictionarIduriExemplare;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

}
