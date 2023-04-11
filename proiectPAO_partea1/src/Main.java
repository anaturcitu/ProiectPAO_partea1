import biblioteca.*;
import exceptii.OptiuneGresitaExceptie;
import biblioteca.ExemplarCarte;

import java.util.Scanner;

public class Main {
    static int optiune;
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.citireCarti();
        biblioteca.citireUtilizatori();
        System.out.println("Alegeti o optiune dintre urmatoarele:");
        System.out.println("1. Afisarea cartilor existente in biblioteca.");
        System.out.println("2. Afisarea tuturor utilizatorilor.");
        System.out.println("3. Adaugarea unei noi carti in biblioteca.");
        System.out.println("4. Imprumutarea unei carti de catre un utilizator."); // cand se imprumuta o carte, starea din tuplul(id, stare) devine indisponibil si in istoricul utilizatorului se adauga id-ul cartii
        System.out.println("5. Creaza si afiseaza fisa cartii citita de la tastatura.");
        System.out.println("6. Creaza si afiseaza fisa utilizatorului citit de la tastatura.");
        System.out.println("7. Verifica daca un bibliotecar citit de la tastatura este liber intr-o anumita zi."); // se presupune ca id-ul introdus e corect
//      System.out.println("8. Afisarea istoricului cartilor imprumutate ale unui utilizator.");
        System.out.println("9. Iesirea din aplicatie. ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Alege optiune: ");
        optiune = scanner.nextInt();
        boolean continua = true;
        while (continua) {
            try {
                switch (optiune) {
                    case 1:
                        biblioteca.afisareCarti();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 2:
                        biblioteca.afisareUtilizatori();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 3:
                        biblioteca.citireAdaugareCarteNoua();
                        biblioteca.afisareCarti();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 4:
                        biblioteca.imprumutareCarte();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 5:
                        utile.CitireCarte carte = new utile.CitireCarte();
                        ExemplarCarte exemplarCarte1 = carte.citesteCartea();
                        System.out.print("Numarul cartii: ");
                        int numarCarte = scanner.nextInt();
                        FisaBibliotecaCarte fisaBibliotecaCarte = new FisaBibliotecaCarte(exemplarCarte1, numarCarte);
                        fisaBibliotecaCarte.afiseazaFisa();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 6:
                        utile.CitireUtilizator utilizator = new utile.CitireUtilizator();
                        UtilizatorBiblioteca utilizatorBiblioteca1 = utilizator.citesteUtilizatorul();
                        System.out.print("Numarul utilizatorului: ");
                        int numarUtilizator = scanner.nextInt();
                        System.out.print("Telefonul utilizatorului: ");
                        String telefonUtilizator = scanner.next();
                        FisaImprumutUtilizator fisaImprumutUtilizator = new FisaImprumutUtilizator(utilizatorBiblioteca1, telefonUtilizator, numarUtilizator);
                        fisaImprumutUtilizator.afiseazaFisa();
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
                    case 7:
                        utile.CitireBibliotecar citireBibliotecar = new utile.CitireBibliotecar();
                        System.out.print("Ziua saptamanii de verificat: ");
                        Scanner scanner1 = new Scanner(System.in);
                        String zi = scanner1.nextLine();
                        int id = citireBibliotecar.citesteId();
                        String nume = citireBibliotecar.citesteNume();
                        String telefon = citireBibliotecar.citesteTelefon();
                        Bibliotecar bibliotecar = new Bibliotecar(id, nume, telefon);
                        System.out.println(bibliotecar.lucreazaInAceastaZi(zi));
                        System.out.print("Alege alta optiune: ");
                        optiune = scanner.nextInt();
                        break;
//                    case 8:
//                        // citeste un utilizator si afiseaza istoricul cartilor imprumutate de el:
//                        System.out.print("Id-ul utilizatorului caruia vreau sa ii stiu istoricul: ");
//                        int idUtilizator = scanner.nextInt();
//                        UtilizatorBiblioteca utilizatorBiblioteca = new UtilizatorBiblioteca(idUtilizator);
//                        utilizatorBiblioteca.afisareIstoricCartiUtilizator(idUtilizator);
//                        System.out.print("Alege alta optiune: ");
//                        optiune = scanner.nextInt();
//                        break;
                    case 9:
                        continua = false;
                        break;
                    default:
                        throw new OptiuneGresitaExceptie("Optiunea aleasa este gresita.");
                }
            } catch (OptiuneGresitaExceptie exceptie) {
                System.out.println(exceptie.getMessage());
                break;
            }
        }
    }
}
