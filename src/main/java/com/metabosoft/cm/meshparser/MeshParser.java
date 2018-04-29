package com.metabosoft.cm.meshparser;

import java.io.IOException;

import static com.metabosoft.cm.meshparser.MeshMap.deserializeMap;
import static com.metabosoft.cm.meshparser.MeshMap.serializeMap;

/**
 * Class MeshParser
 */
public class MeshParser {

    /**
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        boolean load = true;

        MeshMap meshMap = new MeshMap();
        if(load) {
            String csvFile = "mtrees2018.bin";
            meshMap.readMeshFile(csvFile);
            serializeMap("meshMap.ser",meshMap);
        }else{
            meshMap = (MeshMap) deserializeMap("meshMap.ser");
        }
        int d = 0;

    }

}
