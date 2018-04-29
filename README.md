# MeSHParser
> *Copyright 2018 [Scott Walmsley](https://scottwalmsley.github.io)*
<br>A parser for the NIH Medical Subject Headings chemical classifiers.

## Background
The MeSH (https://www.nlm.nih.gov/mesh/) is a listing of medical subject
heading (MeSH) terms. This Java library was developed to facilitate extraction
of key bits of information from MeSH and to use that information to build a
local Neo4J storage database. MeSHParser is part of a larger project,
Human Metabolome Database (HMDB) Network Amalgamation, and the MeSH chemical
taxonomies are used as an overlay to chemical and metabolic network analysis.

### *Usage*
The MeSHParser is meant to be used as a .jar library.

### *Origin*
MeSHParser is provided free of charge for academic use.

### *License*
Apache 2.0

### *Requirements*
###### *Java version 8 update 161*
MeSHParser needs the '''mtrees2018.bin''' file. This file can be downloaded from
ftp://nlmpubs.nlm.nih.gov/online/mesh/MESH_FILES/meshtrees/ .

## Components
### *1. MeshParser*
This class contains contains Main for example usage of reading the MeSH
chemical terms.  The data is serialized for later deserialization in other
functions.

### *2. MeshMap*
This file contains tree maps of indexed chemical kingdom, super, main and
sub classes.


## Specific usage examples

#### *General Usage:*
```java
 // Instantiate a new MeshMap reader and storage class.
 MeshMap meshMap = new MeshMap();

  // Read the MeSH file and load the storage class.
  meshMap.readMeshFile("meshfile.bin");
 ```


### *Serialization*
The MeshMap class can be serialized through the MeshMap class function call.
This creates a serialized bytecode object.   Within this class is an
important serialization UID:
```java
 private static final long serialVersionUID = 1L;
 ```
..it is important that this is appropriately used in the context of your
usage or a NoClassDef exception will occur, either on the same machine or
between machines.  It has been set up appropriately in this repository
and works as written.   Examples of serialization and de-serialization are
as follows:

##### *Serialization*
```java
 // Serialize the SmpdbMap class.
 serializeSmpdMap("meshMap.ser", meshMap);
```

##### *Deserialization*
```java
 // Instantiate a new SmpdbFile class:
 MeshMap meshMap = new MeshMap();

 // Deserialization of a MeshMap into the MeshMap storage class
 meshMap = (MeshMap) deserializeMap("meshMap.ser");
```



