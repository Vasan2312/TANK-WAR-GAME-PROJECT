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

class Singleton extends Texture {
    private static Singleton singleton=null;

    public static Singleton getInstance(String obj)
    {
        if (singleton==null)
        {
            singleton=new Singleton(obj);
        }
        return singleton;
    }

    private Singleton(String obj)
    {
        super(obj);
    }
}

public class EntryScreen implements Screen {

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

    public Texture getImg_entry_button() {
        return img_entry_button;
    }

    public void setImg_entry_button(Texture img_entry_button) {
        this.img_entry_button = img_entry_button;
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
    private Texture img_entry_screen,img_entry_button;
    private Sprite sprite_entry_button;
    private Stage stage;
    private Skin skin;
    private TextButton textButton;
    private Texture buttonTexture;
    private Drawable drawable;
    private ImageButton imageButton;
    EntryScreen(TankStar game){
        this.game=game;
        stage = new Stage(new ScreenViewport());
//        skin = new Skin(Gdx.files.internal("Skin/glassy-ui.json"));
//        textButton = new TextButton("New Game", skin, "small");
//        textButton.setBounds(580-100, 10, 200, 50);
//        stage.addActor(textButton);
        img_entry_screen = new Texture("EntryScreen.jpg");
        buttonTexture=Singleton.getInstance("EntryButton.jpg");
//        buttonTexture = new Texture(Gdx.files.internal("EntryButton.jpg"));
        drawable = new TextureRegionDrawable(new TextureRegion(buttonTexture));
        imageButton = new ImageButton(drawable);
        imageButton.setBounds(1080, 17, 60, 60);
        stage.addActor(imageButton);
//		img_entry_button = new Texture("EntryButton.jpeg");
//		sprite_entry_button  = new Sprite(img_entry_button);
//		sprite_entry_button.setPosition(580-120,10);
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
//		batch.draw(sprite_entry_button,sprite_entry_button.getX(),sprite_entry_button.getY());
        game.batch.end();
        stage.draw();
        imageButton.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
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
        img_entry_button.dispose();
        stage.dispose();
    }
}