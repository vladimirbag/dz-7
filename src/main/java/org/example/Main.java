package org.example;

public class Main {
    public static void main(String[] args) {
        SolarSystem earth = SolarSystem.EARTH;
        System.out.println("Planet: " + earth.name());
        System.out.println("Ordinal from Sun: " + earth.getOrdinalFromSun());
        System.out.println("Distance from previous planet: " + earth.getDistanceFromPrevious());
        System.out.println("Distance from Sun: " + earth.getDistanceFromSun());
        System.out.println("Radius: " + earth.getRadius());
        System.out.println("Previous planet: " + earth.getPreviousPlanet());
        System.out.println("Next planet: " + earth.getNextPlanet());
    }

    enum SolarSystem {
        MERCURY(0, 0, 2439.7, null),
        VENUS(2, 108.2, 6051.8, MERCURY),
        EARTH(3, 47.5, 6371.0, VENUS),
        MARS(4, 52.9, 3389.5, EARTH),
        JUPITER(5, 228.0, 69911, MARS),
        SATURN(6, 433.0, 58232, JUPITER),
        URANUS(7, 579.0, 25362, SATURN),
        NEPTUNE(8, 449.8, 24622, URANUS),
        PLUTO(9, 5906.4, 1188.3, NEPTUNE);

        private final int ordinalFromSun;
        private final double distanceFromPrevious;
        private final double distanceFromSun;
        private final double radius;
        private final SolarSystem previousPlanet;
        private final SolarSystem nextPlanet;

        SolarSystem(int ordinalFromSun, double distanceFromPrevious, double radius, SolarSystem previousPlanet) {
            this.ordinalFromSun = ordinalFromSun;
            this.distanceFromPrevious = distanceFromPrevious;
            this.radius = radius;
            this.previousPlanet = previousPlanet;
            this.nextPlanet = getNextPlanet(ordinalFromSun);
            this.distanceFromSun = calculateDistanceFromSun();
        }

        public int getOrdinalFromSun() {
            return ordinalFromSun;
        }

        public double getDistanceFromPrevious() {
            return distanceFromPrevious;
        }

        public double getDistanceFromSun() {
            return distanceFromSun;
        }

        public double getRadius() {
            return radius;
        }

        public SolarSystem getPreviousPlanet() {
            return previousPlanet;
        }

        public SolarSystem getNextPlanet() {
            return nextPlanet;
        }

        private double calculateDistanceFromSun() {
            if (previousPlanet != null) {
                return previousPlanet.getDistanceFromSun() + distanceFromPrevious;
            } else {
                return 0;
            }
        }

        private SolarSystem getNextPlanet(int ordinal) {
            SolarSystem[] planets = SolarSystem.values();
            if (ordinal < planets.length - 1) {
                return planets[ordinal + 1];
            } else {
                return null;
            }
        }
    }
}
