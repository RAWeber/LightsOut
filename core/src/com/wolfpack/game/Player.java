package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.utilities.Animator;

public class Player {
  
  private static Player instance;

  private Rectangle hitbox;
  private Animator animation;

  private float originalY;
  private float jump;
  private boolean dead;
  private boolean offScreen;

  private Player() {
    this.hitbox = new Rectangle(100, 100, 100, 200);

    originalY = hitbox.y;
    jump = 0;
    animation = new Animator("Protagonist V1.png", hitbox.getCenter(new Vector2()), 2, 1, 4);
    dead = false;
    offScreen = false;
  }

  public void render() {

    if(!dead){
      if (jump == 0) {
        if (hitbox.y > originalY){
          hitbox.setY(hitbox.y - Gdx.graphics.getDeltaTime() * 600);
          if(hitbox.y < originalY){
            hitbox.setY(originalY);
          }
        }
        else if (Gdx.input.justTouched()) {
          jump = 200;
        }
      }
      
      if(jump > 0){
        float jumpTemp = Gdx.graphics.getDeltaTime() * 600;
        hitbox.setY(hitbox.y + jumpTemp);
        jump -= jumpTemp;
        if(jump < 0){
          jump = 0;
        }
      }
      
      for(Obstacle o : ObstacleSpawner.getInstance().getObstacles()){
        if(o != null && o.checkCollision(hitbox)){
          dead = true;
          animation = new Animator("angel.png", hitbox.getCenter(new Vector2()), 2, 3, 4);
        }
      }
    }
    else{
      hitbox.setY(hitbox.y + Gdx.graphics.getDeltaTime() * 400);
      if(hitbox.y > GameApp.HEIGHT){
        offScreen = true;
      }
    }
    animation.setPosition(hitbox.getPosition(new Vector2()));
    animation.render();
  }
  
  public boolean isDead(){
    return dead;
  }
  
  public boolean isOffScreen(){
    return offScreen;
  }
  
  public static Player getInstance(){
    if(instance == null){
      instance = new Player();
    }
    return instance;
  }
  
  public static void clear(){
    instance = null;
  }
}
