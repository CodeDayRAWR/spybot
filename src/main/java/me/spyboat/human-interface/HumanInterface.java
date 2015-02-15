package me.spyboat.human_interface;

import me.spyboat.interfaces.PlayerInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HumanInterface extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    primaryStage.setTitle("Spybot");
    primaryStage.show();
  }
}
