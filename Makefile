run: ShowSearcherApp.java
	javac ShowSearcherApp.java
	java ShowSearcherApp

runTests: runAlgorithmEngineerTest runBackendDeveloperTests runDataWranglerTests runFrontendDeveloperTests

runFrontendDeveloperTests: FrontendDeveloperTests.java
	javac FrontendDeveloperTests.java
	java FrontendDeveloperTests

runBackendDeveloperTests: BackendDeveloperTests.java
	javac BackendDeveloperTests.java
	java BackendDeveloperTests

runAlgorithmEngineerTest:	AlgorithmEngineerTest.java
	javac AlgorithmEngineerTest.java
	java AlgorithmEngineerTest

runDataWranglerTests: DataWranglerTests.java
	javac DataWranglerTests.java
	java DataWranglerTests

clean:
	rm *.class
