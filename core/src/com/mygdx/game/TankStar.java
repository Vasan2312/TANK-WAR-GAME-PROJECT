package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TankStar extends Game {

	static int flag = 0;
	static int player_1_tank = 1;
	static int player_2_tank = 1;
	public static final int WIDTH=1161;
	public static final int HEIGHT=536;
	public static final float Pixel=100;

	static SpriteBatch batch,batch2;


	@Override
	public void create () {
		batch = new SpriteBatch();
		batch2 = new SpriteBatch();
		setScreen(new EntryScreen(this));
	}
	@Override
	public void render () {
		super.render();

	}

	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		batch2.dispose();
	}
}