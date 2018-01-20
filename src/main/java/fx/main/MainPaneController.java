package fx.main;

import static java.util.Arrays.asList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.rapidpm.frp.functions.CheckedSupplier;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

  public Button btnAE, btnOE, btnUE;

  public Button btnAk, btnBk, btnCk, btnDk, btnEk, btnFk, btnGk, btnHk;
  public Button btnIk, btnJk, btnKk, btnLk, btnMk, btnNk, btnOk, btnPk;
  public Button btnQk, btnRk, btnSk, btnTk, btnUk, btnVk, btnWk, btnXk;
  public Button btnYk, btnZk;

  public Button btnAe, btnOe, btnUe, btnSz;

  private List<Button> buttonList;
  private List<Button> buttonListK;


  //    public Button btnVor;
  public Button btnZuerueck;
  public Button btnLeer;
  public Button btnOK;

  public int counterSmilyWrite = 0;
  public int counterSmilyCalc = 0;

  public int counterNotSmilyWrite = 0;
  public int counterNotSmilyCalc = 0;

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

  private List<String> words = new ArrayList<>();

  public MainPaneController() {
    ((CheckedSupplier<List<String>>) () -> new BufferedReader(
        new InputStreamReader(
            ClassLoader.getSystemResourceAsStream("words.txt")))
        .lines()
        .collect(Collectors.toList()))
        .get()
        .ifPresentOrElse(
            s -> words.addAll(s) ,
            System.out::print
        );

  }


  @Override
  public void initialize(URL location , ResourceBundle resources) {
    Collections.shuffle(words);
    textFieldA.setText(words.get(0));

    btnZuerueck.setOnAction(event -> {
      String text = textFieldB.getText();
      if (! text.isEmpty()) textFieldB.setText(text.substring(0 , text.length() - 1));
    });
    btnLeer.setOnAction(event -> textFieldB.setText(""));

    btnOK.setOnAction(event -> {
      if (textFieldB.getText().equals(textFieldA.getText())) {
        counterSmilyWrite += 1;
//        labelOKWrite.setText(":-) " + counterSmilyWrite);
        labelOKWrite.setText(labelOKWrite.getText() + ":-) ");
      } else {
        counterNotSmilyWrite += 1;
//        labelBadWrite.setText(":-( " + counterNotSmilyWrite);
        labelBadWrite.setText(labelBadWrite.getText() + ":-( ");
      }

      textFieldA.setText("");
      textFieldB.setText("");

      Collections.shuffle(words);
      textFieldA.setText(words.get(0));
    });

    buttonList = asList(btnA , btnB , btnC , btnD , btnE , btnF , btnG , btnH ,
                        btnI , btnJ , btnK , btnL , btnM , btnN , btnO , btnP , btnQ , btnR , btnS , btnT ,
                        btnU , btnV , btnW , btnX , btnY , btnZ ,
                        btnAE , btnOE , btnUE
    );

    buttonListK = asList(btnAk , btnBk , btnCk , btnDk , btnEk , btnFk , btnGk , btnHk ,
                         btnIk , btnJk , btnKk , btnLk , btnMk , btnNk , btnOk , btnPk , btnQk , btnRk , btnSk ,
                         btnTk , btnUk , btnVk , btnWk , btnXk , btnYk , btnZk ,
                         btnAe , btnOe , btnUe , btnSz
    );

    buttonList.forEach(b -> addButtonEventHandler(b , textFieldB));
    buttonListK.forEach(b -> addButtonEventHandler(b , textFieldB));

    //rechenaufgaben
    btnCalcPlus.setOnAction(event -> {
      String result = textFieldMatheBPlus.getText().trim();
      try {
        boolean smily = Integer.valueOf(result).equals(expectedResultPlus);
        checkResult(smily);
        initNextRechenaufgabePlus();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }

    });

    btnCalcMinus.setOnAction(event -> {
      String result = textFieldMatheBMinus.getText().trim();
      try {
        boolean smily = Integer.valueOf(result).equals(expectedResultMinus);
        checkResult(smily);
        initNextRechenaufgabeMinus();
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }

    });
    initNextRechenaufgabePlus();
    initNextRechenaufgabeMinus();


  }

  private void checkResult(final boolean smily) {
    if (smily) {
      counterSmilyCalc = counterSmilyCalc + 1;
      labelOKCalc.setText(labelOKCalc.getText() + ":-} ");
    } else {
      counterNotSmilyCalc = counterNotSmilyCalc + 1;
      labelBadCalc.setText(labelBadCalc.getText() + ":-{ ");
    }
  }

  private Random random = new Random();

  private void initNextRechenaufgabePlus() {
    int[] ints = random.ints(0 , 15).limit(2).toArray();
    expectedResultPlus = ints[0] + ints[1];
    textFieldMatheAPlus.setText(ints[0] + " + " + ints[1]);
    textFieldMatheBPlus.setText("");
  }

  private void initNextRechenaufgabeMinus() {
    int[] ints = new int[2];
    ints[0] = random.ints(1 , 25).limit(1).toArray()[0];
    ints[1] = random.ints(0 , ints[0]).limit(1).toArray()[0];
    expectedResultMinus = ints[0] - ints[1];
    textFieldMatheAMinus.setText(ints[0] + " - " + ints[1]);
    textFieldMatheBMinus.setText("");
  }

  private int expectedResultPlus = 0;
  private int expectedResultMinus = 0;

  private void addButtonEventHandler(Button btn , TextField tf) {
    btn.setOnAction(new ButtonEventHandler(btn , tf));
  }

  private static class ButtonEventHandler implements EventHandler<ActionEvent> {

    private Button btn;
    private TextField tf;

    public ButtonEventHandler(Button btn , TextField tf) {
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
