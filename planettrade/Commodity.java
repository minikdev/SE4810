package project.planettrade;

import project.planettrade.types.ICommodity;

public enum Commodity implements ICommodity {
    WATERMELON(0.04),
    LEMON(0.21),
    STRAWBERRY(0.30),
    APPLE(0.10),
    ORANGE(0.08),
    BANANA(0.18),
    GRAPE(0.23);

    private double buyPrice;
    private double sellPrice;
    private int amount;
    // TODO: add volume
    private final double decayRatio;

     Commodity(double decayRatio) {
        this.decayRatio = decayRatio;
    }

    public double getDecayRatio() {
        return decayRatio;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void setSellPrice(double sellPrice) {
         this.sellPrice = sellPrice;
    }

    @Override
    public void setBuyPrice(double buyPrice) {
         this.buyPrice = buyPrice;
    }
}
