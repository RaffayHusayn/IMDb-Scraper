package com.fclass;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVWriter {
    public void save(String filepath, Boolean append, Movie m){
        try{
            FileWriter fw = new FileWriter(filepath, append);//true mean appends, false mean override
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(m.toString());

            pw.flush();
            pw.close();


            System.out.println("saved!!!!");
        }catch (Exception e){
            System.out.println("some problem occured!!!!");
            e.printStackTrace();
         }

    }
}
