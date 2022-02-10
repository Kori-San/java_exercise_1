#!/bin/bash

javac -d bin $(find ./src/ -type f -name '*.java')
if [ ${#} != 0 ]; then
    java -cp bin ${1} #Give class name as first arg
fi
