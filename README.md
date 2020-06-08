# pdf-conversion-adapter
PDF Conversion Adapter

## Introduction
PDF Conversion Adapter is the test driver for the PDF Conversion SDK.

## ## Starting the Adapter
1. export CLASSPATH=.:/data/1/projects/pdf-conversion-sdk/build/libs/pdf-conversion-sdk-0.0.1-SNAPSHOT.jar
2. javac PdfConversionAdapter.java
3. java PdfConversionAdapter {arg[0]}   - where arg[0] is the file to be converterd (i.e. /data/1/testFiles/TestTxt.txt)
