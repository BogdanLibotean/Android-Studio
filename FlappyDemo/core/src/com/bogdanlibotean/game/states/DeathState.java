package com.bogdanlibotean.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.bogdanlibotean.game.FlappyDemo;

/**
 * Created by Owner on 2016-11-16.
 */

public class DeathState extends State {
    private Texture end;
    private Texture background;
    private Texture ground;


    public DeathState(GameStateManager gsm) {
        super(gsm);
        end = new Texture("end.png");
        ground = new Texture("ground.png");
        background = new Texture("bg2.png");
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGTH / 2);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch ab) {
        ab.setProjectionMatrix(cam.combined);
        ab.begin();
        ab.draw(background, 0, 0);
        ab.draw(end, cam.position.x - end.getWidth() / 2, cam.position.y);
        ab.draw(ground, cam.position.x - ground.getWidth() / 2 ,  0);
        ab.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        end.dispose();
        System.out.println("Death State Disposed");
    }
}
