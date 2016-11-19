package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.utilities.Animator;

public class Obstacle {

  private Rectangle hitbox;
  private Texture texture;
  private boolean offScreen;
  private boolean impaled;
  private Animator animator;
  
  public Obstacle(String name, Rectangle hitbox){
    this.hitbox = hitbox;
    texture = GameApp.getAssetManager().get(name + ".png", Texture.class);
    offScreen = false;
    impaled = false;
  }
  
  public void render(){
    if(!Player.getInstance().isDead()){
      hitbox.setX(hitbox.x - Background.speed * Gdx.graphics.getDeltaTime());
      
      if(hitbox.x < -160){
        offScreen = true;
      }
    }
    if(!impaled){
      GameApp.getSpritebatch().draw(texture, hitbox.x + 40, hitbox.y + 40);
    }
    else{
      animator.render();
    }
  }
  
  public boolean isOffScreen(){
    return offScreen;
  }
  
  public boolean checkCollision(Rectangle rect){
    if(hitbox.overlaps(rect)){
      animator = new Animator("Bloody Spike.png", hitbox.getPosition(new Vector2()).add(new Vector2(40, 40)), 2, 3, 12, false);
      impaled = true;
    }
    return hitbox.overlaps(rect);
  }
}
