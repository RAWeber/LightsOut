package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Background {
  
  public static float speed = 400;
  
  private static Background instance;
  
  private Texture background;
  private float offset;
  
  private Background(){
    background = GameApp.getAssetManager().get("Background.png", Texture.class);
    offset = 0;
  }

  public void render(){
    if(!Player.getInstance().isDead()){
      offset += Gdx.graphics.getDeltaTime() * speed;
      
      if(offset >= GameApp.WIDTH){
        offset = 0;
      }
    }
      
    GameApp.getSpritebatch().draw(background, -offset, 0);
    GameApp.getSpritebatch().draw(background, GameApp.WIDTH - offset, 0);
  }
  
  public static Background getInstance(){
    if(instance == null){
      instance = new Background();
    }
    return instance;
  }
  
  public static void clear(){
    instance = null;
  }
}
