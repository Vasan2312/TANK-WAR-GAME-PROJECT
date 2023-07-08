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

public class DailyMission implements  Screen{

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

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    private TankStar game;
    private Texture img_entry_screen,daily_mission_menu,back_it;
    private TextureRegion ImageRegion;
    private Stage stage;
    private Drawable drawable;
    private ImageButton imageButton;
    DailyMission(TankStar game)
    {
        this.game=game;

        stage = new Stage(new ScreenViewport());
//        img_entry_screen=new Texture("Dull_bg.jpeg");

        daily_mission_menu=new Texture("DailyTab.jpg");
        ImageRegion = new TextureRegion(daily_mission_menu, 0, 0, 1161, 536);

        back_it= new Texture(Gdx.files.internal("Back.jpg"));
        drawable = new TextureRegionDrawable(new TextureRegion(back_it));
        imageButton = new ImageButton(drawable);
        imageButton.setBounds(360, 309, 84, 84);

        stage.addActor(imageButton);
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

        imageButton.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
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


    }
}