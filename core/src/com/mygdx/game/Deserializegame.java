package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import sun.rmi.server.DeserializationChecker;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Serializable;

public class Deserializegame{
    static TankStar game ;
    static Texture A;
    static Texture B;
//    {
//        this.game = comgame;
//    }
    static void deserialize(TankStar game) throws IOException,ClassNotFoundException {
        game = game;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(Files.newInputStream(Paths.get("/Users/vasanvohra/desktop/Gamesave.txt")));
            SaveGame new1 =(SaveGame)in.readObject();
            int a = new1.tankpic1;
            int b= new1.tankpic2;
            if(a==1){
                A = new Texture("Tank1.jpg");
            }
            else if(a==2){
                A = new Texture("Tank2.jpg");
            }
            else if(a==3){
                A = new Texture("Tank3.jpg");
            }

            if(b==1){
                B = new Texture("FlippedTank1.png");
            }
            else if(b==2){
                B = new Texture("FlippedTank2.png");
            }
            else if(b==3){
                B = new Texture("FlippedTank3.png");
            }

            game.setScreen(new GameScreen(game, A, B, new1.save_x1,new1.save_y1, new1.fuel_inT1,new1.save_x2,new1.save_y2,new1.fuel_inT2,new1.health1,new1.health2,new1.angle1,new1.angle2));
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        } finally{
            assert in != null;

            in.close();
        }
    }
}