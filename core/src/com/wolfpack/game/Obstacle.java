package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {

  private Rectangle hitbox;
  private Texture texture;
  private boolean offScreen;
  
  public Obstacle(String name, Rectangle hitbox){
    this.hitbox = hitbox;
    texture = GameApp.getAssetManager().get(name + ".png", Texture.class);
    offScreen = false;
  }
  
  public void render(){
    hitbox.setX(hitbox.x - Background.speed * Gdx.graphics.getDeltaTime());
    if(hitbox.x < -160){
      offScreen = true;
    }
    GameApp.getSpritebatch().draw(texture, hitbox.x + 40, hitbox.y + 40);
  }
  
  public boolean isOffScreen(){
    return offScreen;
  }
  
  public boolean checkCollision(Rectangle rect){
    return hitbox.overlaps(rect);
  }
}
