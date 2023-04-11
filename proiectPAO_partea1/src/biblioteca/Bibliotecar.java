package biblioteca;

import static constants.Constants.LUCREAZA;
import static constants.Constants.NU_LUCREAZA;

public class Bibliotecar {
    private final int idBibliotecar;
    private final String nume;
    private final String telefon;
    static final String[] zileDeMunca = {"luni", "marti", "joi", "vineri"}; // vector cu zilele in care lucreaza bibliotecarul

    public Bibliotecar(int idBibliotecar, String nume, String telefon) {
        this.idBibliotecar = idBibliotecar;
        this.nume = nume;
        this.telefon = telefon;
    }

    public String lucreazaInAceastaZi(String zi) {
        for(String i : zileDeMunca) {
            if(i.equals(zi))
                return LUCREAZA;
        }
        return NU_LUCREAZA;
    }
}
