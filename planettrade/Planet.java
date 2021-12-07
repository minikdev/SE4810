package project.planettrade;

public enum Planet {
    PLANET1,PLANET2;

    private String name;
    Market market;
    private double unitPrice;
    private double parkingPrice;

    public static Planet getRandomPlanet() {
        return values()[(int) (Math.random() * values().length)];
    }
}
