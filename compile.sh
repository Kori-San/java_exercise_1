javac -d bin $(find ./src/ -type f -name '*.java')
java -cp bin HelloWorld
