package project.planettrade;

import project.planettrade.types.ICommodity;

public class Cargo {
    private ICommodity commodity;
    private double amount;

    public Cargo(ICommodity commodity, double amount) {
        this.commodity = commodity;
        this.amount = amount;
    }

    public ICommodity getCommodity() {
        return commodity;
    }

    public double getAmount() {
        return amount;
    }
}
