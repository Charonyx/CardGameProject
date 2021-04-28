/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author chura
 */
public class DataFile {

    private static final String DATA_PATH = new String("D:/Users/Documents/CardGame/Uno/src/data/data.txt");
    private File file = new File(DATA_PATH);

    private String name;
    private double score;

    public DataFile(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public void writeData(/*String name, double score*/) throws IOException, FileNotFoundException {
        FileWriter wData = new FileWriter(new File(DATA_PATH));
        wData.write("test : ");
        wData.write("\n" + name + "," + score);
//        wData.write("\n" + getName() + "," + getScore());
        wData.close();
        System.out.println("end write\n");
    }

    public void readData() throws IOException, FileNotFoundException {
//        try {
        Scanner rData = new Scanner(file);
        while (rData.hasNextLine()) {
            String data = rData.nextLine();
            System.out.println(data);
        }
//        };
        System.out.println("end read\n");
    }

//------------------------RANK-------------------------
    public int countLineFile() throws FileNotFoundException, IOException {
        System.out.println("data : " + file.exists());
        if (file.exists()) {
            int result;
            try ( FileReader input = new FileReader(DATA_PATH);  LineNumberReader count = new LineNumberReader(input);) {
                while (count.skip(Long.MAX_VALUE) > 0) {
                    // Loop just in case the file is > Long.MAX_VALUE or skip() decides to not read the entire file
                }

                result = count.getLineNumber() + 1;                                    // +1 because line index starts at 0
            }
//            catch(Exception e){
//                return "error: not found";
//            }
            return result;
        } else {
            file.createNewFile();
            System.out.println("created file: " + file.getName());
            return 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
