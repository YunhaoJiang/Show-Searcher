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

