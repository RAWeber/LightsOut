package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.utilities.Animator;

public class Player {

  private Rectangle hitbox;
  private Animator animation;

  private float originalY;
  private float jump;
  private boolean dead;

  public Player(Rectangle hitbox, float speed) {
    this.hitbox = hitbox;

    originalY = hitbox.y;
    jump = 0;
    animation = new Animator("Protagonist V1.png", hitbox.getCenter(new Vector2()), 2, 1, 4);
    dead = false;
  }

  public void render() {

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
    
    animation.setPosition(hitbox.getPosition(new Vector2()));
    animation.render();
    
    for(Obstacle o : ObstacleSpawner.getInstance().getObstacles()){
      if(o != null && o.checkCollision(hitbox)){
        dead = true;
        ObstacleSpawner.clear();
      }
    }
  }
  
  public boolean isDead(){
    return dead;
  }
}
