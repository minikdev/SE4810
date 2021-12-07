package project.planettrade;

public class Galaxy {
    private Planet[] planets;
    public Galaxy(){
        planets = new Planet[10];
        for(int i = 0; i < planets.length; i++){
            planets[i] = Planet.getRandomPlanet();
        }
    }
    public Planet[] getPlanets(){
        return planets;
    }
}
