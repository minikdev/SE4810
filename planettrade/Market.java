package project.planettrade;

import project.planettrade.generators.CommodityGenerator;
import project.planettrade.types.ICommodity;
import project.planettrade.types.IMarket;

import java.util.ArrayList;
import java.util.List;

public class Market implements IMarket {
    private CommodityGenerator generator;
    private List<ICommodity> commodities;
    private int MAX_COMMODITIES = 5;

    public Market(CommodityGenerator generator) {
        this.generator = generator;
        this.commodities = new ArrayList<>();
        this.generateCommodities();
    }

    public void generateCommodities() {
        for (int i = 0; i < MAX_COMMODITIES; i++) {
            this.commodities.add(generator.generateCommodity());
        }
    }

    @Override
    public List<ICommodity> getCommodities() {
        return this.commodities;
    }

    @Override
    public void updatePrices() {
        for (ICommodity c : this.commodities) {
            c.updatePrice();
        }
    }

    @Override
    public String toString() {
        String result = "Market: \n";
        for (ICommodity c : this.commodities) {
            result += " [" + c + ", BuyPrice:" + c.getPrice() + "," + " SellPrice:" + c.getPrice() + "Amount:" + c.getAmount() + "]";
        }


        return result;
    }
}
