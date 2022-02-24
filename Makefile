run: DataWranglerTests.class ShowLoader.class Show.class
	java DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac DataWranglerTests.java

ShowLoader.class: ShowLoader.java Show.java
	javac ShowLoader.java

Show.class: Show.java
	javac Show.java

clean:
	rm *.class
