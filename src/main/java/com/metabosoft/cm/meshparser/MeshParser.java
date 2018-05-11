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

import java.io.IOException;

import static com.metabosoft.cm.meshparser.MeshMap.deserializeMap;
import static com.metabosoft.cm.meshparser.MeshMap.serializeMap;

/**
 * Class MeshParser Reads Medical Subject Headings .bin file from NCBI.gov.
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
