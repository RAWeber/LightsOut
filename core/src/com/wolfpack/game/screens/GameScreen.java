package com.wolfpack.game.screens;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.wolfpack.game.Background;
import com.wolfpack.game.GameApp;
import com.wolfpack.game.Player;

public class GameScreen implements Screen {

  private final GameApp game;
  private OrthographicCamera camera;
  private Player player;
  private Background background;
  
  private int score;
  private float scoreWidth;
  private float scoreHeight;
  private String scoreText;
  private long startTime;
  private long endTime; 
  
  private BitmapFont font;
  public GameScreen(GameApp game) {
    this.game = game;

    font = new BitmapFont();
    font.getData().setScale(1.5f);
    scoreText =  "";
    camera = new OrthographicCamera();
    camera.setToOrtho(false, 1280, 720);
    
    player = new Player(new Rectangle(100, 100, 100, 200), 10);
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
    
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    endTime = System.currentTimeMillis();
    score = (int)((endTime - startTime)/100);
    scoreText = "Score: " + score;
    GlyphLayout layout = new GlyphLayout();
    layout.setText(font, scoreText);
    scoreWidth = layout.width;
    scoreHeight = layout.height;
    
    camera.update();
    GameApp.getSpritebatch().setProjectionMatrix(camera.combined);
    
 
    GameApp.getSpritebatch().begin();
    
    
    background.render();
    player.render();
    font.draw(GameApp.getSpritebatch(), scoreText, camera.viewportWidth / 2 - scoreWidth / 2,
    		 scoreHeight / 2 + 20);
    GameApp.getSpritebatch().end();
    
    if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
    {
    	
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
