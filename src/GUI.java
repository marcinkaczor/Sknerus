import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ButtonGroup;

public class GUI
{
    private JPanel MainPanel;
    private JTextArea ekran;
    private JButton DODAJButton;
    private JTextField pathTextField;
    private JButton WCZYTAJButton;
    private JButton ZESTAWIENIEILOSCIOWEButton;
    private JButton ZESTAWIENIEJAKOSCIOWEButton;
    private JTextField textFieldTypeA;
    private JTextField textFieldTypeB;
    private JTextField textFieldProduct;
    private JTextField textFieldAmount;
    private JTextField textFieldValue;
    private JTextField textFieldTax;
    private JTextField textFieldClient;
    private JButton WYCZYSCButton;
    private JButton RESETUJButton;
    private JRadioButton a100RadioButton;
    private JRadioButton a1000RadioButton;
    private JRadioButton a10000RadioButton;
    private JTextArea konsola;
    private JButton WYSWIETLButton;

    private DokumentKolekcja dokumentKolekcja;
    private Raport raport;

    public GUI(DokumentKolekcja dokumentKolekcja, Raport raport) {

        this.dokumentKolekcja = dokumentKolekcja;
        this.raport = raport;

        ekran.setText(""); // Ustawienie tekstu w polu "ekran" na pusty lancuch
        konsola.setText(""); // Ustawienie tekstu w polu "ekran" na pusty lancuch
        groupButton(); // Metoda pozwalajaca na wybor tylko jednego przycisku RadioButton

        DODAJButton.addActionListener(new ActionListener() { // Dodanie recznie dokumentu
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dokument nowyDokument = new Dokument(textFieldTypeA.getText(), textFieldTypeB.getText(), textFieldProduct.getText(),
                            Integer.parseInt(textFieldAmount.getText()), Double.parseDouble(textFieldValue.getText()),
                            Double.parseDouble(textFieldTax.getText()), Integer.parseInt(textFieldClient.getText()));
                    dokumentKolekcja.dodajDokumentDoKolekcji(nowyDokument);
                    ekran.append(nowyDokument.toString() + '\n');
                } catch (NumberFormatException e1) {
                    konsola.append("Nieprawidlowy format danych wejsciowych!");
                }
            }
        });

        RESETUJButton.addActionListener(new ActionListener() { // Resetowanie wprowadzonego tekstu w text fieldach
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldTypeA.setText("");
                textFieldTypeB.setText("");
                textFieldProduct.setText("");
                textFieldAmount.setText("");
                textFieldValue.setText("");
                textFieldTax.setText("");
                textFieldClient.setText("");
            }
        });

        WCZYTAJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dokumentKolekcja.wczytajZPlikuDokumentyDoKolekcji(pathTextField.getText());
                    /*for (Dokument x : dokumentKolekcja.getKolekcjaDokumentow()) {
                        ekran.append(x.toString() + '\n');
                        if(a100RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a100RadioButton.getText()) == 0))) {
                            ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                            ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                        } else if(a1000RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a1000RadioButton.getText()) == 0))) {
                            ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                            ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                        } else if(a10000RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a10000RadioButton.getText()) == 0))) {
                            ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                            ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                        }
                    }
                    for(String x : dokumentKolekcja.getKolekcjaBledow()) {
                        konsola.append(x + '\n');
                    }*/
                } catch (FileNotFoundException e1) {
                    konsola.append("Plik o podanej sciezce nie istnieje!" + '\n');
                } catch (NumberFormatException e2) {
                    konsola.append("Nieprawidlowy format danych wejsciowych!" + '\n');

                }
            }
        });

        ZESTAWIENIEILOSCIOWEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ekran.append(String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
            }
        });

        ZESTAWIENIEJAKOSCIOWEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ekran.append(String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
            }
        });

        WYCZYSCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ekran.setText(""); // Czyszczenie ekranu
                konsola.setText(""); // Czyszczenie konsoli
            }
        });


        WYSWIETLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Dokument x : dokumentKolekcja.getKolekcjaDokumentow()) {
                    ekran.append(x.toString() + '\n');
                    if(a100RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a100RadioButton.getText()) == 0))) {
                        ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                        ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                    } else if(a1000RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a1000RadioButton.getText()) == 0))) {
                        ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                        ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                    } else if(a10000RadioButton.isSelected() && ((Dokument.getNextId() % Integer.parseInt(a10000RadioButton.getText()) == 0))) {
                        ekran.append("Ilosciowe: " + String.valueOf(raport.getZestawienieIlosciowe()) + '\n');
                        ekran.append("Jakosciowe: " + String.valueOf(raport.getZestawienieJakosciowe()) + '\n');
                    }
                }
                for(String x : dokumentKolekcja.getKolekcjaBledow()) {
                    konsola.append(x + '\n');
                }

            }
        });
    }

    private void groupButton() {

        ButtonGroup bg1 = new ButtonGroup( );

        bg1.add(a100RadioButton);
        bg1.add(a1000RadioButton);
        bg1.add(a10000RadioButton);
    }

    public JPanel getMainPanel()
    {
        return MainPanel;
    }

}
