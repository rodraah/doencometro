#!/bin/bash

mkdir -p build/lib/
javac -d build -cp "lib/*" src/doencometro/**/*.java src/doencometro/*.java
cd build
jar cfm Doencometro.jar ../MANIFEST.MF **/*.class **/**/*.class
chmod +x Doencometro.jar
rm *.class **/*.class **/**/**.class 2>/dev/null
rmdir **/** ** 2>/dev/null
mkdir lib/ 2>/dev/null
cp ../lib/* lib/
cp ../*.sql ./