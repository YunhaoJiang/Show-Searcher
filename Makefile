runTests: FrontendDeveloperTests.java
	javac FrontendDeveloperTests.java
	java FrontendDeveloperTests

clean:
	rm *.class

runBackendDeveloperTests: BackendDeveloperTests.class ShowSearcherBackend.class TempHashTableSortedSets.class TempShow.class TempShowLoader.class
	java BackendDeveloperTests

BackendDeveloperTests.class:
	javac BackendDeveloperTests.java

ShowSearcherBackend.class: ShowSearcherBackend.java
	javac ShowSearcherBackend.java

TempHashTableSortedSets.class: TempHashTableSortedSets.java
	javac TempHashTableSortedSets

TempShow.class: TempShow.java
	javac TempShow.java

TempShowLoader.class: TempShowLoader.java
	javac TempShowLoader.java

runAlgorithmEngineerTest:	AlgorithmEngineerTest.class
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
>>>>>>> AlgorithmEngineer
