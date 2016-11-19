package com.wolfpack.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.wolfpack.game.screens.LoadScreen;

public class GameApp extends Game {
  private static SpriteBatch batch;
  private static AssetManager manager;

  @Override
  public void create() {
    manager = new AssetManager();
    batch = new SpriteBatch();
    manager.load("Flame.png", Texture.class);
    manager.load("Bloody Spike.png", Texture.class);

    this.setScreen(new LoadScreen(this));
  }

  @Override
  public void render() {
    super.render();
    manager.update();
  }

  @Override
  public void dispose() {
    batch.dispose();
    manager.dispose();
  }

  public static SpriteBatch getSpritebatch() {
    return batch;
  }
  
  public static AssetManager getAssetManager() {
    return manager;
  }
}

