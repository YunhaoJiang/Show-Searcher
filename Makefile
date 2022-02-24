runTest:	AlgorithmEngineerTest.class
	java AlgorithmEngineerTest

AlgorithmEngineerTest.class: AlgorithmEngineerTest.java		HashtableMap.class
	javac AlgorithmEngineerTest.java 

HashtableMap.class:	HashtableMap.java	HashTableSortedSets.class
	javac HashtableMap.java
	
HashTableSortedSets.class: HashTableSortedSets.java	IHashTableSortedSets.class
	javac HashTableSortedSets.java

IHashTableSortedSets.class: IHashTableSortedSets.java	MapADT.class
	javac IHashTableSortedSets.java

MapADT.class: MapADT.java
	javac MapADT.java
       	
clean:
	rm *.class              
