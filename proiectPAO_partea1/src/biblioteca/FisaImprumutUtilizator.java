package biblioteca;

import exceptii.IdInvalidExceptie;

public class FisaImprumutUtilizator implements service.Validare {
    // cand este creata fisa unui utilizator, istoricul cartilor imprumutate este null
    UtilizatorBiblioteca fisa;
    String telefon;
    int numarUtilizator; // numarul utilizatorului cu care a fost inregistrat in biblioteca care apare pe fisa sa

    public FisaImprumutUtilizator(UtilizatorBiblioteca fisa, String telefon, int numarUtilizator) {
        this.fisa = fisa;
        this.telefon = telefon;
        this.numarUtilizator = numarUtilizator;
    }

    public void afiseazaFisa() {
        try {
            if (validare(numarUtilizator)) {
                System.out.println(fisa.getIdUtilizator());
                System.out.println(fisa.getNume());
                System.out.println(telefon);
                System.out.println(numarUtilizator);
            }
            else throw new IdInvalidExceptie("Numarul utilizatorului este invalid.");
        } catch (IdInvalidExceptie exceptie) {
            System.out.println(exceptie.getMessage());
        }
    }

    @Override
    public boolean validare(int numar) {
        if(numar >= 1000 && numar <= 9999)
            return true;
        return false;
    }
}
