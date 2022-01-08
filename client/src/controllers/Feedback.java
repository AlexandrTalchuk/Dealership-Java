package controllers;

import client.sceneloader.SceneLoaderInstance;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class Feedback {

    @FXML
    private ChoiceBox<String> make;


    public void goBack() {
        make.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("actionclient", "Обратная связь");
    }
}
