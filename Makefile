runTests: FrontendDeveloperTests.java
	javac FrontendDeveloperTests.java
	java FrontendDeveloperTests

runBackendDeveloperTests: BackendDeveloperTests.class ShowSearcherBackend.class
	java BackendDeveloperTests

BackendDeveloperTests.class: BackendDeveloperTests.java
	javac BackendDeveloperTests.java

ShowSearcherBackend.class: ShowSearcherBackend.java
	javac ShowSearcherBackend.java

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

runDataWranglerTests: DataWranglerTests.class ShowLoader.class Show.class
	java DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac DataWranglerTests.java

ShowLoader.class: ShowLoader.java Show.java
	javac ShowLoader.java

Show.class: Show.java
	javac Show.java

clean:
	rm *.class
