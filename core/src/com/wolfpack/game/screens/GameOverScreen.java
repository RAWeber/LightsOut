package com.wolfpack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.GameApp;
import com.wolfpack.game.utilities.Animator;

public class GameOverScreen implements Screen {

  private final GameApp game;
  private OrthographicCamera camera;
  
  private int score;
  
  private Animator title;
  private Vector2 titlePosition;
  
  public GameOverScreen(GameApp game, int score) {
    this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 1280, 720);
    titlePosition = new Vector2(camera.viewportWidth / 2 - 320, camera.viewportHeight/2 - 320);
    title = new Animator("GameOver.png", titlePosition, 1, 2, 2);
    this.score = score;
  }
  
  @Override
  public void show() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void render(float delta) {
    
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    camera.update();
    GameApp.getSpritebatch().setProjectionMatrix(camera.combined);
    
    GameApp.getSpritebatch().begin();
    //Render in here
    title.render();
    GameApp.getSpritebatch().end();
    
    // Enter can be used to restart the game
    if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
      game.setScreen(new GameScreen(game));
      dispose();
    }
    
    // If the screen gets touched or clicked, restart the game
    if (Gdx.input.justTouched()) {
        game.setScreen(new GameScreen(game));
        dispose();
      }
  }

  @Override
  public void resize(int width, int height) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void pause() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void resume() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void hide() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    
  }

}
