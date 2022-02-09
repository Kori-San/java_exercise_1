javac -d bin $(find ./src/ -type f -name '*.java')
java -cp bin ${1} #Give class name as first agrs
