package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveGame implements Serializable {
    TankStar game;
    int tankpic1,tankpic2;
    int save_x1,save_y1,fuel_inT1,save_x2,save_y2,fuel_inT2,health1,health2;
    float angle1,angle2;
    SaveGame(int tankpicture1, int tankpicture2, int tank_x1, int tank_y1, int fuel_in1, int tank_x2, int tank_y2, int fuel_in2, int health11, int health22, float angle11, float angle22){
//        this.game = game;
        this.tankpic1 = tankpicture1;
        this.tankpic2 = tankpicture2;
        this.save_x1 = tank_x1;
        this.save_y1 = tank_y1;
        this.fuel_inT1 = fuel_in1;
        this.fuel_inT2 = fuel_in2;
        this.save_x2 = tank_x2;
        this.save_y2 = tank_y2;
        this.health1 = health11;
        this.health2 = health22;
        this.angle1 = angle11;
        this.angle2 = angle22;
    }
}