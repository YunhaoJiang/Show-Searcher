runTest:	AlgorithmEngineerTest.class
	java AlgorithmEngineerTest

AlgorithmEngineerTest.class: AlgorithmEngineerTest.java		HashtableMap.class
	javac AlgorithmEngineerTest.java 

HashtableMap.class:	HashtableMap.java	HashTableSortedSets.class
	javac HashtableMap.java
	
HashTableSortedSets.class: HashTableSortedSets.java
	javac HashTableSortedSets.jva
       	
clean:
	rm *.class              
