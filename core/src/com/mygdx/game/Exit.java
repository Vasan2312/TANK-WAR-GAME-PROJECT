package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

import java.io.IOException;

public class Exit implements  Screen{

    public TankStar getGame() {
        return game;
    }

    public void setGame(TankStar game) {
        this.game = game;
    }

    public Texture getDaily_mission_menu() {
        return daily_mission_menu;
    }

    public void setDaily_mission_menu(Texture daily_mission_menu) {
        this.daily_mission_menu = daily_mission_menu;
    }

    public Texture getBack_it() {
        return back_it;
    }

    public void setBack_it(Texture back_it) {
        this.back_it = back_it;
    }

    public Texture getCross() {
        return cross;
    }

    public void setCross(Texture cross) {
        this.cross = cross;
    }

    public Texture getTick() {
        return tick;
    }

    public void setTick(Texture tick) {
        this.tick = tick;
    }

    public TextureRegion getImageRegion() {
        return ImageRegion;
    }

    public void setImageRegion(TextureRegion imageRegion) {
        ImageRegion = imageRegion;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Drawable getDrawable1() {
        return drawable1;
    }

    public void setDrawable1(Drawable drawable1) {
        this.drawable1 = drawable1;
    }

    public Drawable getDrawable2() {
        return drawable2;
    }

    public void setDrawable2(Drawable drawable2) {
        this.drawable2 = drawable2;
    }

    public ImageButton getImageButton1() {
        return imageButton1;
    }

    public void setImageButton1(ImageButton imageButton1) {
        this.imageButton1 = imageButton1;
    }

    public ImageButton getImageButton2() {
        return imageButton2;
    }

    public void setImageButton2(ImageButton imageButton2) {
        this.imageButton2 = imageButton2;
    }

    private TankStar game;
    private Texture daily_mission_menu,back_it,cross,tick;
    private TextureRegion ImageRegion;
    private Stage stage;
    private Drawable drawable1,drawable2;
    private ImageButton imageButton1,imageButton2;
    Exit(TankStar game)
    {
        this.game=game;

        stage = new Stage(new ScreenViewport());
//        img_entry_screen=new Texture("Dull_bg.jpeg");

        daily_mission_menu=new Texture("Exip_Page.jpg");
        ImageRegion = new TextureRegion(daily_mission_menu, 0, 0, 1161, 536);

        cross= new Texture(Gdx.files.internal("cross.jpg"));
        drawable1 = new TextureRegionDrawable(new TextureRegion(cross));
        imageButton1 = new ImageButton(drawable1);
        imageButton1.setBounds(662, 142, 100, 100);

        tick= new Texture(Gdx.files.internal("tick.jpg"));
        drawable2 = new TextureRegionDrawable(new TextureRegion(tick));
        imageButton2 = new ImageButton(drawable2);
        imageButton2.setBounds(426, 142, 100, 100);

        stage.addActor(imageButton1);
        stage.addActor(imageButton2);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        game.batch.begin();
        game.batch.draw(daily_mission_menu, 0, 0);
        game.batch.end();
        stage.draw();

        imageButton2.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        Gdx.app.exit();
                                    }
                                }
        )
        ;
        imageButton1.addListener(new ClickListener(){
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         try {
                                             TEST.deserialize();
                                         } catch (IOException e) {
                                             throw new RuntimeException(e);
                                         } catch (ClassNotFoundException e) {
                                             throw new RuntimeException(e);
                                         }
                                         game.setScreen(new MainMenu(game));
                                         stage.dispose();
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
        tick.dispose();
        cross.dispose();

    }
}