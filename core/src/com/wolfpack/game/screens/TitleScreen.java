package com.wolfpack.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.wolfpack.game.GameApp;

public class TitleScreen implements Screen {

  private final GameApp game;
  private OrthographicCamera camera;

  private BitmapFont font;
  private String titleText;
  private String startText;
  private float titleWidth;
  private float titleHeight;
  private float startWidth;

  /**
   * Constructor for TitleScreen.
   * 
   * @param game Reference to GameApp
   */
  public TitleScreen(GameApp game) {
    this.game = game;

    camera = new OrthographicCamera();
    camera.setToOrtho(false, 1280, 720);

    font = new BitmapFont();
    font.getData().setScale(1.5f);
    titleText = "Welcome to Lights Out!!!";
    startText = "Click the screen to begin";

    GlyphLayout layout = new GlyphLayout();
    layout.setText(font, titleText);
    titleWidth = layout.width;
    titleHeight = layout.height;

    layout.setText(font, startText);
    startWidth = layout.width;

  }

  @Override
  public void show() {
    // Unsupported at this time
  }

  @Override
  public void render(float delta) {
    
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    camera.update();
    GameApp.getSpritebatch().setProjectionMatrix(camera.combined);
    
    GameApp.getSpritebatch().begin();
    font.draw(GameApp.getSpritebatch(), titleText, camera.viewportWidth / 2 - titleWidth / 2,
        camera.viewportHeight / 2 + titleHeight / 2 + 5);
    font.draw(GameApp.getSpritebatch(), startText, camera.viewportWidth / 2 - startWidth / 2,
        camera.viewportHeight / 2 - titleHeight / 2 - 5);
    GameApp.getSpritebatch().end();
    
    if (Gdx.input.justTouched()) {
      game.setScreen(new GameScreen(game));
      dispose();
    }
  }

  @Override
  public void resize(int width, int height) {
    // Unsupported at this time
  }

  @Override
  public void pause() {
    // Unsupported at this time
  }

  @Override
  public void resume() {
    // Unsupported at this time
  }

  @Override
  public void hide() {
    // Unsupported at this time
  }

  @Override
  public void dispose() {
    // Unsupported at this time
  }
}

