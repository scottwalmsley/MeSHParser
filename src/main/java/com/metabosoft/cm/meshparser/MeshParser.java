package com.metabosoft.cm.meshparser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MeshParser {

    public static Map<String,String> kingdomIDX = new TreeMap<>();
    public static Map<String,String> superClassIDX = new TreeMap<>();
    public static Map<String,String> mainClassIDX = new TreeMap<>();
    public static Map<String,String> subClassIDX = new TreeMap<>();


    public static void main (String[] args){

        String csvFile = "mtrees2018.bin";


        BufferedReader br = null;

        String line = "";
        String csvSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use semicolon as separator
                String[] meshEntry = line.split(csvSplitBy);

                String regex = "D0[0-9]";
                if(meshEntry[1].matches(regex)) {//startsWith("D01"))
                    kingdomIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
                regex = "D0[0-9]\\.[0-9]{3}";
                if(meshEntry[1].matches(regex)) {//startsWith("D01"))
                    superClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }

                regex = "D0[0-9]\\.[0-9]{3}\\.[0-9]{3}";
                if(meshEntry[1].matches(regex)) {//startsWith("D01"))
                    mainClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
                regex = "D0[0-9]\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}";
                if(meshEntry[1].matches(regex)) {//startsWith("D01"))
                    subClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
            }

            int debug = 0;
        }catch (IOException e) {
            e.printStackTrace();
        }



    }



}
