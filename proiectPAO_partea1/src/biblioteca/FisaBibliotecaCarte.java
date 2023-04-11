package biblioteca;

import exceptii.IdInvalidExceptie;
import service.Validare;

public class FisaBibliotecaCarte implements Validare {
    ExemplarCarte fisa;
    private int numarCarte; // numarul cartii in biblioteca

    public FisaBibliotecaCarte(ExemplarCarte fisa, int numarCarte) {
        this.fisa = fisa;
        this.numarCarte = numarCarte;
    }

    public void afiseazaFisa() {
        try {
            if (validare(numarCarte)) {
                System.out.println(fisa.getTitlu());
                System.out.println(fisa.getAutor());
                System.out.println(fisa.getEditura());
                System.out.println(fisa.getGenLiterar());
                System.out.println(fisa.getNumarPagini());
                System.out.println(fisa.getAnAparitie());
                System.out.println(fisa.getIdCarte());
                System.out.println(numarCarte);
            }
            else throw new IdInvalidExceptie("Numarul cartii este invalid.");
        } catch (IdInvalidExceptie exceptie) {
            System.out.println(exceptie.getMessage());
        }
    }
    @Override
    public boolean validare(int numar) {
        if(numar >= 10000 && numar <= 99999)
            return true;
        return false;
    }
}
