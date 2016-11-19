package com.wolfpack.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class ObstacleSpawner {
  
  private static ObstacleSpawner instance;

  private Random rand;
  private int spawnChance;
  private ArrayList<Obstacle> obstacles;
  
  private float spawnDelay;
  private float currentTime;
  
  private ObstacleSpawner(){
    obstacles = new ArrayList<Obstacle>();
    rand = new Random();
    spawnChance = 25;
    spawnDelay = 1000;
    currentTime = 0;
  }
  
  private void spawnObstacle(){
    obstacles.add(new Obstacle("Spike", new Rectangle()));
  }
  
  public void render(){
    currentTime += Gdx.graphics.getDeltaTime();
    
    if(currentTime > spawnDelay && rand.nextInt(100) > spawnChance){
      spawnObstacle();
      currentTime = 0;
    }
    
    for(Obstacle o: obstacles){
      o.render();
    }
  }
  
  public static ObstacleSpawner getInstance(){
    if(instance == null){
      instance = new ObstacleSpawner();
    }
    return instance;
  }
  
  public ArrayList<Obstacle> getObstacles(){
    return obstacles;
  }
  
  public void setSpawnChance(int spawnChance){
    this.spawnChance = spawnChance;
  }
  
  public int getSpawnChacne(){
    return spawnChance;
  }
}
