package org.example;

public class Main {
    public static void main(String[] args) {
        SolarSystem mercury = SolarSystem.MERCURY;
        System.out.println("Planet: Mercury");
        System.out.println("Distance from Sun: " + mercury.getDistanceFromSun() + " km");
        System.out.println("Distance from Previous Planet: " + mercury.getDistanceFromPreviousPlanet() + " km");
        System.out.println("Radius: " + mercury.getRadius() + " km");
        System.out.println("Previous Planet: " + (mercury.getPreviousPlanet() != null ? mercury.getPreviousPlanet().name() : "None"));
        System.out.println("Next Planet: " + (mercury.getNextPlanet() != null ? mercury.getNextPlanet().name() : "None"));
    }
}

   enum SolarSystem {
    MERCURY(0, 2439, null),
    VENUS(57_910_000, 6051, MERCURY),
    EARTH(108_200_000, 6371, VENUS),
    MARS(227_940_000, 3389, EARTH),
    JUPITER(778_330_000, 69_911, MARS),
    SATURN(1_426_610_000, 58_232, JUPITER),
    URANUS(2_870_990_000, 25_362, SATURN),
    NEPTUNE(4_498_250_000, 24_622, URANUS);

   private int distanceFromSun;
    private int distanceFromPreviousPlanet;
    private int radius;
    private SolarSystem previousPlanet;
    private SolarSystem nextPlanet;

    SolarSystem(int prevDistance, int radius, SolarSystem previous) {
        this.distanceFromPreviousPlanet = prevDistance;
        this.radius = radius;
        this.previousPlanet = previous;

        if (previous != null) {
            previous.nextPlanet = this;
            this.distanceFromSun = previous.distanceFromSun + prevDistance;
        } else {
            this.distanceFromSun = 0;
        }
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getDistanceFromPreviousPlanet() {
        return distanceFromPreviousPlanet;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPreviousPlanet() {
        return previousPlanet;
    }

    public SolarSystem getNextPlanet() {
        return nextPlanet;
    }
}
