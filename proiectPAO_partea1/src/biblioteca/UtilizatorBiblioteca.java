package biblioteca;

import java.util.*;

public class UtilizatorBiblioteca implements service.Validare{
    private int idUtilizator;
    private String nume;
    private Map<Integer, List<Integer>> istoricCartiImprumutate = new HashMap<>(); // map-ul care contine id-urile cartilor pe care le-a imprumutat un utilizator

    public UtilizatorBiblioteca(int idUtilizator, String nume) {
        this.idUtilizator = idUtilizator;
        this.nume = nume;
    }

    public void setIstoricCartiImprumutate(Map<Integer, List<Integer>> istoricCartiImprumutate) {
        this.istoricCartiImprumutate = istoricCartiImprumutate;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public String getNume() {
        return nume;
    }

    public void adaugareIdInCartiImprumutate(int idUtilizator, int idCarte) {
        List<Integer> lista = new ArrayList<Integer>();
        if(istoricCartiImprumutate.get(idUtilizator) != null)
            lista = istoricCartiImprumutate.get(idUtilizator);
        lista.add(idCarte);
        istoricCartiImprumutate.put(idUtilizator, lista);
        setIstoricCartiImprumutate(istoricCartiImprumutate);
        System.out.println("Cartea a fost adaugata in istoricul cartilor imprumutate ale utilizatorului.");
    }

//        public void afisareIstoricCartiUtilizator(int idUtilizator) {
//        Biblioteca biblioteca = new Biblioteca();
//        if(istoricCartiImprumutate.get(idUtilizator) == null)
//            System.out.println("Utilizatorul nu are istoric.");
//        else
//            for (int i : istoricCartiImprumutate.get(idUtilizator)) {
//                System.out.print(i + " ");
//            }
//    }
    @Override
    public boolean validare(int  id) {
        if(id >= 100 && id <= 999)
            return true;
        return false;
    }
}












