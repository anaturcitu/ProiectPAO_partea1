package biblioteca;

import exceptii.IdInexistentExceptie;
import exceptii.IdInvalidExceptie;
import exceptii.TitluInexistentExceptie;
import service.BibliotecaService;
import utile.Tuple;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Biblioteca implements BibliotecaService {
    private int nrTotalCarti = 0;
    private ExemplarCarte[] toateCartile = new ExemplarCarte[100001];
    private final UtilizatorBiblioteca[] totiUtilizatorii = new UtilizatorBiblioteca[10001];

    public Biblioteca() { }

    public UtilizatorBiblioteca[] getTotiUtilizatorii() {
        return totiUtilizatorii;
    }

    @Override
    public void citireCarti() { // citeste cartile din fisier(toate cartile cu un anumit titlu, cu toate id-urile), diferita de cea din clasa CitireCarte(citeste o singura carte)
        try {
            int i = 0;
            File file = new File("proiectPAO_partea1\\src\\biblioteca\\carti.in");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine() || scanner.hasNextInt()) {
                String titlu = scanner.nextLine();
                String autor = scanner.nextLine();
                String editura = scanner.nextLine();
                String genLiterar = scanner.nextLine();
                String numarPaginiStr = scanner.nextLine();
                String anAparitieStr = scanner.nextLine();

                int numarPagini = Integer.parseInt(numarPaginiStr);
                int anAparitie = Integer.parseInt(anAparitieStr);

                Map<String, ArrayList<Tuple>> dictionarIduriExemplare = new HashMap<>();
                String idExemplar = scanner.nextLine();
                String[] id_uri = idExemplar.split(" ");
                ArrayList<Tuple> tupluri = new ArrayList<>();
                for (String id : id_uri) {
                    tupluri.add(new Tuple(Integer.parseInt(id), "disponibil"));
                    dictionarIduriExemplare.put(titlu, tupluri);
                }

                ExemplarCarte exemplarCarte = new ExemplarCarte(titlu, autor, editura, genLiterar, numarPagini, anAparitie, dictionarIduriExemplare);
                toateCartile[i] = exemplarCarte;
                i++;
            }
            nrTotalCarti = i - 1;
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit.");
        }
    }
    @Override
    public void afisareCarti() {
        for (ExemplarCarte crt : toateCartile) {
            if (crt == null)
                break;
            System.out.println(crt.getTitlu());
            System.out.println(crt.getAutor());
            System.out.println(crt.getEditura());
            System.out.println(crt.getGenLiterar());
            System.out.println(crt.getNumarPagini());
            System.out.println(crt.getAnAparitie());

            for (Tuple element : crt.getDictionarIduriExemplare().get(crt.getTitlu())) {
                try {
                    if(!crt.validare(element.getId()))
                        throw new IdInvalidExceptie("Id exemplar carte invalid.");
                    else
                        System.out.print(element.getId() + " ");
                } catch (IdInvalidExceptie exceptie) {
                    System.out.print(exceptie.getMessage() + " ");
                }
            }
            System.out.println();
        }
    }
    @Override
    public void citireUtilizatori() {
        try {
            int i = 0;
            File file1 = new File("proiectPAO_partea1\\src\\biblioteca\\utilizatori.in");
            Scanner scanner = new Scanner(file1);

            while (scanner.hasNextLine() || scanner.hasNextInt()) {
                String idUtilizatorStr = scanner.nextLine();
                int idUtilizator = Integer.parseInt(idUtilizatorStr);
                String nume = scanner.nextLine();
                UtilizatorBiblioteca utilizatorBiblioteca = new UtilizatorBiblioteca(idUtilizator, nume);

                totiUtilizatorii[i] = utilizatorBiblioteca;
                i++;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit.");
        }
    }
    @Override
    public void afisareUtilizatori() {
        for (UtilizatorBiblioteca utl : getTotiUtilizatorii()) {
            if (utl == null)
                break;

            try {
                if(!utl.validare(utl.getIdUtilizator()))
                    throw new IdInvalidExceptie("Id utilizator invalid.");
                else
                    System.out.println(utl.getIdUtilizator() + " " + utl.getNume());
            } catch (IdInvalidExceptie exceptie) {
                System.out.println(exceptie.getMessage());
            }
        }
    }
    @Override
    public void citireAdaugareCarteNoua() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titlu: ");
        String titlu = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Editura: ");
        String editura = scanner.nextLine();
        System.out.print("Gen literar: ");
        String genLiterar = scanner.nextLine();
        System.out.print("Numar pagini: ");
        String numarPaginiStr = scanner.nextLine();
        System.out.print("An aparitie: ");
        String anAparitieStr = scanner.nextLine();

        int numarPagini = Integer.parseInt(numarPaginiStr);
        int anAparitie = Integer.parseInt(anAparitieStr);

        Map<String, ArrayList<Tuple>> dictionarIduriExemplare = new HashMap<>();
        System.out.print("Id exemplar: ");
        String idExemplar = scanner.nextLine();
        String[] id_uri = idExemplar.split(" ");
        ArrayList<Tuple> tupluri = new ArrayList<>();
        for (String id : id_uri) {
            tupluri.add(new Tuple(Integer.parseInt(id), "disponibil"));
            dictionarIduriExemplare.put(titlu, tupluri);
        }

        ExemplarCarte exemplarCarte = new ExemplarCarte(titlu, autor, editura, genLiterar, numarPagini, anAparitie, dictionarIduriExemplare);
        toateCartile[++nrTotalCarti] = exemplarCarte;
    }

    @Override
    public void imprumutareCarte() {
        String titlu;
        int idCarte;
        int idUtilizator = 0;
        String numeUtilizator = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Numarul cartilor imprumutate: ");
        String nrCartiImprumutateStr = scanner.nextLine();
        int nrCartiImprumutate = Integer.parseInt(nrCartiImprumutateStr);

        // citesc fiecare carte imprumutata si ii modific starea din "disponibil" in "indisponibil" in tuplul corespunzator din Map:
        for (int i1 = 1; i1 <= nrCartiImprumutate; i1++) {
            System.out.print("Titlul cartii imprumutate: ");
            titlu = scanner.nextLine();

            System.out.print("Id-ul cartii imprumutate: ");
            String idCarteStr = scanner.nextLine();
            idCarte = Integer.parseInt(idCarteStr);

            // presupunem ca utilizatorul introdus este corect
            System.out.print("Id-ul utilizatorului care a imprumutat cartea: ");
            String idUtilizatorStr = scanner.nextLine();
            idUtilizator = Integer.parseInt(idUtilizatorStr);

            System.out.print("Numele utilizatorului care a imprumutat cartea: ");
            numeUtilizator = scanner.nextLine();

            // schimbarea starii cartii care a fost imprumutata:
            boolean okTitlu = false;
            boolean okId = false;
            try {
                for (ExemplarCarte i : toateCartile) {
                    if (i == null)
                        break;
                    if (i.getTitlu().equals(titlu)) try {
                        okTitlu = true;
                        int k = 0;
                        for (Tuple j : i.getDictionarIduriExemplare().get(titlu)) {
                            if (i.getDictionarIduriExemplare().get(titlu).get(k).getId() == idCarte) {
                                i.getDictionarIduriExemplare().get(titlu).get(k).modificaStare();
                                okId = true;
                                System.out.println("Cartea a fost imprumutata cu succes.");
                                // apelarea functiei care adauga cartea citita in istoricul utilizatorului:
                                UtilizatorBiblioteca utilizatorBiblioteca = new UtilizatorBiblioteca(idUtilizator, numeUtilizator);
                                utilizatorBiblioteca.adaugareIdInCartiImprumutate(idUtilizator, idCarte);
                            }
                            k++;
                        }

                        if (!okId)
                            throw new IdInexistentExceptie("Id-ul cartii citite nu exista in biblioteca.");
                    } catch (IdInexistentExceptie exceptie) {
                        System.out.println(exceptie.getMessage());
                        break;
                    }
                }
                if (!okTitlu)
                    throw new TitluInexistentExceptie("Titlul citit nu exista in biblioteca.");
            } catch (TitluInexistentExceptie e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
