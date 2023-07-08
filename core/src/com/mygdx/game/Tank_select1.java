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

public class Tank_select1 extends Select_Tanks implements Screen {

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

    public Texture getBox() {
        return box;
    }

    public void setBox(Texture box) {
        this.box = box;
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

    public Texture getTank1() {
        return tank1;
    }

    public void setTank1(Texture tank1) {
        this.tank1 = tank1;
    }

    public Texture getTank2() {
        return tank2;
    }

    public void setTank2(Texture tank2) {
        this.tank2 = tank2;
    }

    public Texture getTank3() {
        return tank3;
    }

    public void setTank3(Texture tank3) {
        this.tank3 = tank3;
    }

    public Texture getNext() {
        return next;
    }

    public void setNext(Texture next) {
        this.next = next;
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

    public static Texture getTankpic1() {
        return tankpic1;
    }

    public static void setTankpic1(Texture tankpic1) {
        Tank_select1.tankpic1 = tankpic1;
    }

    public static Texture getTankpic2() {
        return tankpic2;
    }

    public static void setTankpic2(Texture tankpic2) {
        Tank_select1.tankpic2 = tankpic2;
    }

    public boolean isDrawImage1() {
        return drawImage1;
    }

    public void setDrawImage1(boolean drawImage1) {
        this.drawImage1 = drawImage1;
    }

    public boolean isDrawImage2() {
        return drawImage2;
    }

    public void setDrawImage2(boolean drawImage2) {
        this.drawImage2 = drawImage2;
    }

    public boolean isDrawImage3() {
        return drawImage3;
    }

    public void setDrawImage3(boolean drawImage3) {
        this.drawImage3 = drawImage3;
    }

    private TankStar game;
    private Texture img_entry_screen,img_entry_button,box;
    private Sprite sprite_entry_button;
    private Stage stage;
    private Skin skin;
    private TextButton textButton;
    private Texture buttonTexture,tank1,tank2,tank3,next;
    private Drawable drawable,drawable1,drawable2,drawable3,drawable4;
    private ImageButton imageButton,imageButton1,imageButton3,imageButton2,imageButton4;

    public static Texture tankpic1, tankpic2;
    private boolean drawImage1 = false;
    private boolean drawImage2 = false;
    private boolean drawImage3 = false;

    Tank_select1(TankStar game){
        this.game=game;


        stage = new Stage(new ScreenViewport());
        img_entry_screen = new Texture("tankSelect1.jpg");
        box = new Texture("box.jpg");

        ChooseTank("Tank1.jpg",tank1,drawable);
//        tank1 = picktank("Tank1.jpg");
//        drawable = drawtexture(tank1);
        imageButton = buttoncreate(drawable);
        imageButton.setBounds(15, 123, 360,202);

        ChooseTank("Tank2.jpg",tank2,drawable1);
//        tank2 = picktank("Tank2.jpg");
//        drawable1 = drawtexture(tank2);
        imageButton1 = buttoncreate(drawable1);
        imageButton1.setBounds(387, 142, 334,176);

        ChooseTank("Tank3.jpg",tank3,drawable2);
//        tank3 = picktank("Tank3.jpg");
//        drawable2 = drawtexture(tank3);
        imageButton2 = buttoncreate(drawable2);
        imageButton2.setBounds(707, 124, 330,210);

        ChooseTank("next.jpg",next,drawable3);
//        next = picktank("next.jpg");
//        drawable3 = drawtexture(next);
        imageButton3 = buttoncreate(drawable3);
        imageButton3.setBounds(1022, 5, 120,120);

        stage.addActor(imageButton);
        stage.addActor(imageButton1);
        stage.addActor(imageButton2);
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


        if (drawImage1) {
            game.batch.begin();
            game.batch.draw( box, 10, 118);
            game.batch.end();
        }
        if (drawImage2) {
            game.batch.begin();
            game.batch.draw( box, 375, 118);
            game.batch.end();
        }
        if (drawImage3) {
            game.batch.begin();
            game.batch.draw( box, 720, 118);
            game.batch.end();
        }

        imageButton.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.player_1_tank=1;
                    try{
                        Tank Tank1 = new Tank(800,"Yellow","Fire911");

                        ObjectOutputStream out = null;
                        try{
                            out = new ObjectOutputStream(new FileOutputStream("/Users/varul18/desktop/tankSave1.txt"));
                            out.writeObject(Tank1);
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
                    drawImage1 = true;
                    drawImage2 = false;
                    drawImage3 = false;
                    tankpic1=new Texture("Tank1.jpg");
                }
            }
        )
        ;

        imageButton1.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        game.player_1_tank=2;
                                        try{
                                            Tank Tank2 = new Tank(700,"Green","Nature911");

                                            ObjectOutputStream out = null;
                                            try{
                                                out = new ObjectOutputStream(new FileOutputStream("/Users/varul18/desktop/tankSave1.txt"));
                                                out.writeObject(Tank2);
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
                                      drawImage2 = true;
                                      drawImage1 = false;
                                      drawImage3 = false;
                                      tankpic1=new Texture("Tank2.jpg");
                                    }
                                }
        )
        ;

        imageButton2.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        game.player_1_tank=3;
                                        try{
                                            Tank Tank3 = new Tank(1000,"GREEN","Shooter911");

                                            ObjectOutputStream out = null;
                                            try{
                                                out = new ObjectOutputStream(new FileOutputStream("/Users/varul18/desktop/tankSave1.txt"));
                                                out.writeObject(Tank3);
                                            }
                                            catch (Exception e){
                                                //
                                            }
                                            finally{
                                                out.close();
                                            }
//                                            ObjectInputStream in = null;
//                                            try {
//                                                in = new ObjectInputStream(new FileInputStream("/Users/vasanvohra/desktop/tankSave1.txt"));
//                                                Tank new1 =(Tank)in.readObject();
//                                                System.out.println("hello");
//                                                System.out.println(new1.BHP);
//                                                System.out.println(new1.colour);
//                                                System.out.println(new1.name);
//                                            } catch (IOException | ClassNotFoundException e){
//                                                throw new RuntimeException(e);
//                                            } finally{
//                                                assert in != null;
//                                                in.close();
//                                            }

                                        }
                                        catch(Exception e){
                                            System.out.println(e);
                                        }
                                        drawImage3 = true;
                                        drawImage1 = false;
                                        drawImage2 = false;
                                        tankpic1=new Texture("Tank3.jpg");
//                                        System.out.println(game.player_1_tank);

                                    }

                                }
        )
        ;
        imageButton3.addListener(new ClickListener(){
                                     @Override
                                     public void clicked(InputEvent event, float x, float y) {
                                         game.setScreen(new Tank_Select2(game, tankpic1));
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

    @Override
    public Texture picktank(String obj) {
        return new Texture(Gdx.files.internal(obj));
    }

    @Override
    public TextureRegionDrawable drawtexture(Texture texture) {
        return new TextureRegionDrawable(new TextureRegion(texture));
    }

    @Override
    public ImageButton buttoncreate(Drawable drawable) {
        return new ImageButton(drawable);
    }
}