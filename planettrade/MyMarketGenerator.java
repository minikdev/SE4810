package project.planettrade;

import project.planettrade.generators.MarketGenerator;
import project.planettrade.types.IMarket;


public class MyMarketGenerator implements MarketGenerator {
    @Override
    public IMarket generateMarket() {
        return new Market(new MyCommodityGenerator());
    }
}
