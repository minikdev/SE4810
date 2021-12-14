package project.planettrade.types;

public interface ICommodity {

    void setSellPrice(double sellPrice);

    void setBuyPrice(double buyPrice);

    double getPrice();

    double getAmount();

    void setAmount(double amount);

    double getVolume();
}
