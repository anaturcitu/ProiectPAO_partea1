package utile;

import biblioteca.UtilizatorBiblioteca;
import java.util.Scanner;

public class CitireUtilizator {

    public UtilizatorBiblioteca citesteUtilizatorul() {
        int idUtilizator;
        String nume;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nume: ");
        nume = scanner.nextLine();
        System.out.print("Id utilizator: ");
        idUtilizator = scanner.nextInt();


        UtilizatorBiblioteca utilizator = new UtilizatorBiblioteca(idUtilizator, nume);
        return utilizator;
    }
}
