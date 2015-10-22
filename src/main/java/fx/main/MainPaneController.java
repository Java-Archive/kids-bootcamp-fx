package fx.main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

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

  public Button btnAk, btnBk, btnCk, btnDk, btnEk, btnFk, btnGk, btnHk;
  public Button btnIk, btnJk, btnKk, btnLk, btnMk, btnNk, btnOk, btnPk;
  public Button btnQk, btnRk, btnSk, btnTk, btnUk, btnVk, btnWk, btnXk;
  public Button btnYk, btnZk;


  private List<Button> buttonList;
  private List<Button> buttonListK;


  //    public Button btnVor;
  public Button btnZuerueck;
  public Button btnLeer;
  public Button btnOK;

  public int counterSmilyWrite=0;
  public int counterSmilyCalc=0;

  public int counterNotSmilyWrite=0;
  public int counterNotSmilyCalc=0;

  public Label labelOKCalc;
  public Label labelBadCalc;

  public Label labelOKWrite;
  public Label labelBadWrite;

  public Button btnCalcPlus;
  public Button btnCalcMinus;

  public TextField textFieldMatheAPlus;
  public TextField textFieldMatheBPlus;
  public TextField textFieldMatheAMinus;
  public TextField textFieldMatheBMinus;

  private List<String> words = new ArrayList<String>();

  public MainPaneController() {

    words.add("SVEN");
    words.add("MAX");
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

    words.add("Max");
    words.add("Sven");
    words.add("Opa");
    words.add("Oma");
    words.add("Mama");
    words.add("Papa");
    words.add("Katrin");
    words.add("Kasper");
    words.add("Lukas");
    words.add("Nicklas");
    words.add("Auto");
    words.add("Haus");
    words.add("Baum");
    words.add("Wasser");
    words.add("Julia");
    words.add("Dietmar");
    words.add("Gunnar");
    words.add("Ben");
    words.add("Leo");

  }


  @Override
  public void initialize(URL location, ResourceBundle resources) {

    Collections.shuffle(words);
    textFieldA.setText(words.get(0));

//        btnVor.setOnAction();
    btnZuerueck.setOnAction(event -> {
      String text = textFieldB.getText();
      if (text.isEmpty()) {
      } else {
        textFieldB.setText(text.substring(0, text.length() - 1));
      }
    });
    btnLeer.setOnAction(event -> textFieldB.setText(""));

    btnOK.setOnAction(event -> {
      if (textFieldB.getText().equals(textFieldA.getText())) {
        counterSmilyWrite = counterNotSmilyWrite +1;
//        labelOKWrite.setText(":-) " + counterSmilyWrite);
        labelOKWrite.setText(labelOKWrite.getText() + ":-) ");
      } else {
        counterNotSmilyWrite = counterNotSmilyWrite +1;
//        labelBadWrite.setText(":-( " + counterNotSmilyWrite);
        labelBadWrite.setText(labelBadWrite.getText() + ":-( ");
      }

      textFieldA.setText("");
      textFieldB.setText("");

      Collections.shuffle(words);
      textFieldA.setText(words.get(0));
    });

    buttonList = Arrays.asList(btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH,
        btnI, btnJ, btnK, btnL,btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ);

    buttonListK = Arrays.asList(btnAk, btnBk, btnCk, btnDk, btnEk, btnFk, btnGk, btnHk,
        btnIk, btnJk, btnKk, btnLk, btnMk,btnNk, btnOk, btnPk, btnQk, btnRk, btnSk, btnTk, btnUk, btnVk, btnWk, btnXk, btnYk, btnZk);

    buttonList.forEach(b-> addButtonEventHandler(b, textFieldB));
    buttonListK.forEach(b-> addButtonEventHandler(b, textFieldB));



    //rechenaufgaben
    btnCalcPlus.setOnAction(event -> {
      String result = textFieldMatheBPlus.getText().trim();
      boolean smily = Integer.valueOf(result).equals(expectedResultPlus);
      if (smily) {
        counterSmilyCalc = counterSmilyCalc + 1;
//        labelOKCalc.setText( ":-} " + counterSmilyCalc);
        labelOKCalc.setText( labelOKCalc.getText() + ":-} ");
      } else {
        counterNotSmilyCalc = counterNotSmilyCalc + 1;
//        labelBadCalc.setText(":-{ " + counterNotSmilyCalc);
        labelBadCalc.setText(labelBadCalc.getText() + ":-{ ");
      }
      initNextRechenaufgabePlus();

    });

    btnCalcMinus.setOnAction(event -> {
      String result = textFieldMatheBMinus.getText().trim();
      boolean smily = Integer.valueOf(result).equals(expectedResultMinus);
      if (smily) {
        counterSmilyCalc = counterSmilyCalc + 1;
//        labelOKCalc.setText( ":-} " + counterSmilyCalc);
        labelOKCalc.setText( labelOKCalc.getText() + ":-} ");
      } else {
        counterNotSmilyCalc = counterNotSmilyCalc + 1;
//        labelBadCalc.setText(":-{ " + counterNotSmilyCalc);
        labelBadCalc.setText(labelBadCalc.getText() + ":-{ ");
      }
      initNextRechenaufgabeMinus();

    });
    initNextRechenaufgabePlus();
    initNextRechenaufgabeMinus();


  }

  private Random random = new Random();

  private void initNextRechenaufgabePlus() {
    int[] ints = random.ints(0, 5).limit(2).toArray();
    expectedResultPlus = ints[0] + ints[1];
    textFieldMatheAPlus.setText(ints[0] + " + " + ints[1]);
    textFieldMatheBPlus.setText("");
  }

  private void initNextRechenaufgabeMinus() {
    int[] ints = new int[2];
    ints[0] = random.ints(1, 10).limit(1).toArray()[0];
    ints[1] = random.ints(0, ints[0]).limit(1).toArray()[0];
    expectedResultMinus = ints[0] - ints[1];
    textFieldMatheAMinus.setText(ints[0] + " - " + ints[1]);
    textFieldMatheBMinus.setText("");
  }

  private int expectedResultPlus = 0;
  private int expectedResultMinus = 0;

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
