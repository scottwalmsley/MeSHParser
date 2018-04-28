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