/*
 * Copyright 2018  Scott J. Walmsley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

/**
 * Class MeshMap A storage class for serializable data.
 * @implements Serializable
 */
public class MeshMap implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String,String> kingdomIDX = new TreeMap<>();
    private Map<String,String> superClassIDX = new TreeMap<>();
    private Map<String,String> mainClassIDX = new TreeMap<>();
    private Map<String,String> subClassIDX = new TreeMap<>();

    /**
     *
     * @return
     */
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

    /**
     *
     * @param fh The file handle.
     *
     */
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

    /**
     *
     * @param fh
     * @param meshMap
     * @throws IOException
     */
    public static final void serializeMap(String fh, Object meshMap) throws IOException {
        FileOutputStream fileOut =  new FileOutputStream(fh);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(meshMap);
        out.close();
        fileOut.close();
    }

    /**
     *
     * @param fh
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static final Object deserializeMap(String fh)throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(fh);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Object data = in.readObject();
        in.close();
        fileIn.close();
        return data;
    }

}
