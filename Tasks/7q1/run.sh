#!/usr/bin/env bash
ALL="-a"
COMPILE="-c"
BUILD="-b"

function compile() {
   if [[ ! -d "Bin" ]]; then
      $(mkdir Bin)
   fi 
   $(javac -d Bin/ Source/*.java)
}


function run() {
   if [[ -d "Build" ]]; then
      java -jar Build/out.jar  
   fi
}

function build() {
   if [[ ! -d "Build" ]]; then
      $(mkdir Build)
   fi
   
   if [[ ! -f "MANIFEST.MF" ]]; then
      $(touch MANIFEST.MF)
   fi

   echo "Main-Class: Main" > MANIFEST.MF
   cd Bin/
   jar cvmf ../MANIFEST.MF ../Build/out.jar *.class
   cd ..
}


if [[ -z "$1" ]]; then
   run
elif [[ "$1" == $COMPILE ]]; then
   compile $2
elif [[ "$1" == $BUILD ]]; then
   build 
elif [[ "$1" == "$ALL" ]]; then
   compile; build; run
else
   echo "unexpected command."
fi
