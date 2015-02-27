package fx.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Sven Ruppert on 01.06.2014.
 */
public class MainPaneController implements Initializable {

    public TextField textFieldA;
    public TextField textFieldB;
    public Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH;
    public Button btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP;
    public Button btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX;
    public Button btnY, btnZ;

    //    public Button btnVor;
    public Button btnZuerueck;
    public Button btnLeer;
    public Button btnOK;
    public Label labelOK;
    public Label labelBad;

    private List<String> words = new ArrayList<String>();

    public MainPaneController() {
        System.out.println("MainPaneController = OK");

        words.add("MAX");
        words.add("SVEN");
        words.add("OPA");
        words.add("OMA");
        words.add("MAMA");
        words.add("PAPA");
        words.add("KATRIN");
        words.add("KASPER");
        words.add("LUKAS");
        words.add("NICKLAS");
        words.add("AUTO");
        words.add("HAUS");
        words.add("BAUM");
        words.add("WASSER");
        words.add("JULIA");
        words.add("DIETMAR");
        words.add("GUNNAR");
        words.add("BEN");
        words.add("LEO");

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        btnVor.setOnAction();
        btnZuerueck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textFieldB.getText();
                if (text.isEmpty()) {
                } else {
                    textFieldB.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        btnLeer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldB.setText("");
            }
        });

        btnOK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldB.getText().equals(textFieldA.getText())){
                    labelOK.setText(labelOK.getText() + " :-)");
                }
                else{
                    labelBad.setText(labelBad.getText() + " :-(");
                }

                textFieldA.setText("");
                textFieldB.setText("");

                Collections.shuffle(words);
                textFieldA.setText(words.get(0));
            }
        });


        addButtonEventHandler(btnA, textFieldB);
        addButtonEventHandler(btnB, textFieldB);
        addButtonEventHandler(btnC, textFieldB);
        addButtonEventHandler(btnD, textFieldB);
        addButtonEventHandler(btnE, textFieldB);
        addButtonEventHandler(btnF, textFieldB);
        addButtonEventHandler(btnG, textFieldB);
        addButtonEventHandler(btnH, textFieldB);
        addButtonEventHandler(btnI, textFieldB);
        addButtonEventHandler(btnJ, textFieldB);
        addButtonEventHandler(btnK, textFieldB);
        addButtonEventHandler(btnL, textFieldB);
        addButtonEventHandler(btnM, textFieldB);
        addButtonEventHandler(btnN, textFieldB);
        addButtonEventHandler(btnO, textFieldB);
        addButtonEventHandler(btnP, textFieldB);
        addButtonEventHandler(btnQ, textFieldB);
        addButtonEventHandler(btnR, textFieldB);
        addButtonEventHandler(btnS, textFieldB);
        addButtonEventHandler(btnT, textFieldB);
        addButtonEventHandler(btnU, textFieldB);
        addButtonEventHandler(btnV, textFieldB);
        addButtonEventHandler(btnW, textFieldB);
        addButtonEventHandler(btnX, textFieldB);
        addButtonEventHandler(btnY, textFieldB);
        addButtonEventHandler(btnZ, textFieldB);


    }

    private void addButtonEventHandler(Button btn, TextField tf) {
        btn.setOnAction(new ButtonEventHandler(btn, tf));
    }

    private static class ButtonEventHandler implements EventHandler<ActionEvent> {

        private Button btn;
        private TextField tf;

        public ButtonEventHandler(Button btn, TextField tf) {
            this.btn = btn;
            this.tf = tf;
        }

        @Override
        public void handle(ActionEvent event) {
            String text = btn.getText();
            tf.setText(tf.getText() + text);
        }
    }


}
