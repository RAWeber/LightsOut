package com.wolfpack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.wolfpack.game.Background;
import com.wolfpack.game.GameApp;
import com.wolfpack.game.ObstacleSpawner;
import com.wolfpack.game.Player;

public class GameScreen implements Screen {

  private final GameApp game;
  private OrthographicCamera camera;
  private Player player;
  private Background background;
  
  private int score;
  private long startTime;
  private long endTime; 

  public GameScreen(GameApp game) {
    this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 1280, 720);
    
    player = new Player(new Rectangle(100, 100, 100, 200), 20);
    background = new Background();
    score = 0;
    startTime = System.currentTimeMillis();
  }

  @Override
  public void show() {
    // TODO Auto-generated method stub

  }

  @Override
  public void render(float delta) {
    
    Gdx.gl.glClearColor(0.086f, 0.047f, 0.012f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    camera.update();
    GameApp.getSpritebatch().setProjectionMatrix(camera.combined);
    
    GameApp.getSpritebatch().begin();
    player.render();
    ObstacleSpawner.getInstance().render();
    background.render();

    GameApp.getSpritebatch().end();
    
    if(player.isDead())
    {
    	endTime = System.currentTimeMillis();
    	score = (int)((endTime - startTime)/10);
    	game.setScreen(new GameOverScreen(game,score));
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
