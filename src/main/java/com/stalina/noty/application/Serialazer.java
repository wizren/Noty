package com.stalina.noty.application;

import java.io.*;

class Serialazer {

    static NotyBase getBase() {
        NotyBase base;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("archive.dat")))
        {
            base = (NotyBase) ois.readObject();
        }
        catch (Exception ex){

            base = new NotyBase();
        }
        return base;
    }

    static void SerializeData(Object obj) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("archive.dat"));
        oos.writeObject(obj);
    }
}
