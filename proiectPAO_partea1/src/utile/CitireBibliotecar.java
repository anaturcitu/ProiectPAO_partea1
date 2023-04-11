package utile;

import java.util.Scanner;

public class CitireBibliotecar {

    public CitireBibliotecar() {
    }

    public int citesteId() {
        Scanner scanner = new Scanner(System.in);
        int idBibliotecar;
        System.out.print("Id bibliotecar: ");
        idBibliotecar = scanner.nextInt();
        return idBibliotecar;
    }
    public String citesteNume() {
        Scanner scanner = new Scanner(System.in);
        String nume;
        System.out.print("Nume bibliotecar: ");
        nume = scanner.nextLine();
        return nume;
    }
    public String citesteTelefon() {
        Scanner scanner = new Scanner(System.in);
        String telefon;
        System.out.print("Telefon bibliotecar: ");
        telefon = scanner.nextLine();
        return telefon;
    }
}
