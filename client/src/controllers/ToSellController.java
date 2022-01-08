package controllers;

import client.AlertBox;
import client.ClientInstance;
import client.sceneloader.SceneLoaderInstance;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ToSellController {
    @FXML
    public TextField make;
    @FXML
    private TextField model;
    @FXML
    public TextField price;
    @FXML
    private TextField year;
    @FXML
    public TextField TypeOfBody;


    public void addsellCar() {

        if (make.getText().equals("") || price.getText().equals("")|| model.getText().equals("")|| year.getText().equals("")
                || TypeOfBody.getText().equals("")) {
            AlertBox.display("Введите все данные");
            return;
        }
        ClientInstance.INSTANCE.getInstance().send("addsellcars " + make.getText() + " " + model.getText()
                + " " + year.getText() + " " + price.getText()+ " " + TypeOfBody.getText());
        if (ClientInstance.INSTANCE.getInstance().receiveResultBool()) {
            AlertBox.display("Запрос отправлен успешно");
        } else {
            AlertBox.display("Ошибка добавления запроса");
        }
    }

    public void goBack() {
        make.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("actionclient", "Меню клиента");
    }
}
