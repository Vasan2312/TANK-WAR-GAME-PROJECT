package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MenuOnGameScreen implements Screen {

	public TankStar getGame() {
		return game;
	}

	public void setGame(TankStar game) {
		this.game = game;
	}

	public Texture getImg_entry_screen() {
		return img_entry_screen;
	}

	public void setImg_entry_screen(Texture img_entry_screen) {
		this.img_entry_screen = img_entry_screen;
	}

	public Sprite getSprite_entry_button() {
		return sprite_entry_button;
	}

	public void setSprite_entry_button(Sprite sprite_entry_button) {
		this.sprite_entry_button = sprite_entry_button;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public TextButton getTextButton() {
		return textButton;
	}

	public void setTextButton(TextButton textButton) {
		this.textButton = textButton;
	}

	public Texture getButtonTexture() {
		return buttonTexture;
	}

	public void setButtonTexture(Texture buttonTexture) {
		this.buttonTexture = buttonTexture;
	}

	public Texture getButtonTexture1() {
		return buttonTexture1;
	}

	public void setButtonTexture1(Texture buttonTexture1) {
		this.buttonTexture1 = buttonTexture1;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public Drawable getDrawable1() {
		return drawable1;
	}

	public void setDrawable1(Drawable drawable1) {
		this.drawable1 = drawable1;
	}

	public ImageButton getImageButton() {
		return imageButton;
	}

	public void setImageButton(ImageButton imageButton) {
		this.imageButton = imageButton;
	}

	public ImageButton getImageButton1() {
		return imageButton1;
	}

	public void setImageButton1(ImageButton imageButton1) {
		this.imageButton1 = imageButton1;
	}

	public static Texture getTankpic1() {
		return tankpic1;
	}

	public static void setTankpic1(Texture tankpic1) {
		MenuOnGameScreen.tankpic1 = tankpic1;
	}

	public static Texture getTankpic2() {
		return tankpic2;
	}

	public static void setTankpic2(Texture tankpic2) {
		MenuOnGameScreen.tankpic2 = tankpic2;
	}

	public static int getSave_x1() {
		return save_x1;
	}

	public static void setSave_x1(int save_x1) {
		MenuOnGameScreen.save_x1 = save_x1;
	}

	public static int getSave_y1() {
		return save_y1;
	}

	public static void setSave_y1(int save_y1) {
		MenuOnGameScreen.save_y1 = save_y1;
	}

	public static int getFuel_inT1() {
		return fuel_inT1;
	}

	public static void setFuel_inT1(int fuel_inT1) {
		MenuOnGameScreen.fuel_inT1 = fuel_inT1;
	}

	private TankStar game;
	private Texture img_entry_screen;
	private Sprite sprite_entry_button;
	private Stage stage;
	private Skin skin;
	private TextButton textButton;
	private Texture buttonTexture,buttonTexture1,buttonTexture3;
	private Drawable drawable,drawable1,drawable3;
	private ImageButton imageButton,imageButton1,imageButton3;

	public static Texture tankpic1, tankpic2;
	public static int save_x1, save_y1, fuel_inT1, save_x2, save_y2, fuel_inT2, health1, health2;

	public static float angle1,angle2;

	MenuOnGameScreen(TankStar game, Texture tankpicture1, Texture tankpicture2, int tank_x1, int tank_y1, int fuel_in1, int tank_x2, int tank_y2, int fuel_in2, int health11, int health22, float angle11, float angle22){
		this.game=game;
		save_x1=tank_x1;
		save_y1=tank_y1;
		fuel_inT1=fuel_in1;
		save_x2=tank_x2;
		save_y2=tank_y2;
		fuel_inT2=fuel_in2;
		health1 = health11;
		health2 = health22;
		angle1 = angle11;
		angle2 = angle22;


		tankpic1=tankpicture1;
		tankpic2=tankpicture2;

		stage = new Stage(new ScreenViewport());
		img_entry_screen = new Texture("GameScreenWithMenu.jpg");

		buttonTexture = new Texture(Gdx.files.internal("Resume11.jpg"));
		drawable = new TextureRegionDrawable(new TextureRegion(buttonTexture));
		imageButton = new ImageButton(drawable);
		imageButton.setBounds(370, 350, 382, 92);

		buttonTexture1 = new Texture(Gdx.files.internal("Home.jpg"));
		drawable1 = new TextureRegionDrawable(new TextureRegion(buttonTexture1));
		imageButton1 = new ImageButton(drawable1);
		imageButton1.setBounds(370, 250, 382, 92);

		buttonTexture3 = new Texture(Gdx.files.internal("SaveGame.png"));
		drawable3 = new TextureRegionDrawable(new TextureRegion(buttonTexture3));
		imageButton3 = new ImageButton(drawable3);
		imageButton3.setBounds(370, 150, 382, 92);

		stage.addActor(imageButton);
		stage.addActor(imageButton1);
		stage.addActor(imageButton3);
		Gdx.input.setInputProcessor(stage);
	}


	@Override
	public void show() {


	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0, 1);
		game.batch.begin();
		game.batch.draw(img_entry_screen, 0, 0);
		game.batch.end();
		stage.draw();

		imageButton.addListener(new ClickListener(){
			                        @Override
			                        public void clicked(InputEvent event, float x, float y) {

				                        game.setScreen(new GameScreen(game, tankpic1, tankpic2, save_x1,save_y1, fuel_inT1,save_x2,save_y2,fuel_inT2,health1,health2,angle1,angle2));
			                        }
		                        }
		)
		;

		imageButton1.addListener(new ClickListener(){
			                        @Override
			                        public void clicked(InputEvent event, float x, float y) {
				                        game.setScreen(new MainMenu(game));
			                        }
		                        }
		)
		;
		imageButton3.addListener(new ClickListener(){
									 @Override
									 public void clicked(InputEvent event, float x, float y) {
										 try{

											 SaveGame savedgame = new SaveGame(game.player_1_tank, game.player_2_tank, save_x1,save_y1, fuel_inT1,save_x2,save_y2,fuel_inT2,health1,health2,angle1,angle2);
											 ObjectOutputStream out = null;
											 try{
												 out = new ObjectOutputStream(new FileOutputStream("/Users/vasanvohra/desktop/GameSave.txt"));
												 out.writeObject(savedgame);
											 }
											 catch (Exception e){
												 //
											 }
											 finally{
												 out.close();
											 }

										 }
										 catch(Exception e){
											 //
										 }
										 game.setScreen(new MainMenu(game));
									 }
								 }
		)
		;

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		img_entry_screen.dispose();
		stage.dispose();
	}
}