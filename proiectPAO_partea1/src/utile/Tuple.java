package utile;

public class Tuple {
    private int id;
    private String stare;

    public Tuple(int id, String stare) {
        this.id = id;
        this.stare = stare;
    }

    public int getId() {
        return id;
    }

    public String modificaStare() {
        stare = "indisponibil";
        return stare;
    }
}