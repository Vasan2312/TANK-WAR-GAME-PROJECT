package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.io.Serializable;
import java.util.ArrayList;

abstract class Select_Tanks
{
    public final void ChooseTank(String obj, Texture texture1,Drawable drawable)
    {
        texture1=picktank(obj);
        drawable=drawtexture(texture1);
    }
    public abstract Texture picktank(String obj);
    public abstract TextureRegionDrawable drawtexture(Texture texture);
    public abstract ImageButton buttoncreate(Drawable drawable);
}
public class Tank implements Serializable {

    private static class Missiles{
        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        int power;
        int damage;
        int speed;

        public Missiles(int power, int damage, int speed) {
            this.power = power;
            this.damage = damage;
            this.speed = speed;
        }
    }

    private String name;
    private int BHP;
    private String colour;

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getBHP() {
        return BHP;
    }

    public void setBHP(int BHP) {
        this.BHP = BHP;
    }
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    Tank(int BHP, String colour, String name){
        this.BHP = BHP;
        this.name = name;
        this.colour = colour;
    }


}
