# User guide for Maze generator

## Running jar

Latest release as ```jar``` can be downloaded from [here](https://github.com/koedi/tira-loska/releases/tag/v1.0). Jar can be executed, assuming java is available, with command ```java -jar tira-loska-all.jar```. This will start the program and a GUI will appear.

User can change maze dimensions between [1,100] and select which algoritm is used for maze creation.

![alt text](https://github.com/koedi/tira-loska/blob/main/documentation/start.png)

After pressing either button the maze is generated and ```Maze ok``` text will appear if maze was generated correctly. This is an internal check to confirm if selected algorithm ran correctly. If ```Maze nok```appears, something went wrong :(

![alt text](https://github.com/koedi/tira-loska/blob/main/documentation/mazeok.png)

New maze is generated each time either button is pressed.


## Running from source code -- gradle build

Source code contains Gradle, which can be used to build, test and run the program. Source code can be obtained by copying source code from [here](https://github.com/koedi/tira-loska/releases/tag/v1.0) or by cloning the repository. 

Example for cloning with git and running using gradle

```
git clone https://github.com/koedi/tira-loska
cd tira-loska/
./gradlew run
```
## Testing

After getting source code the program can be tested

### Unit testing report
Running unit tests
```
./gradlew test
```
Unit test report is available, after running above command, in ```build/reports/tests/test/index.html```

Implemented unit tests are located in ```src/test/java/domain/```. There are unit tests for three components: Maze, DFS and BinaryTree. Tests verify the correct operation for the Maze class and for maze generation algorithms.


### Jacoco test report
Running Jacoco code coverage test
```
./gradlew jacocoTestReport
```
Jacoco test report is available, after running above command, in ```/build/reports/jacoco/test/html/index.html```

### Checkstyle in use
Running Checkstyle test
```
./gradlew checkstyleMain
```
Checkstyle report is available, after running above command, in ```build/reports/checkstyle/main.html```

Checkstyle configuratio file is located in ```config/checkstyle/```. The xml-file contains rules for checkstyle tests.
