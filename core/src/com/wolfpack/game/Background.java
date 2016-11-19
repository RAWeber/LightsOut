package com.wolfpack.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.utilities.Animator;

public class Background {
  
  public static float speed = 400;
  
  private static Background instance;
  
  private Texture background;
  private Animator animator;
  private float offset;
  
  private Background(){
    background = GameApp.getAssetManager().get("Background.png", Texture.class);
    animator = new Animator("Darkness.png", new Vector2(0,0), 3, 5, 4);
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
    
    if(!Player.getInstance().isDead()){
      animator.render();
    }
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
