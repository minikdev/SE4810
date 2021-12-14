package project.planettrade;

import project.planettrade.types.ICommodity;

public enum Commodity implements ICommodity {
    WATERMELON(0.04,8),
    LEMON(0.21,3),
    STRAWBERRY(0.30,2),
    APPLE(0.10,4),
    ORANGE(0.08,4),
    BANANA(0.18,3),
    GRAPE(0.23,4);

    private double buyPrice;
    private double sellPrice;
    private double amount;
    private double volume;
    private final double decayRatio;

     Commodity(double decayRatio,double volume) {
        this.decayRatio = decayRatio;
        this.volume = volume;
    }

    public double getDecayRatio() {
        return decayRatio;
    }



    @Override
    public void setSellPrice(double sellPrice) {
         this.sellPrice = sellPrice;
    }

    @Override
    public void setBuyPrice(double buyPrice) {
         this.buyPrice = buyPrice;
    }

    @Override
    public double getPrice() {
        return buyPrice;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }

    @Override
    public void setAmount(double v) {
    this.amount = v;
    }

    public double getVolume() {
        return volume;
    }

}
