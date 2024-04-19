#!/bin/bash

mkdir -p build/lib/
javac -d build -cp "lib/*" src/doencometro/**/*.java src/doencometro/*.java
cd build
jar cfm Doencometro.jar ../MANIFEST.MF **/*.class *.class
chmod +x Doencometro.jar
rm *.class **/*.class
rmdir ** 2>/dev/null
cp ../lib/* lib/