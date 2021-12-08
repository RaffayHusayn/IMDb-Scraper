package com.fclass;

import java.io.*;

public class CSVWriter {
    public PrintWriter saveOrAppend(String filepath, Boolean append) throws IOException {

        FileWriter fw = new FileWriter(filepath, append);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        return pw;
    }

    public void save(PrintWriter pw,  Movie m) {

        try{
            pw.println(m.toString());


            System.out.println("========================================================================");
            System.out.println("+++  Movie : \"" + m.getName() + "\"   Saved   +++");
            System.out.println("=========================================================================");
        } catch (Exception e) {
            System.out.println("some problem occured!!!!");
            e.printStackTrace();
        }
    }

    public void closeCSVWriter(PrintWriter printWriter){
        printWriter.flush();
        printWriter.close();
    }
}
