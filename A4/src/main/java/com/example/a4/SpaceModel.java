//Talha Mansoor
//kgy284
//11346490
//Assignment 4
package com.example.a4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceModel {
    private final List<Asteroid> asteroids = new ArrayList<>();
    private final List<Star> stars = new ArrayList<>();

    //construictor that creats stars
    public SpaceModel() {
        // Create 100 stars
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            stars.add(new Star(rand.nextDouble(), rand.nextDouble()));
        }
    }

    //create asteroid
    public void createAsteroid() {
        Random rand = new Random();
        // Create an asteroid with random position and a fixed radius
        asteroids.add(new Asteroid());
    }

    //list of asteroids
    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    //list of starts
    public List<Star> getStars() {
        return stars;
    }
    public void moveAsteroids() {
        for (Asteroid asteroid : asteroids) {
            asteroid.updatePosition();
        }
    }


    public void spinAsteroids() {
        for (Asteroid asteroid : asteroids) {
            asteroid.updateSpin();
        }
    }
}