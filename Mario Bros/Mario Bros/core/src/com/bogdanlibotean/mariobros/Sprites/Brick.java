package com.bogdanlibotean.mariobros.Sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.World;
import com.bogdanlibotean.mariobros.MarioBros;
import com.bogdanlibotean.mariobros.Scenes.Hud;

/**
 * Created by Owner on 2016-11-20.
 */

public class Brick extends InteractivetileObject {
    public Brick(World world, TiledMap map, Rectangle bounds) {
        super(world, map, bounds);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);

    }

    @Override
    public void onHeadHit() {
        Gdx.app.log("Brick", "Colission");
        setCategoryFilter(MarioBros.DESTROYED_BIT);
        getCell().setTile(null);
        Hud.addScore(200);
    }
}
