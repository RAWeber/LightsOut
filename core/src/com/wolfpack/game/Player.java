package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.utilities.Animator;

public class Player {

  private Rectangle hitbox;
  private float speed;
  private Animator animation;

  private float originalY;
  private float jump;

  public Player(Rectangle hitbox, float speed) {
    this.hitbox = hitbox;
    this.speed = speed;

    originalY = hitbox.y;
    jump = 0;
    animation = new Animator("Protagonist V1.png", hitbox.getCenter(new Vector2()), 2, 1, 4);
  }

  public void render() {

    if (jump == 0) {
      if (hitbox.y > originalY){
        hitbox.setY(hitbox.y - Gdx.graphics.getDeltaTime() * 800);
        if(hitbox.y < originalY){
          hitbox.setY(originalY);
        }
      }
      else if (Gdx.input.justTouched()) {
        jump = 100;
      }
    }
    
    if(jump > 0){
      float jumpTemp = Gdx.graphics.getDeltaTime() * 800;
      hitbox.setY(hitbox.y + jumpTemp);
      jump -= jumpTemp;
      if(jump < 0){
        jump = 0;
      }
    }
    hitbox.setX(hitbox.x + Gdx.graphics.getDeltaTime() * speed);
    animation.setPosition(hitbox.getPosition(new Vector2()));
    animation.render();
  }
}
