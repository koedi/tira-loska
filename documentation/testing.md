# Maze generator testing document

This document describes implemented testing and tests.

Checkstyle, JUnit tests and Code coverage are run as GitHub Action to implement simple CI.

## Maze integrity testing
Class Maze contains methods used to test maze integrity, i.e. all cells are accessible. Integrity testing is implemented using Depth First Search.

DFS starts from starting cell (1,1) marked with ```@``` and traverses through the whole maze using recursion. DFS keeps track of visited cells. After traverse is completed the number of visited cells and the number of maze cells are compared. If numbers are not equal, there are cells that are not accessible from starting cell and maze generation has failed.  


## Unit testing using JUnit

GUI and related methods are not tested.

There are several unit tests covering all used methods to check correct operation. Unit tests are run as GitHub actions and creates CI pipe. GitHub actions are triggered with any changes to the code (git push). Unit test status is shown (passed / failed) is shown on repository readme and below.

![GitHub actions](https://github.com/koedi/tira-loska/workflows/Java%20CI%20with%20Gradle/badge.svg)



## Code coverage

Covecov is used to measure testing coverage. Unit tests are used to cover classes anad methods used in the application. GUI is not tested. Code testing coverge is displayed as percentage of lines covered by tests vs. all lines in source code. Codecov status is shouwn on repository readme and below.

![codecov](https://codecov.io/gh/koedi/tira-loska/branch/main/graph/badge.svg?token=2C8QYF8DPV)


## Checkstyle

Checkstyle is used as part of build and uses default settings from Ohjelmistotuotanto-course. Only change is increased method length from 25 to 40 to accomodate feasible UI.


## Time and space complexity

### Binary Tree
The time complexity of BT is ```O(n)```, where ```n``` is the number of nodes.

The space complexity of BT is ```O(1)```. There is no recursion, stack, or any other data structure needed.



### Depth First Search (recursive)
The time complexity of DFS is ```O(V + E)```, where ```V``` is the number of vertices and ```E``` is the number of egdes.

The space complexity of DFS is ```O(n)```, where ```n``` is the number of nodes.
