package com.metabosoft.cm.meshparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;


public class MeshMap implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String,String> kingdomIDX = new TreeMap<>();
    private Map<String,String> superClassIDX = new TreeMap<>();
    private Map<String,String> mainClassIDX = new TreeMap<>();
    private Map<String,String> subClassIDX = new TreeMap<>();


    public Map<String, String> getKingdomIDX() {
        return kingdomIDX;
    }

    public void setKingdomIDX(Map<String, String> kingdomIDX) {
        this.kingdomIDX = kingdomIDX;
    }

    public Map<String, String> getSuperClassIDX() {
        return superClassIDX;
    }

    public void setSuperClassIDX(Map<String, String> superClassIDX) {
        this.superClassIDX = superClassIDX;
    }

    public Map<String, String> getMainClassIDX() {
        return mainClassIDX;
    }

    public void setMainClassIDX(Map<String, String> mainClassIDX) {
        this.mainClassIDX = mainClassIDX;
    }

    public Map<String, String> getSubClassIDX() {
        return subClassIDX;
    }

    public void setSubClassIDX(Map<String, String> subClassIDX) {
        this.subClassIDX = subClassIDX;
    }


    public void readMeshFile(String fh){

        BufferedReader br = null;

        String line = "";
        String csvSplitBy = ";";

        try {

            br = new BufferedReader(new FileReader(fh));
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use semicolon as separator
                String[] meshEntry = line.split(csvSplitBy);

                String regex = "D0[0-9]";
                if (meshEntry[1].matches(regex)) {//startsWith("D01"))
                    this.kingdomIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
                regex = "D0[0-9]\\.[0-9]{3}";
                if (meshEntry[1].matches(regex)) {//startsWith("D01"))
                   this.superClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }

                regex = "D0[0-9]\\.[0-9]{3}\\.[0-9]{3}";
                if (meshEntry[1].matches(regex)) {//startsWith("D01"))
                    this.mainClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
                regex = "D0[0-9]\\.[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}";
                if (meshEntry[1].matches(regex)) {//startsWith("D01"))
                    this.subClassIDX.put(meshEntry[1], meshEntry[0]);
                    System.out.println(meshEntry[0] + "  " + meshEntry[1]);
                }
            }

            int debug = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final void serializeMap(String fh, Object meshMap) throws IOException {
        FileOutputStream fileOut =  new FileOutputStream(fh);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(meshMap);
        out.close();
        fileOut.close();
    }

    public static final Object deserializeMap(String fh)throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fh);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object data = in.readObject();
        in.close();
        fileIn.close();
        return data;
    }

}
