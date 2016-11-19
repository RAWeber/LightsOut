package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Obstacle {

  private Rectangle hitbox;
  private Texture texture;
  
  public Obstacle(String name, Rectangle hitbox){
    this.hitbox = hitbox;
    texture = GameApp.getAssetManager().get(name + ".png", Texture.class);
  }
  
  public void render(){
    hitbox.setX(hitbox.x - Background.speed * Gdx.graphics.getDeltaTime());
    GameApp.getSpritebatch().draw(texture, hitbox.x, hitbox.y);
  }
}
