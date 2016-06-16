package com.dev.web.extr.test;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Sabbagh
 */
public class SampleController implements Initializable {
    
    @FXML private TextField firstname;
    @FXML private TextField lastname;
    @FXML private Button search;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // ...
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search.disableProperty().bind(
        firstname.textProperty().isEmpty()
        .or(
        lastname.textProperty().isEmpty()
        ));
    }
}