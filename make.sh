#!/bin/bash

javac -d build -cp "lib/*" src/doencometro/*
cd build
jar cfm Doencometro.jar ../MANIFEST.MF * ../lib/*
chmod +x Doencometro.jar
cp ../lib/* ./