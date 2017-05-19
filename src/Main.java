import javax.swing.*;

public class Main
{
    public static void main(String [] args)
    {
        DokumentKolekcja dokumentKolekcja = new DokumentKolekcja(); // Inicjalizacja pola "dokumentKolekcja" konstruktorem
        Raport raport = new Raport(dokumentKolekcja); // Inicjalizacja pola "raport" konstruktorem

        JFrame frameGUI = new JFrame("GUI"); // Okienko
        frameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zamkniecie przez przycisk
        frameGUI.setContentPane(new GUI(dokumentKolekcja, raport).getMainPanel()); // Przekazanie parametrow do konstruktora GUI
        frameGUI.pack();
        frameGUI.setVisible(true); // Ustawienie widocznego okna
    }
}
