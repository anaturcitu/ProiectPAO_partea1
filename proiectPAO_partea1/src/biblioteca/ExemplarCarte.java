package biblioteca;
import java.util.Map;
import java.util.ArrayList;
import service.Validare;

public class ExemplarCarte extends Carte implements Validare{
    int idCarte;

    public int getIdCarte() {
        return idCarte;
    }

    public ExemplarCarte() { }
    public ExemplarCarte(String titlu, String autor, String editura, String genLiterar, int numarPagini, int anAparitie, Map<String, ArrayList<utile.Tuple>> dictionarIduriExemplare) {
        super(titlu, autor, editura, genLiterar, numarPagini, anAparitie, dictionarIduriExemplare);
    }

    public ExemplarCarte(String titlu, String autor, String editura, String genLiterar, int numarPagini, int anAparitie, int idCarte) {
        super(titlu, autor, editura, genLiterar, numarPagini, anAparitie);
        this.idCarte = idCarte;
    }

    @Override
    public boolean validare(int  id) {
        if(id >= 1000 && id <= 9999)
            return true;
        return false;
    }
}
