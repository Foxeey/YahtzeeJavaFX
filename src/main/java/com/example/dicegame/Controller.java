package com.example.dicegame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Controller {
    @FXML
    Pane stagePane;
    Stage stage;
    @FXML
    private MenuBar menuBar;
    private Menu nowaGraMenu = new Menu("Nowa Gra");
    private Menu wyjscieMenu = new Menu("Wyjście");
    @FXML
    private ImageView view1, view2, view3, view4, view5;
    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    @FXML
    private Button losujBtn;
    @FXML
    private Button Btn1P1, Btn2P1, Btn3P1, Btn4P1, Btn5P1, Btn6P1, Btn7P1, Btn8P1, Btn9P1, Btn10P1, Btn11P1, Btn12P1, Btn13P1;
    @FXML
    private Button Btn1P2, Btn2P2, Btn3P2, Btn4P2, Btn5P2, Btn6P2, Btn7P2, Btn8P2, Btn9P2, Btn10P2, Btn11P2, Btn12P2, Btn13P2;
    @FXML
    private Label sumaP1, sumaP2, sumaCalaP1, sumaCalaP2;
    KontrolerKosci myKontroler = new KontrolerKosci();
    private boolean player = true;
    private int sumaOgolna=0;
    private int suma=0;
    private int P1punkty[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int P2punkty[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
    private Random random = new Random();
    private int los[] = {2, 1, 3, 1, 1};
    private int counter = 0;
    private int tury = 0;
    private int liczbaPunktowP1 = 0;
    private int liczbaPunktowP2 = 0;
    private Image D1image = new Image("D1.png");
    private Image D2image = new Image("D2.png");
    private Image D3image = new Image("D3.png");
    private Image D4image = new Image("D4.png");
    private Image D5image = new Image("D5.png");
    private Image D6image = new Image("D6.png");

    public void losujKosci(ActionEvent event) {
        counter++;

            if (!checkBox1.isSelected()) {
                los[0] = random.nextInt(1, 6);
                podmienKosci(los[0], view1);
            }
            if (!checkBox2.isSelected()) {
                los[1] = random.nextInt(1, 6);
                podmienKosci(los[1], view2);
            }
            if (!checkBox3.isSelected()) {
                los[2] = random.nextInt(1, 6);
                podmienKosci(los[2], view3);
            }
            if (!checkBox4.isSelected()) {
                los[3] = random.nextInt(1, 6);
                podmienKosci(los[3], view4);
            }
            if (!checkBox5.isSelected()) {
                los[4] = random.nextInt(1, 6);
                podmienKosci(los[4], view5);
            }
            myKontroler.getLos(los);
            obliczWynik();
        if(counter>2) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Skonczyl ci sie los");
            alert.setTitle("Brak losu");
            alert.show();
            losujBtn.setDisable(true);
        }
    }
    public void blokujWynik(ActionEvent event) {
        Node source = (Node) event.getSource();
        String id = source.getId();
        if(player) {
            switch (id) {
                case "Btn1P1":
                    Btn1P1.setDisable(true);
                    P1punkty[0] = Integer.parseInt(Btn1P1.getText());
                    break;
                case "Btn2P1":
                    Btn2P1.setDisable(true);
                    P1punkty[1] = Integer.parseInt(Btn2P1.getText());
                    break;
                case "Btn3P1":
                    Btn3P1.setDisable(true);
                    P1punkty[2] = Integer.parseInt(Btn3P1.getText());
                    break;
                case "Btn4P1":
                    Btn4P1.setDisable(true);
                    P1punkty[3] = Integer.parseInt(Btn4P1.getText());
                    break;
                case "Btn5P1":
                    Btn5P1.setDisable(true);
                    P1punkty[4] = Integer.parseInt(Btn5P1.getText());
                    break;
                case "Btn6P1":
                    Btn6P1.setDisable(true);
                    P1punkty[5] = Integer.parseInt(Btn6P1.getText());
                    break;
                case "Btn7P1":
                    Btn7P1.setDisable(true);
                    P1punkty[6] = Integer.parseInt(Btn7P1.getText());
                    break;
                case "Btn8P1":
                    Btn8P1.setDisable(true);
                    P1punkty[7] = Integer.parseInt(Btn8P1.getText());
                    break;
                case "Btn9P1":
                    Btn9P1.setDisable(true);
                    P1punkty[8] = Integer.parseInt(Btn9P1.getText());
                    break;
                case "Btn10P1":
                    Btn10P1.setDisable(true);
                    P1punkty[9] = Integer.parseInt(Btn10P1.getText());
                    break;
                case "Btn11P1":
                    Btn11P1.setDisable(true);
                    P1punkty[10] = Integer.parseInt(Btn11P1.getText());
                    break;
                case "Btn12P1":
                    Btn12P1.setDisable(true);
                    P1punkty[11] = Integer.parseInt(Btn12P1.getText());
                    break;
                case "Btn13P1":
                    Btn13P1.setDisable(true);
                    P1punkty[12] = Integer.parseInt(Btn13P1.getText());
                    break;
            }
        } else if(!player) {
            switch (id) {
                case "Btn1P2":
                    Btn1P2.setDisable(true);
                    P2punkty[0] = Integer.parseInt(Btn1P2.getText());
                    break;
                case "Btn2P2":
                    Btn2P2.setDisable(true);
                    P2punkty[1] = Integer.parseInt(Btn2P2.getText());
                    break;
                case "Btn3P2":
                    Btn3P2.setDisable(true);
                    P2punkty[2] = Integer.parseInt(Btn3P2.getText());
                    break;
                case "Btn4P2":
                    Btn4P2.setDisable(true);
                    P2punkty[3] = Integer.parseInt(Btn4P2.getText());
                    break;
                case "Btn5P2":
                    Btn5P2.setDisable(true);
                    P2punkty[4] = Integer.parseInt(Btn5P2.getText());
                    break;
                case "Btn6P2":
                    Btn6P2.setDisable(true);
                    P2punkty[5] = Integer.parseInt(Btn6P2.getText());
                    break;
                case "Btn7P2":
                    Btn7P2.setDisable(true);
                    P2punkty[6] = Integer.parseInt(Btn7P2.getText());
                    break;
                case "Btn8P2":
                    Btn8P2.setDisable(true);
                    P2punkty[7] = Integer.parseInt(Btn8P2.getText());
                    break;
                case "Btn9P2":
                    Btn9P2.setDisable(true);
                    P2punkty[8] = Integer.parseInt(Btn9P2.getText());
                    break;
                case "Btn10P2":
                    Btn10P2.setDisable(true);
                    P2punkty[9] = Integer.parseInt(Btn10P2.getText());
                    break;
                case "Btn11P2":
                    Btn11P2.setDisable(true);
                    P2punkty[10] = Integer.parseInt(Btn11P2.getText());
                    break;
                case "Btn12P2":
                    Btn12P2.setDisable(true);
                    P2punkty[11] = Integer.parseInt(Btn12P2.getText());
                    break;
                case "Btn13P2":
                    Btn13P2.setDisable(true);
                    P2punkty[12] = Integer.parseInt(Btn13P2.getText());
                    break;
            }
        }
        sumuj();
        wyczyscButton();
        player = !player;
        zmianaGracza();
    }
    public void obliczWynik() {

        if(player) {
            myKontroler.liczWynik();
            if(!Btn1P1.isDisabled())
                Btn1P1.setText(Integer.toString(myKontroler.punkty[0]));
            if(!Btn2P1.isDisabled())
                Btn2P1.setText(Integer.toString(myKontroler.punkty[1]));
            if(!Btn3P1.isDisabled())
                Btn3P1.setText(Integer.toString(myKontroler.punkty[2]));
            if(!Btn4P1.isDisabled())
                Btn4P1.setText(Integer.toString(myKontroler.punkty[3]));
            if(!Btn5P1.isDisabled())
                Btn5P1.setText(Integer.toString(myKontroler.punkty[4]));
            if(!Btn6P1.isDisabled())
                Btn6P1.setText(Integer.toString(myKontroler.punkty[5]));
            if(!Btn7P1.isDisabled())
                Btn7P1.setText(Integer.toString(myKontroler.punkty[6]));
            if(!Btn8P1.isDisabled())
                Btn8P1.setText(Integer.toString(myKontroler.punkty[7]));
            if(!Btn9P1.isDisabled())
                Btn9P1.setText(Integer.toString(myKontroler.punkty[8]));
            if(!Btn10P1.isDisabled())
                Btn10P1.setText(Integer.toString(myKontroler.punkty[9]));
            if(!Btn11P1.isDisabled())
                Btn11P1.setText(Integer.toString(myKontroler.punkty[10]));
            if(!Btn12P1.isDisabled())
                Btn12P1.setText(Integer.toString(myKontroler.punkty[11]));
            if(!Btn13P1.isDisabled())
                Btn13P1.setText(Integer.toString(myKontroler.punkty[12]));
        } else if(!player) {
            myKontroler.liczWynik();
            if(!Btn1P2.isDisabled())
                Btn1P2.setText(Integer.toString(myKontroler.punkty[0]));
            if(!Btn2P2.isDisabled())
                Btn2P2.setText(Integer.toString(myKontroler.punkty[1]));
            if(!Btn3P2.isDisabled())
                Btn3P2.setText(Integer.toString(myKontroler.punkty[2]));
            if(!Btn4P2.isDisabled())
                Btn4P2.setText(Integer.toString(myKontroler.punkty[3]));
            if(!Btn5P2.isDisabled())
                Btn5P2.setText(Integer.toString(myKontroler.punkty[4]));
            if(!Btn6P2.isDisabled())
                Btn6P2.setText(Integer.toString(myKontroler.punkty[5]));
            if(!Btn7P2.isDisabled())
                Btn7P2.setText(Integer.toString(myKontroler.punkty[6]));
            if(!Btn8P2.isDisabled())
                Btn8P2.setText(Integer.toString(myKontroler.punkty[7]));
            if(!Btn9P2.isDisabled())
                Btn9P2.setText(Integer.toString(myKontroler.punkty[8]));
            if(!Btn10P2.isDisabled())
                Btn10P2.setText(Integer.toString(myKontroler.punkty[9]));
            if(!Btn11P2.isDisabled())
                Btn11P2.setText(Integer.toString(myKontroler.punkty[10]));
            if(!Btn12P2.isDisabled())
                Btn12P2.setText(Integer.toString(myKontroler.punkty[11]));
            if(!Btn13P2.isDisabled())
                Btn13P2.setText(Integer.toString(myKontroler.punkty[12]));
        }
    }
    public void zmianaGracza() {
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox5.setSelected(false);
        losujBtn.setDisable(false);
        los[0] = random.nextInt(1, 6);
        podmienKosci(los[0], view1);
        los[1] = random.nextInt(1, 6);
        podmienKosci(los[1], view2);
        los[2] = random.nextInt(1, 6);
        podmienKosci(los[2], view3);
        los[3] = random.nextInt(1, 6);
        podmienKosci(los[3], view4);
        los[4] = random.nextInt(1, 6);
        podmienKosci(los[4], view5);
        myKontroler.getLos(los);
        obliczWynik();
        counter = 1;
        tury++;
        String zwyciezca;
        if(tury == 26) {
            for(int i =0; i<P1punkty.length;i++) {
                liczbaPunktowP1 += P1punkty[i];
                liczbaPunktowP2 += P2punkty[i];
            }
            if(liczbaPunktowP1 > liczbaPunktowP1) {
                zwyciezca = "Wygral gracz 1";
            } else if (liczbaPunktowP1 == liczbaPunktowP2) {
                zwyciezca = "Remis";
            } else {
                zwyciezca = "Wygral gracz 2";
            }
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Wynik gry");
            alert1.setHeaderText(zwyciezca);
            alert1.show();
        }
    }
    public void podmienKosci(int kosc, ImageView imageView) {
        switch (kosc) {
            case 1 -> imageView.setImage(D1image);
            case 2 -> imageView.setImage(D2image);
            case 3 -> imageView.setImage(D3image);
            case 4 -> imageView.setImage(D4image);
            case 5 -> imageView.setImage(D5image);
            case 6 -> imageView.setImage(D6image);
            default -> {
            }
        }
    }
    public void sumuj() {
        suma = 0;
        sumaOgolna = 0;
        if(player) {
            for (int i = 0; i < 6; i++) {
                suma += P1punkty[i];
            }
            sumaP1.setText(Integer.toString(suma));
            for(int i=0; i<P1punkty.length;i++) {
                sumaOgolna += P1punkty[i];
            }
            sumaCalaP1.setText(Integer.toString(sumaOgolna));
        } else if(!player) {
            for (int i = 0; i < 6; i++) {
                suma += P2punkty[i];
            }
            sumaP2.setText(Integer.toString(suma));
            for(int i=0; i<P2punkty.length;i++) {
                sumaOgolna += P2punkty[i];
            }
            sumaCalaP2.setText(Integer.toString(sumaOgolna));
        }
    }
    public void wyczyscButton() {
        if(player) {
            if (!Btn1P1.isDisabled()) {
                Btn1P1.setText("0");
            }
            if (!Btn2P1.isDisabled()) {
                Btn2P1.setText("0");
            }
            if (!Btn3P1.isDisabled()) {
                Btn3P1.setText("0");
            }
            if (!Btn4P1.isDisabled()) {
                Btn4P1.setText("0");
            }
            if (!Btn5P1.isDisabled()) {
                Btn5P1.setText("0");
            }
            if (!Btn6P1.isDisabled()) {
                Btn6P1.setText("0");
            }
            if (!Btn7P1.isDisabled()) {
                Btn7P1.setText("0");
            }
            if (!Btn8P1.isDisabled()) {
                Btn8P1.setText("0");
            }
            if (!Btn9P1.isDisabled()) {
                Btn9P1.setText("0");
            }
            if (!Btn10P1.isDisabled()) {
                Btn10P1.setText("0");
            }
            if (!Btn11P1.isDisabled()) {
                Btn11P1.setText("0");
            }
            if (!Btn12P1.isDisabled()) {
                Btn12P1.setText("0");
            }
            if (!Btn13P1.isDisabled()) {
                Btn13P1.setText("0");
            }
        } else if(!player) {
            if (!Btn1P2.isDisabled()) {
                Btn1P2.setText("0");
            }
            if (!Btn2P2.isDisabled()) {
                Btn2P2.setText("0");
            }
            if (!Btn3P2.isDisabled()) {
                Btn3P2.setText("0");
            }
            if (!Btn4P2.isDisabled()) {
                Btn4P2.setText("0");
            }
            if (!Btn5P2.isDisabled()) {
                Btn5P2.setText("0");
            }
            if (!Btn6P2.isDisabled()) {
                Btn6P2.setText("0");
            }
            if (!Btn7P2.isDisabled()) {
                Btn7P2.setText("0");
            }
            if (!Btn8P2.isDisabled()) {
                Btn8P2.setText("0");
            }
            if (!Btn9P2.isDisabled()) {
                Btn9P2.setText("0");
            }
            if (!Btn10P2.isDisabled()) {
                Btn10P2.setText("0");
            }
            if (!Btn11P2.isDisabled()) {
                Btn11P2.setText("0");
            }
            if (!Btn12P2.isDisabled()) {
                Btn12P2.setText("0");
            }
            if (!Btn13P2.isDisabled()) {
                Btn13P2.setText("0");
            }
        }
    }
    public void nowaGra(ActionEvent event) {
        tury = 0;
        counter = 0;
        for(int i=0; i< P1punkty.length; i++) {
            P1punkty[i] = 0;
            P2punkty[i] = 0;
        }
        Btn1P1.setText("0");
        Btn2P1.setText("0");
        Btn3P1.setText("0");
        Btn4P1.setText("0");
        Btn5P1.setText("0");
        Btn6P1.setText("0");
        Btn7P1.setText("0");
        Btn8P1.setText("0");
        Btn9P1.setText("0");
        Btn10P1.setText("0");
        Btn11P1.setText("0");
        Btn12P1.setText("0");
        Btn13P1.setText("0");
        Btn1P1.setDisable(false);
        Btn2P1.setDisable(false);
        Btn3P1.setDisable(false);
        Btn4P1.setDisable(false);
        Btn5P1.setDisable(false);
        Btn6P1.setDisable(false);
        Btn7P1.setDisable(false);
        Btn8P1.setDisable(false);
        Btn9P1.setDisable(false);
        Btn10P1.setDisable(false);
        Btn11P1.setDisable(false);
        Btn12P1.setDisable(false);
        Btn13P1.setDisable(false);
        Btn1P2.setText("0");
        Btn2P2.setText("0");
        Btn3P2.setText("0");
        Btn4P2.setText("0");
        Btn5P2.setText("0");
        Btn6P2.setText("0");
        Btn7P2.setText("0");
        Btn8P2.setText("0");
        Btn9P2.setText("0");
        Btn10P2.setText("0");
        Btn11P2.setText("0");
        Btn12P2.setText("0");
        Btn13P2.setText("0");
        Btn1P2.setDisable(false);
        Btn2P2.setDisable(false);
        Btn3P2.setDisable(false);
        Btn4P2.setDisable(false);
        Btn5P2.setDisable(false);
        Btn6P2.setDisable(false);
        Btn7P2.setDisable(false);
        Btn8P2.setDisable(false);
        Btn9P2.setDisable(false);
        Btn10P2.setDisable(false);
        Btn11P2.setDisable(false);
        Btn12P2.setDisable(false);
        Btn13P2.setDisable(false);
        player = true;
        sumaCalaP1.setText("0");
        sumaCalaP2.setText("0");
        sumaP1.setText("0");
        sumaCalaP2.setText("0");
        los[0] = random.nextInt(1, 6);
        podmienKosci(los[0], view1);
        los[1] = random.nextInt(1, 6);
        podmienKosci(los[1], view2);
        los[2] = random.nextInt(1, 6);
        podmienKosci(los[2], view3);
        los[3] = random.nextInt(1, 6);
        podmienKosci(los[3], view4);
        los[4] = random.nextInt(1, 6);
        podmienKosci(los[4], view5);
        myKontroler.getLos(los);
        obliczWynik();
        counter = 1;
    }
    public void wyjscie() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Wyjście");
        exitAlert.setHeaderText("Wyjście z gry!");
        exitAlert.setContentText("Chcesz wyjść z gry?");

        if(exitAlert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) stagePane.getScene().getWindow();
            stage.close();
        }
    }
}