package com.dev.web.extr;

import com.dev.web.extr.ui.BrowserController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Extractor extends Application {
    private BrowserController uiController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sspForm.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/BrowserForm.fxml"));
        Pane root = (Pane) loader.load();
                /*
                * Important: uiController must be get after loading FXML file*/
        uiController = loader.<BrowserController>getController();

        Stage stage = new Stage();
        stage.setTitle("Broswer");
        stage.setScene(new Scene(root /*,1075, 446, Color.LIGHTBLUE*/));
        stage.show();
    }
}
