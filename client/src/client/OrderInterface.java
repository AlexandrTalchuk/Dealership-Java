package client;

public interface OrderInterface {


    public void setNumberColumn(int numberColumn);

    public int getNumberColumn();

    public String getSupplier();

    public void setSupplier(String supplier);

    public int getQuantity();

    public void setQuantity(int quantity);

    public String getCountry();

    public void setCountry(String country);

    public void setTypeOfBody(String TypeOfBody);

    public void setEngineValue(int EngineValue);

    public String getTypeOfBody();

    public int getEngineOfValue();

    public String getInsurance();

    public void setInsurance(String insurance);

    public String getColor();

    public void setColor(String color);

    public boolean isOrderAccepted();

    public void setOrderAccepted(boolean orderAccepted);

    public boolean isOrderCompleted();

    public void setOrderCompleted(boolean orderCompleted);

    public int getPrice();

    public void setPrice(int price);

    public int getOrderNumber();

    public void setOrderNumber(int orderNumber);

    public String getMake();

    public void setMake(String make);

    public String getYear();

    public void setYear(String year);

    public String getModel();

    public void setModel(String model);

    public String getSurname();

    public void setSurname(String surname);

    public String getName();

    public void setName(String name);

    public String toString();

    public boolean equals(Object o);

    public int hashCode();
}