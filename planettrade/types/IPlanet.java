package project.planettrade.types;

public interface IPlanet {
    IMarket getMarket();
    double getDistanceTo(IPlanet planet);

    int getX();

    int getY();

    double getParkingPrice();

    double getFuelPrice();
}
