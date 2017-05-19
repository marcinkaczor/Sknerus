import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DokumentKolekcja {

    private ArrayList<Dokument> kolekcjaDokumentow;

    private ArrayList<String> kolekcjaBledow;

    public DokumentKolekcja() {

        this.kolekcjaDokumentow = new ArrayList<Dokument>();
        this.kolekcjaBledow = new ArrayList<String>();
    }

    public ArrayList<Dokument> getKolekcjaDokumentow() {
        return kolekcjaDokumentow;
    }

    public ArrayList<String> getKolekcjaBledow() { return kolekcjaBledow; }

    public void dodajDokumentDoKolekcji(Dokument dokument) {
        kolekcjaDokumentow.add(dokument);
    }

    public void wczytajZPlikuDokumentyDoKolekcji(String path) throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream(path));

        int i = 0; // licznik, ktory sluzy do znalezienia linii, w ktorej jest blad

        while (in.hasNextLine()) {


            String linia = in.nextLine(); // Kolejne linie wczytywane do zmiennej "linia"

            String[] field = linia.split(","); // Poszczegolne pola wczytanej linii z pliku

            field[7] = field[7].substring(0, field[7].length() - 1); // Wyciecie znaku "%"
            field[8] = field[8].substring(0, field[8].length() - 1); // Wyciecie znaku ";"

            try{
                Integer.parseInt(field[5]);
            } catch(NumberFormatException e) {
                System.out.println(i);
                continue;
            }
            try{
                Double.parseDouble(field[6]);
            } catch(NumberFormatException e) {
                System.out.println(i);
                continue;
            }
            try{
                Double.parseDouble(field[7]);
            } catch(NumberFormatException e) {
                System.out.println(i);
                continue;
            }
            try{
                Integer.parseInt(field[8]);
            } catch(NumberFormatException e) {
                System.out.println(i);
                continue;
            }

            if ((field[2].equals("income") || field[2].equals("outcome"))
                    && ((field[3].equals("Other")) || (field[3].equals("Invoice")) || (field[3].equals("Payment")) || (field[3].equals("Receipt")))
                    && (field[4].length() == 4)
                    && (Integer.parseInt(field[5]) > 0)
                    && (Double.parseDouble(field[6]) > 0)
                    && ((Double.parseDouble(field[7]) >= 0) && (Double.parseDouble(field[7]) <= 100))
                    && (Integer.parseInt(field[8]) > 0)) {

                    kolekcjaDokumentow.add(
                            new Dokument(field[2], field[3], field[4], Integer.parseInt(field[5]),
                                    Double.parseDouble(field[6]), Double.parseDouble(field[7]) / 100, Integer.parseInt(field[8]))); // Dodanie dokumentu do kolekcji

            } else kolekcjaBledow.add("Blad w linii nr " + field[1]); // Dodanie bledu do kolekcji bledow

            i++; //licznik

        }

    }

}
