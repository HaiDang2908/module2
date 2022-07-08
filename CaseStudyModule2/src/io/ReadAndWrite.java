package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite <T> {

    public void writeFile(String path , List<T> list){
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e) {
            System.out.println("");
        }
    }

    public List<T> readFromFile(String path){
        List<T> list = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(path);
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (List<T>) objectInputStream.readObject();
            }
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
