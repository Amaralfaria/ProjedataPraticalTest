all:
	javac -d out $(shell find src -name "*.java")
	java -cp out br.com.projedata.Main