package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
import java.net.URI;
import java.net.URISyntaxException;

public class Setting2 implements Screen {

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

    public Texture getSound_on() {
        return Sound_on;
    }

    public void setSound_on(Texture sound_on) {
        Sound_on = sound_on;
    }

    public Texture getMusic_on() {
        return music_on;
    }

    public void setMusic_on(Texture music_on) {
        this.music_on = music_on;
    }

    public Texture getTerms() {
        return terms;
    }

    public void setTerms(Texture terms) {
        this.terms = terms;
    }

    public Texture getVs_friend() {
        return vs_friend;
    }

    public void setVs_friend(Texture vs_friend) {
        this.vs_friend = vs_friend;
    }

    public Texture getResume() {
        return resume;
    }

    public void setResume(Texture resume) {
        this.resume = resume;
    }

    public Texture getExit() {
        return exit;
    }

    public void setExit(Texture exit) {
        this.exit = exit;
    }

    public Texture getSound_off() {
        return Sound_off;
    }

    public void setSound_off(Texture sound_off) {
        Sound_off = sound_off;
    }

    public Texture getMusic_off() {
        return music_off;
    }

    public void setMusic_off(Texture music_off) {
        this.music_off = music_off;
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

    public Drawable getDrawable2() {
        return drawable2;
    }

    public void setDrawable2(Drawable drawable2) {
        this.drawable2 = drawable2;
    }

    public Drawable getDrawable3() {
        return drawable3;
    }

    public void setDrawable3(Drawable drawable3) {
        this.drawable3 = drawable3;
    }

    public Drawable getDrawable4() {
        return drawable4;
    }

    public void setDrawable4(Drawable drawable4) {
        this.drawable4 = drawable4;
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

    public ImageButton getImageButton3() {
        return imageButton3;
    }

    public void setImageButton3(ImageButton imageButton3) {
        this.imageButton3 = imageButton3;
    }

    public ImageButton getImageButton2() {
        return imageButton2;
    }

    public void setImageButton2(ImageButton imageButton2) {
        this.imageButton2 = imageButton2;
    }

    public ImageButton getImageButton4() {
        return imageButton4;
    }

    public void setImageButton4(ImageButton imageButton4) {
        this.imageButton4 = imageButton4;
    }

    private TankStar game;
    private Texture img_entry_screen,img_entry_button;
    private Sprite sprite_entry_button;
    private Stage stage;
    private Skin skin;
    private TextButton textButton;
    private Texture Sound_on,music_on,terms,vs_friend,resume,exit,Sound_off,music_off;
    private Drawable drawable,drawable1,drawable2,drawable3,drawable4;
    private ImageButton imageButton,imageButton1,imageButton3,imageButton2,imageButton4;

    Setting2(TankStar game){
        this.game=game;
        game.flag =2;
        stage = new Stage(new ScreenViewport());


        img_entry_screen = new Texture("Setting2.jpg");

        Sound_on = new Texture(Gdx.files.internal("Sound_on.jpg"));
        drawable = new TextureRegionDrawable(new TextureRegion(Sound_on));
        imageButton = new ImageButton(drawable);
        imageButton.setBounds(383, 287, 382,92);

        music_off= new Texture(Gdx.files.internal("music_off.jpg"));
        drawable2 = new TextureRegionDrawable(new TextureRegion(music_off));
        imageButton2 = new ImageButton(drawable2);
        imageButton2.setBounds(383, 170, 382,92);

        terms= new Texture(Gdx.files.internal("terms.jpg"));
        drawable3 = new TextureRegionDrawable(new TextureRegion(terms));
        imageButton3 = new ImageButton(drawable3);
        imageButton3.setBounds(383, 56, 382,92);

        exit= new Texture(Gdx.files.internal("CrossGreen.jpg"));
        drawable4 = new TextureRegionDrawable(new TextureRegion(exit));
        imageButton4 = new ImageButton(drawable4);
        imageButton4.setBounds(718, 414, 58,58);

        stage.addActor(imageButton);
        stage.addActor(imageButton2);
        stage.addActor(imageButton3);
        stage.addActor(imageButton4);

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

        imageButton4.addListener(new ClickListener(){
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         game.setScreen(new MainMenu(game));
                                         stage.dispose();
                                     }
                                 }
        )
        ;
        imageButton.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        game.setScreen(new Setting3(game));
                                        stage.dispose();
                                    }
                                }
        )
        ;
        imageButton2.addListener(new ClickListener(){
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         game.setScreen(new Setting(game));
                                         stage.dispose();
                                     }
                                 }
        )
        ;
        imageButton3.addListener(new ClickListener(){
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         URI uri = null;
                                         try {
                                             uri = new URI("https://playgendary.com/en/playgendary-gmbh-privacy-policy");
                                         } catch (URISyntaxException e) {
                                             throw new RuntimeException(e);
                                         }
                                         try {
                                             java.awt.Desktop.getDesktop().browse(uri);
                                         } catch (IOException e) {
                                             throw new RuntimeException(e);
                                         }
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
        img_entry_screen.dispose();
        stage.dispose();
    }
}