if [ ! -d "Build" ]
then
   mkdir Build
fi

cd Source
javac -d ../Build/ *.java
cd ..
cd Build
java Main
cd ..
