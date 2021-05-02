package rocnikovka123;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button b1;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextArea text3;
    @FXML
    private TextField text4;
    @FXML
    private Label label;
    @FXML
    private Label label2;
    @FXML
    private RadioButton radio;

    Random x = new Random();

    int r1 = x.nextInt(9) + 1;
    int r2 = x.nextInt(9) + 1;
    int r3 = x.nextInt(9) + 1;
    int r4 = x.nextInt(9) + 1;

    int pokusy = 0;

    String vysledeks = (r1 + "" + r2 + "" + r3 + "" + r4);
    int vysledek = (1000 * r1 + 100 * r2 + 10 * r3 + r4);

    String spravne = "✓";
    String spatnapozice = "#";
    String spatne = "X";
    String napovedaZacatek = "Zadej 4 čísla";
    String napoveda1;
    String napoveda2;
    String napoveda3;
    String napoveda4;
    String tahy;

    @FXML
    private void vyhodnotit(ActionEvent event) {
        String Input = text1.getText();
        int InputInt = Integer.parseInt(Input);
        if (InputInt < 1111) {
            napoveda1 = spatne;
            napoveda2 = spatne;
            napoveda3 = spatne;
            napoveda4 = spatne;
            label.setText("zadej jen 4 čísla");
        }

        int pozice1 = Character.getNumericValue(Input.charAt(0));
        int pozice2 = Character.getNumericValue(Input.charAt(1));
        int pozice3 = Character.getNumericValue(Input.charAt(2));
        int pozice4 = Character.getNumericValue(Input.charAt(3));
         
            
        
        if (InputInt == vysledek) {
            pokusy++;
            napoveda1 = spravne;
            napoveda2 = spravne;
            napoveda3 = spravne;
            napoveda4 = spravne;
            text4.setVisible(true);
            b1.setVisible(false);
            radio.setVisible(false);
            label2.setVisible(false);
            if (pokusy == 1) {
                tahy = "tahu";
            } else {
                tahy = "tazích";
            }
            text4.setText("Vyhrál jsi v " + pokusy + " " + tahy + ".");
            

        } else {
            if (pozice1 == r1) {
                napoveda1 = spravne;
            } else {
                if (vysledeks.contains(String.valueOf(pozice1))) {
                    napoveda1 = spatnapozice;
                } else {
                    napoveda1 = spatne;
                }
            }//----------------------------
            if (pozice2 == r2) {
                napoveda2 = spravne;
            } else {
                if (vysledeks.contains(String.valueOf(pozice2))) {
                    napoveda2 = spatnapozice;
                } else {
                    napoveda2 = spatne;
                }
            }//----------------------------
            if (pozice3 == r3) {
                napoveda3 = spravne;
            } else {
                if (vysledeks.contains(String.valueOf(pozice3))) {
                    napoveda3 = spatnapozice;
                } else {
                    napoveda3 = spatne;
                }
            }//----------------------------
            if (pozice4 == r4) {
                napoveda4 = spravne;
            } else {
                if (vysledeks.contains(String.valueOf(pozice4))) {
                    napoveda4 = spatnapozice;
                } else {
                    napoveda4 = spatne;
                }

            }
            if (InputInt > 9999) {
                napoveda1 = spatne;
                napoveda2 = spatne;
                napoveda3 = spatne;
                napoveda4 = spatne;
                label.setText("zadej jen 4 čísla");

            } else {
                label.setText("Poslední tah: " + Input);
            }
        }
        pokusy++;
        label2.setText("pokusy: " + pokusy);

        text2.setText(napoveda1 + " " + napoveda2 + " " + napoveda3 + " " + napoveda4);

    }

    @FXML
    private void radioAction() {
        if (radio.isSelected()) {
            text3.setVisible(true);
            b1.setVisible(false);
        } else {
            text3.setVisible(false);
            b1.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
