package com.t02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws IOException {

        Properties prop = new Properties();

        FileReader fr = new FileReader("src\\com\\t02\\game.txt");

        prop.load(fr);

        fr.close();

        String count = prop.getProperty("count");

        int number = Integer.parseInt(count);

        if(number>=3){
            System.out.println("游戏试玩结束");
        }else {
            number++;
            prop.setProperty("count",String.valueOf(number));

            FileWriter fw = new FileWriter("src\\com\\t02\\game.txt");

            prop.store(fw,null);

            fw.close();
        }
    }
}
