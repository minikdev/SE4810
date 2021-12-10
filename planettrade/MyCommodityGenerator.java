package project.planettrade;

import project.planettrade.generators.CommodityGenerator;
import project.planettrade.types.ICommodity;

public class MyCommodityGenerator implements CommodityGenerator {
    private final int MAX_AMOUNT_OF_COMMODITY = 50;
    private final int MIN_AMOUNT_OF_COMMODITY = 0;

    private final int MAX_BUY_PRICE = 20;
    private final int MIN_BUY_PRICE = 1;

    private final int MAX_SELL_PRICE = 20;
    private final int MIN_SELL_PRICE = 1;
    @Override
    public ICommodity generateCommodity() {
        double buyPrice = (Math.random() * (MAX_BUY_PRICE - MIN_BUY_PRICE) + MIN_BUY_PRICE);
        double sellPrice = (Math.random() * (MAX_SELL_PRICE - MIN_SELL_PRICE) + MIN_SELL_PRICE);
        int amount = (int) (Math.random() * (MAX_AMOUNT_OF_COMMODITY - MIN_AMOUNT_OF_COMMODITY) + MIN_AMOUNT_OF_COMMODITY);

        ICommodity commodity = Commodity.values()[(int) (Math.random() * Commodity.values().length)];
        commodity.setBuyPrice( buyPrice);
        commodity.setSellPrice(sellPrice);
        commodity.setAmount(amount);
        return commodity;
    }
}
