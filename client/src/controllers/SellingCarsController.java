package controllers;

import client.AlertBox;
import client.ClientInstance;
import client.Order;
import client.sceneloader.SceneLoaderInstance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SellingCarsController {

    @FXML
    private TableView<Order> sellcarTable;
    @FXML
    private TableColumn<Order, String> makeColumn;
    @FXML
    private TableColumn<Order, String> modelColumn;
    @FXML
    private TableColumn<Order, String> yearColumn;
    @FXML
    private TableColumn<Order, Integer> priceColumn;
    @FXML
    private TableColumn<Order, String> TypeOfBodyColumn;
    @FXML
    private TableColumn<Order, Integer> numberColumn;
    public void initialize() {
        fillTableView();
    }

    public void fillTableView() {
        ClientInstance.INSTANCE.getInstance().send("getsellcars ");
        ArrayList<String> list = ClientInstance.INSTANCE.getInstance().receiveResultList();
        ObservableList<Order> orders = FXCollections.observableArrayList();
        String[] orderString;
        for (String s : list) {
            orderString = s.split(" ", 6);
            Order order = new Order();
            order.setNumberColumn(Integer.parseInt(orderString[0]));
            order.setMake(orderString[1]);
            order.setModel(orderString[2]);
            order.setYear(orderString[3]);
            order.setPrice(Integer.parseInt(orderString[4]));
            order.setTypeOfBody(orderString[5]);
            orders.add(order);
        }
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberColumn"));
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        TypeOfBodyColumn.setCellValueFactory(new PropertyValueFactory<>("TypeOfBody"));
        sellcarTable.setItems(orders);
    }

    public void DeleteCar() {
        if (sellcarTable.getSelectionModel().getSelectedItem() == null) {
            AlertBox.display("Выберите заказ");
        } else {
            ClientInstance.INSTANCE.getInstance().send("removeSellCars " +
                    sellcarTable.getSelectionModel().getSelectedItem().getNumberColumn());
            if (ClientInstance.INSTANCE.getInstance().receiveResultBool()) {
                fillTableView();
                AlertBox.display("Заказ одобрен");
            } else {
                AlertBox.display("Ошибка");
            }
        }
    }

    public void goBack() {
        sellcarTable.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("actionmanager", "Меню менеджера");
    }
}
