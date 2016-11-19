package com.wolfpack.game.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.wolfpack.game.GameApp;

public class Animator {

    private Vector2 position;
    private Animation walkAnimation;          
    private Texture walkSheet;             
    private TextureRegion[] walkFrames;                   
    private TextureRegion currentFrame;           
    private float stateTime;     
    
    public Animator(String imageName, Vector2 position, int cols, int rows, int frameRate)
    {
       
        this.position = position;

        walkSheet = GameApp.getAssetManager().get(imageName, Texture.class); 
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/cols, walkSheet.getHeight()/rows);              // #10
        walkFrames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(1.0f/frameRate, walkFrames);                     
        stateTime = 0f; 

    }
    public void setPosition(Vector2 position)
    {
    	this.position = position;
    }
  
    public void render() {
        stateTime += Gdx.graphics.getDeltaTime();        
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  
        GameApp.getSpritebatch().draw(currentFrame, position.x, position.y);             
     
    }
}