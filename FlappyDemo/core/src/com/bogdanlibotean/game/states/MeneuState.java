package com.bogdanlibotean.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bogdanlibotean.game.FlappyDemo;


/**
 * Created by Owner on 2016-11-15.
 */

public class MeneuState extends State {
    private Texture background;
    private Texture playBtn;
    private Texture name;

    public MeneuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGTH / 2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
        name = new Texture("name.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
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
        ab.draw(background, 0,0);
        ab.draw(playBtn, cam.position.x - playBtn.getWidth() / 2, cam.position.y);
        ab.draw(name, cam.position.x - name.getWidth() / 2 ,  1);
        ab.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Meneu State Disposed");
    }
}
