package project.planettrade;

import project.planettrade.generators.CommodityGenerator;
import project.planettrade.types.ICommodity;
import project.planettrade.types.IMarket;

import java.util.List;

public class Market implements IMarket {
    private CommodityGenerator generator;
    private List<ICommodity> commodities;
    private int MAX_COMMODITIES = 5;
    public Market(CommodityGenerator generator) {
        this.generator = generator;
        this.generateCommodities();
    }
    public void generateCommodities() {
        for (int i = 0; i < MAX_COMMODITIES; i++) {
            this.commodities.add(generator.generateCommodity());
        }
    }
}
