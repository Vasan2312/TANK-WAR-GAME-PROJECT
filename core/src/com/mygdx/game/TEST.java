package com.mygdx.game;

import com.badlogic.gdx.Game;
import sun.rmi.server.DeserializationChecker;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.Serializable;

public class TEST{
    static void deserialize() throws IOException,ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(Files.newInputStream(Paths.get("/Users/vasanvohra/desktop/tankSave1.txt")));
            Tank new1 =(Tank)in.readObject();
            System.out.println(new1.getBHP());
            System.out.println(new1.getColour());
            System.out.println(new1.getName());

            in = new ObjectInputStream(Files.newInputStream(Paths.get("/Users/vasanvohra/desktop/tankSave2.txt")));
            Tank new2 =(Tank)in.readObject();
            System.out.println(new2.getBHP());
            System.out.println(new2.getColour());
            System.out.println(new2.getName());
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        } finally{
            assert in != null;

            in.close();
        }
    }
}
