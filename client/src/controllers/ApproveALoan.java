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
import java.util.ArrayList;

public class ApproveALoan {
    @FXML
    private TableView<Order> loanTable;
    @FXML
    private TableColumn<Order, String> makeColumn;
    @FXML
    private TableColumn<Order, String> modelColumn;
    @FXML
    private TableColumn<Order, String> yearColumn;
    @FXML
    private TableColumn<Order, Integer> priceColumn;
    @FXML
    private TableColumn<Order, String> colorColumn;
    @FXML
    private TableColumn<Order, String> countryColumn;
    @FXML
    private TableColumn<Order, String> insuranceColumn;
    @FXML
    private TableColumn<Order, String> amount;
    @FXML
    private TableColumn<Order, Integer> numberOfYears;
    @FXML
    private TableColumn<Order, Integer> percentages;
    @FXML
    private TableColumn<Order, String> nameColumn;
    @FXML
    private TableColumn<Order, String> surnameColumn;
    @FXML
    private TableColumn<Order, Integer> numberColumn;

    public void initialize() {
        fillTableView();

    }


    private void fillTableView() {
        ClientInstance.INSTANCE.getInstance().send("getaLoan " + LoginController.getManager());
        ArrayList<String> list = ClientInstance.INSTANCE.getInstance().receiveResultList();
        ObservableList<Order> orders = FXCollections.observableArrayList();
        String[] orderString;
        for (String s : list) {
            orderString = s.split(" ", 15);
            Order order = new Order();
            order.setNumberColumn(Integer.parseInt(orderString[0]));
            order.setName(orderString[1]);
            order.setSurname(orderString[2]);
            order.setMake(orderString[3]);
            order.setModel(orderString[11]);
            order.setYear(orderString[4]);
            order.setPrice(Integer.parseInt(orderString[5]));
            order.setColor(orderString[6]);
            order.setCountry(orderString[7]);
            order.setInsurance(orderString[8] + " " + orderString[9] + " " + orderString[10]);
            order.setAmount(orderString[11]);
            order.setModel(orderString[14]);
            order.setNumberOfYears(Integer.parseInt(orderString[13]));
            order.setPercentages(Integer.parseInt(orderString[12]));
            orders.add(order);
        }
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        insuranceColumn.setCellValueFactory(new PropertyValueFactory<>("insurance"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("numberColumn"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        numberOfYears.setCellValueFactory(new PropertyValueFactory<>("numberOfYears"));
        percentages.setCellValueFactory(new PropertyValueFactory<>("percentages"));
        loanTable.setItems(orders);
    }


    public void deleteOrder() {
        if (loanTable.getSelectionModel().getSelectedItem() == null) {
            AlertBox.display("Выберите поле");
        } else {
            ClientInstance.INSTANCE.getInstance().send("removeloan " +
                    loanTable.getSelectionModel().getSelectedItem().getNumberColumn());
            if (ClientInstance.INSTANCE.getInstance().receiveResultBool()) {
                fillTableView();
                AlertBox.display("Кредит одобрен");
            } else {
                AlertBox.display("Ошибка");
            }
        }
    }

    public void goBack() {
        loanTable.getScene().getWindow().hide();
        SceneLoaderInstance.INSTANCE.getInstance().loadScene("actionmanager", "Меню менеджера");
    }
}
