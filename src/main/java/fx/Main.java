package fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fx.main.MainPane;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    MainPane root = new MainPane();
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 1024,500));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
