package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Background {
  
  public static float speed = 400;
  
  private Texture background;
  private float offset;
  private float height;
  private float width;
  
  public Background(){
    background = GameApp.getAssetManager().get("Background.png", Texture.class);
    offset = 0;
    height = Gdx.graphics.getHeight();
    width = Gdx.graphics.getWidth();
  }

  public void render(){
    offset += Gdx.graphics.getDeltaTime() * speed;
    
    if(offset >= width){
      offset = 0;
    }
      
    GameApp.getSpritebatch().draw(background, -offset, 0);
    GameApp.getSpritebatch().draw(background, width - offset, 0);
  }
}
