if [ ! -d "Build" ]
then
   mkdir Build
fi

clear;
cd Source
javac -d ../Build/ *.java
cd ..
cd Build
java Main
cd ..
