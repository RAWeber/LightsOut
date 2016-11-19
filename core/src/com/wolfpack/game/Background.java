package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Background {
  
  public static float speed = 400;
  
  private Texture background;
  private float offset;
  
  public Background(){
    background = GameApp.getAssetManager().get("Background.png", Texture.class);
    offset = 0;
  }

  public void render(){
    offset += Gdx.graphics.getDeltaTime() * speed;
    
    if(offset >= GameApp.WIDTH){
      offset = 0;
    }
      
    GameApp.getSpritebatch().draw(background, -offset, 0);
    GameApp.getSpritebatch().draw(background, GameApp.WIDTH - offset, 0);
  }
}
