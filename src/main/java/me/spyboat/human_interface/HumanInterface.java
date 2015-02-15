package me.spyboat.human_interface;

import me.spyboat.interfaces.PlayerInterface;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Random;

public class HumanInterface extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    AnchorPane pane = new AnchorPane();
    pane.setPrefSize(650, 420);
    pane.setId("pane");

    GridPane boardPane = new GridPane();

    Region[] cells = new Region[16*13];
    Rectangle[] floors = new Rectangle[16*13];
    Random r = new Random();
    for(int i=0;i<16*13;i++) {
      Region cell = new Region();
      cell.setPrefSize(32, 32);
      cell.getStyleClass().add("cell");
      if (r.nextBoolean()) {
        cell.getStyleClass().add("has-cell-floor");
      }
      boardPane.getChildren().add(cell);
      boardPane.setConstraints(cell, i % 16, i / 16);
      cells[i] = cell;
    }

    List<ColumnConstraints> boardPaneColumnConstraints =
      boardPane.getColumnConstraints();
    ColumnConstraints fixedSizeColumn = new ColumnConstraints(32);
    for(int i=0;i<16;i++) {
      boardPaneColumnConstraints.add(fixedSizeColumn);
    }

    List<RowConstraints> boardPaneRowConstraints =
      boardPane.getRowConstraints();
    RowConstraints fixedSizeRow = new RowConstraints(32);
    for(int i=0;i<13;i++) {
      boardPaneRowConstraints.add(fixedSizeRow);
    }

    pane.getChildren().add(boardPane);
    pane.setTopAnchor(boardPane, 2.0);
    pane.setLeftAnchor(boardPane, 136.0);

    Scene scene = new Scene(pane);
    scene.getStylesheets().add(
    HumanInterface.class.getResource("human-interface.css").toExternalForm());

    primaryStage.setTitle("Spybot");
    primaryStage.setScene(scene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }
}
