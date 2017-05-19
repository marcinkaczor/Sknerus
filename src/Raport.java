public class Raport {

    private int zestawienieIlosciowe = 0;
    private double zestawienieJakosciowe = 0;

    private DokumentKolekcja dokumentKolekcja;

    public Raport(DokumentKolekcja dokumentKolekcja) {

        this.dokumentKolekcja = dokumentKolekcja;
    }

    public int getZestawienieIlosciowe() {

        for(Dokument x : dokumentKolekcja.getKolekcjaDokumentow())
            zestawienieIlosciowe += x.getAmount();
        return zestawienieIlosciowe;
    }

    public double getZestawienieJakosciowe() {

        for(Dokument x : dokumentKolekcja.getKolekcjaDokumentow())
            zestawienieJakosciowe += x.getValue();
        return zestawienieJakosciowe;
    }

}
