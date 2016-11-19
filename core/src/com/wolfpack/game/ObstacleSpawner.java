package com.wolfpack.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class ObstacleSpawner {
  
  private static ObstacleSpawner instance;

  private Random rand;
  private float variance;
  private ArrayList<Obstacle> obstacles;
  private ArrayList<Obstacle> obstaclesToRemove;
  
  private float spawnDelay;
  private float currentTime;
  
  private ObstacleSpawner(){
    obstacles = new ArrayList<Obstacle>();
    obstaclesToRemove = new ArrayList<Obstacle>();
    rand = new Random();
    variance = 2;
    spawnDelay = 1.5f;
    currentTime = 0;
  }
  
  private void spawnObstacle(){
    obstacles.add(new Obstacle("Spike", new Rectangle(GameApp.WIDTH + 40, 40, 80, 80)));
  }
  
  public void render(){
    currentTime += Gdx.graphics.getDeltaTime();
    
    if(currentTime > spawnDelay + rand.nextFloat() * variance){
        spawnObstacle();
      currentTime = 0;
    }
    
    for(Obstacle o: obstacles){
      o.render();
      obstaclesToRemove.add(o);
    }
    obstacles.remove(obstaclesToRemove);
  }
  
  public static ObstacleSpawner getInstance(){
    if(instance == null){
      instance = new ObstacleSpawner();
    }
    return instance;
  }
  
  public static void clear(){
    instance = null;
  }
  
  public ArrayList<Obstacle> getObstacles(){
    return obstacles;
  }
}
