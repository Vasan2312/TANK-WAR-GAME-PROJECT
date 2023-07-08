package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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

import java.text.DecimalFormat;

public class GameScreen implements Screen {

	private static class Movement_in_terrain{
		public int getRange() {
			return range;
		}

		public void setRange(int range) {
			this.range = range;
		}

		public String getTerrain() {
			return Terrain;
		}

		public void setTerrain(String terrain) {
			Terrain = terrain;
		}

		public int getSpeed_in_terrain() {
			return speed_in_terrain;
		}

		public void setSpeed_in_terrain(int speed_in_terrain) {
			this.speed_in_terrain = speed_in_terrain;
		}

		int range;
		String Terrain;
		int speed_in_terrain;

		public Movement_in_terrain(int range, String terrain, int speed_in_terrain) {
			this.range = range;
			Terrain = terrain;
			this.speed_in_terrain = speed_in_terrain;
		}
	}

	private static class drops{
		int value;
		String name;

		public drops(int value, String name) {
			this.value = value;
			this.name = name;
		}
	}
	private static class fire{
		float angle;
		float power;

		public fire(float angle, float power) {
			this.angle = angle;
			this.power = power;
		}
	}



	private TankStar game;
	private Texture img_entry_screen;
	private Sprite sprite_entry_button;
	private Stage stage;
	private Skin skin;
	private TextButton textButton;
	private Texture buttonTexture,buttonTexture1, buttonTexture2, buttonTexture3;
	private Drawable drawable,drawable1, drawable2, drawable3;
	private ImageButton imageButton,imageButton1, imageButton2, imageButton3;

	public static Texture tankpic1, tankpic2;
	public static int setPositionX, setPositionY,holdPositionX, holdPositionY,setPositionX1,setPositionY1,holdPositionX1,holdPositionY1;
	public static float Theta=0, Theta1=0;

	public BitmapFont font;
	boolean flag1=true;
	boolean flag2=false;

	int ch = 1,ch1=1;

	int health1 = 100;

	int health2  = 100;


	GameScreen(TankStar game, Texture tankpicture1, Texture tankpicture2, int saved_x1, int saved_y1, int fuel_inT1, int saved_x2,int saved_y2, int fuel_inT2, int health1, int health2, float angle1, float angle2){
		this.game=game;
		tankpic1=tankpicture1;
		tankpic2=tankpicture2;
		tank_x=saved_x1;
		tank_y=saved_y1;
		fuel_in1=fuel_inT1;
		tank_x1=saved_x2;
		tank_y1=saved_y2;
		fuel_in2=fuel_inT2;
		Theta = angle1;
		Theta1 = angle2;
		this.health1 = health1;
		this.health2 = health2;


		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(2,2);

		stage = new Stage(new ScreenViewport());
		img_entry_screen = new Texture("TankStarBG.png");

		buttonTexture = new Texture(Gdx.files.internal("Menu.jpg"));
		drawable = new TextureRegionDrawable(new TextureRegion(buttonTexture));
		imageButton = new ImageButton(drawable);
		imageButton.setBounds(0, 440, 120, 100);

		buttonTexture1 = new Texture(tankpic1.getTextureData());
		drawable1 = new TextureRegionDrawable(new TextureRegion(buttonTexture1));
		imageButton1 = new ImageButton(drawable1);
		imageButton1.setBounds(0, 0, 100, 100);


		buttonTexture2 = new Texture(tankpic2.getTextureData());
		drawable2 = new TextureRegionDrawable(new TextureRegion(buttonTexture2));
		imageButton2 = new ImageButton(drawable2);
		imageButton2.setBounds(1075, 162, 100, 100);

		buttonTexture3 = new Texture(Gdx.files.internal("Bomb.png"));
		drawable3 = new TextureRegionDrawable(new TextureRegion(buttonTexture3));
		imageButton3 = new ImageButton(drawable3);
		imageButton3.setBounds(0, 0, 20, 20);

		stage.addActor(imageButton);
		stage.addActor(imageButton1);
		stage.addActor(imageButton2);
//		stage.addActor(imageButton3);
		set_values_of_terrain();
		Gdx.input.setInputProcessor(stage);
	}

	int [] newArr=new int[1161];

	public int [] destroy=new int[1161];
	static int tank_x = 0;
	static int tank_y = 250;

	static int fuel_in1=1000;
	static int fuel_in2=1000;

	static int tank_x1=1075;
	static int tank_y1=156;

	public void set_values_of_terrain(){
		for(int i=0;i<1161;i++){
			if(i>=0 && i< 140)
				newArr[i] = 250;
			else if(i>=140 && i<333)
				newArr[i]= (int) (-0.47*i+315);
			else if(i>=333 && i<545)
				newArr[i]=155;
			else if(i>=545 && i<680)
				newArr[i]=(int) (0.25*i+21);
			else if(i>=680 && i<754)
				newArr[i]=190;
			else if(i>=754 && i<875)
				newArr[i]=(int) (-0.3*i+414);
			else if(i>=875 && i<1161)
				newArr[i]=156;
		}
	}

	public float giveY(int X)
	{
		return (float) ((holdPositionY)+((X-holdPositionX)*((float)Math.tan(Theta))-((10*(X-holdPositionX)*(X-holdPositionX))/(2*101*101*Math.cos(Theta)*Math.cos(Theta)))));
	}

	public float giveY1(int X1)
	{
		return (float) ((holdPositionY1)+((holdPositionX1-X1)*((float)Math.tan(Theta1))-((10*(holdPositionX1-X1)*(holdPositionX1-X1))/(2*101*101*Math.cos(Theta1)*Math.cos(Theta1)))));
	}

	@Override
	public void show() {
	}

	int count2 = 0;

	int count4 = 0;
	@Override
	public void render(float delta) {

		if(health1<=0 || health2<=0){
			game.setScreen(new MainMenu(game));
		}
		ScreenUtils.clear(0, 0, 0, 1);
		game.batch.begin();
		game.batch.draw(img_entry_screen, 0, 0);
		font.draw(game.batch, "Health : " + health1, 100, 100);
		font.draw(game.batch, "Angle : " + Double.parseDouble(new DecimalFormat("##.##").format(Theta)), 100, 50);
		font.draw(game.batch, "Health : " + health2, 900, 100);
		font.draw(game.batch, "Angle : " + Double.parseDouble(new DecimalFormat("##.##").format(Theta1)), 900, 50);
		game.batch.end();
		stage.draw();





		imageButton.addListener(new ClickListener(){
			                        @Override
			                        public void clicked(InputEvent event, float x, float y) {
				                        game.setScreen(new MenuOnGameScreen(game, tankpic1, tankpic2, tank_x, tank_y, fuel_in1, tank_x1,tank_y1,fuel_in2,health1,health2,Theta,Theta1));
			                        }
		                        }
		)
		;

		if(Gdx.input.isKeyJustPressed(Input.Keys.S))
		{
			Theta+=0.1;
			System.out.println(Theta);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.X))
		{
			Theta-=0.1;
			System.out.println(Theta);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.B))
		{
			Theta1-=0.1;
			System.out.println(Theta);
		}

		if(Gdx.input.isKeyJustPressed(Input.Keys.G))
		{
			Theta1+=0.1;
			System.out.println(Theta1);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
//			float tan= (float) ((536-Gdx.input.getY()-tank_y)/(Gdx.input.getX()-tank_x));
//			float cos= (float)Math.acos(1/Math.sqrt(1+(tan*tan)));
//			System.out.println(cos);
//			float a=((i-tank_x)*tan)-((10*(i-tank_x)*(i-tank_x))/(2*101*cos*cos));
//			float a= (float) (0.2*i);
//			System.out.println(i+" , "+a);
//			game.batch.begin();
//			game.batch.draw(buttonTexture3,i,a,30,30);
//			game.batch.end();
//			System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
			flag1 = false;
			flag2 = true;
			float y = giveY(setPositionX);
			if(setPositionX<1161 && newArr[setPositionX]<=y) {
				ch = 1;
				game.batch.begin();
				System.out.println("33");
				game.batch.draw(buttonTexture3, setPositionX, y, 20, 20);
				game.batch.end();
				setPositionX += 5;
			}
			else{
				if(setPositionX<1161 && Math.abs(setPositionX-tank_x1)<100 && ch == 1){
					health2-=30;
					ch = 0;
				}
				else if(setPositionX<1161 && Math.abs(setPositionX-tank_x1)<200 && ch == 1){
					health2-=20;
					ch = 0;
				}
				else if(setPositionX<1161 && Math.abs(setPositionX-tank_x1)<300 && ch == 1){
					health2-=10;
					ch = 0;
				}
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.F))
		{
//			float tan= (float) ((536-Gdx.input.getY()-tank_y)/(Gdx.input.getX()-tank_x));
//			float cos= (float)Math.acos(1/Math.sqrt(1+(tan*tan)));
//			System.out.println(cos);
//			float a=((i-tank_x)*tan)-((10*(i-tank_x)*(i-tank_x))/(2*101*cos*cos));
//			float a= (float) (0.2*i);
//			System.out.println(i+" , "+a);
//			game.batch.begin();
//			game.batch.draw(buttonTexture3,i,a,30,30);
//			game.batch.end();
//			System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
			flag1 = true;
			flag2 = false;
			float y1 = giveY1(setPositionX1);
			if(setPositionX1>0 && newArr[setPositionX1]<=y1) {
				ch1 =1;
				game.batch.begin();
				System.out.println("33");
				game.batch.draw(buttonTexture3, setPositionX1, y1, 20, 20);
				game.batch.end();
				setPositionX1 -= 5;
			}
			else{
				if(setPositionX1>0 && Math.abs(setPositionX1-tank_x)<100 && ch1 == 1){
					health1-=30;
					ch1 = 0;
				}
				else if(setPositionX1>0 && Math.abs(setPositionX1-tank_x)<200 && ch1 == 1){
					health1-=20;
					ch1 = 0;
				}
				else if(setPositionX1>0 && Math.abs(setPositionX1-tank_x)<300 && ch1 == 1){
					health1-=10;
					ch1 = 0;
				}
			}
		}

		imageButton1.setBounds(tank_x,tank_y,100,100);
		imageButton2.setBounds(tank_x1, tank_y1, 100,100);

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			if(fuel_in1>0 && flag1) {
				if (tank_x>=0 && tank_x < 140) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 140 && tank_x < 333) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 333 && tank_x < 545) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 545 && tank_x < 680) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 680 && tank_x < 750) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 750 && tank_x < 875) {
					fuel_in1 -= 2;
					tank_x += 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 875 && tank_x <= 1075) {
					fuel_in1 -= 2;
					if(tank_x==1075)
						tank_x=1075;
					else
						tank_x += 1;
					tank_y = newArr[tank_x];
				}
			}
			else
			{
				fuel_in2=1000;
			}
			setPositionX=tank_x+85;
			holdPositionX=tank_x;
			setPositionY=tank_y+55;
			holdPositionY=tank_y;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			if (fuel_in2 > 0 && flag2) {
				if (tank_x1>=0 && tank_x1 < 140) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 140 && tank_x1 < 333) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 333 && tank_x1 < 545) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 545 && tank_x1 < 680) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 680 && tank_x1 < 750) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 750 && tank_x1 < 875) {
					fuel_in2 -= 2;
					tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 875 && tank_x1 <= 1075) {
					fuel_in2 -= 2;
					if(tank_x1==1075)
						tank_x1 = 1075;
					else
						tank_x1 += 1;
					tank_y1 = newArr[tank_x1];
				}
			}
			else
			{
				fuel_in1=1000;
			}
			setPositionX1=tank_x1;
			holdPositionX1=tank_x1;
			setPositionY1=tank_y1;
			holdPositionY1=tank_y1+55;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			if(fuel_in1>0 && flag1) {
				if (tank_x>=0 && tank_x < 140) {
					fuel_in1 -= 2;
					if(tank_x==0)
						tank_x=0;
					else
						tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 140 && tank_x < 333) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 333 && tank_x < 545) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 545 && tank_x < 680) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 680 && tank_x < 750) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 750 && tank_x < 875) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
				else if (tank_x >= 875 && tank_x <= 1075) {
					fuel_in1 -= 2;
					tank_x -= 1;
					tank_y = newArr[tank_x];
				}
			}
			else
			{
				fuel_in2=1000;
			}
			setPositionX=tank_x+85;
			holdPositionX=tank_x;
			setPositionY=tank_y+55;
			holdPositionY=tank_y;
		}

		if(Gdx.input.isKeyPressed(Input.Keys.A))
		{
			if(fuel_in2>0 && flag2)
			{
				if (tank_x1>=0 && tank_x1 < 140) {
					fuel_in2 -= 2;
					if(tank_x1==0)
						tank_x1=0;
					else
						tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 140 && tank_x1 < 333) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 333 && tank_x1 < 545) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 545 && tank_x1 < 680) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 680 && tank_x1 < 750) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 750 && tank_x1 < 875) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
				else if (tank_x1 >= 875 && tank_x1 <= 1075) {
					fuel_in2 -= 2;
					tank_x1 -= 1;
					tank_y1 = newArr[tank_x1];
				}
			}
			else
			{
				fuel_in1=1000;
			}
			setPositionX1=tank_x1;
			holdPositionX1=tank_x1;
			setPositionY1=tank_y1;
			holdPositionY1=tank_y1+55;
		}
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