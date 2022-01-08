package controllers;

import client.sceneloader.SceneLoaderInstance;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ActionClientController {

    @FXML
    private Button add;
    @FXML
    private Label name;

    public void initialize() {
        name.setText(LoginController.getClient());
    }

    public void addOrder() {
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("addorder", "Оформление заказа");
    }

    public void viewOrders() {
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("viewordersclient", "Просмотр заказов");
    }

    public void logOut() {
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("login", "Авторизация");
    }
    public void queryForALot() {
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("requestforaloan", "Одобрение кредита");
    }
    public void feedback() {
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("feedback", "Обратная связь");
    }
    public void toSell(){
        add.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("tosellcar", "Продажа автомобиля");
    }
}