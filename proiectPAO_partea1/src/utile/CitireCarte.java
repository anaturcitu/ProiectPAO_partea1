package utile;

import biblioteca.ExemplarCarte;

import java.util.Scanner;

public class CitireCarte {
    public ExemplarCarte citesteCartea() {
        String titlu;
        String autor;
        String editura;
        String genLiterar;
        int numarPagini;
        int anAparitie;
        int idCarte;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Titlu: ");
        titlu = scanner.nextLine();
        System.out.print("Autor: ");
        autor = scanner.nextLine();
        System.out.print("Editura: ");
        editura = scanner.nextLine();
        System.out.print("Gen literar: ");
        genLiterar = scanner.nextLine();
        System.out.print("Numar pagini: ");
        numarPagini = scanner.nextInt();
        System.out.print("An aparitie: ");
        anAparitie = scanner.nextInt();
        System.out.print("Id carte: ");
        idCarte = scanner.nextInt();
        ExemplarCarte exemplar = new ExemplarCarte(titlu, autor, editura, genLiterar, numarPagini, anAparitie, idCarte);
        return exemplar;
    }
}















