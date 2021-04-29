# Maze generator implementation document

## Structure

The basic structure is quite straight forward. The application consists of UI and Maze functionality, which have been separated. UI contains the user interface generation and it uses the provided Maze functionality through general methods. The actual Maze funtionality is not accessible for UI. The used application structure is depicted in picture below

![alt text](https://github.com/koedi/tira-loska/blob/main/documentation/classes.png)


## Main functionality

The main funcitonality is divided into two parts: UI and Maze.

### UI

UI is responsible to handle user actions (input validation, listeners, events) and displaying the generated Maze. Events (buttons) created by the user are used to generate user selected Maze and UI calls appropriate methods to 1) create Maze object 2) calling Maze to be created using selected algorihtm and 3) displaying the generated maze.

### Maze

Currently Maze funtionality consists of three parts: Maze, Binary Tree algorithm and Depth First Seach algorithm.

Maze is object to contain the Maze and algorithms are used to generate maze. Binary Tree and Depth First Search algorithms are described in more detail here:
[Maze generation algorithms](https://medium.com/analytics-vidhya/maze-generations-algorithms-and-visualizations-9f5e88a3ae37)

Maze start and goal are always in opposite corners -- north-west and south-east. They are not placed as far as possible, this is a design choice.

Maze size is restricted between (1,1) and (100,100). First limit is quite obvious, but latter one is not a limitation of algorithms as such, but of choice implementation of Depth First Search. Binary Tree algorithm is capable to create large mazes without running to memory limitations, but recursive DFS increases the stack size and eventually will crash. Therefore the maze size hasa been limiteted. Alternative, would be to use stack instead of recursion, and the building blocks for this are available, but this implementation choice was abandoned by lack of time.


## GUI

GUI is quite simple and easy to understand. 

User can change default size values for the maze and push for new maze using algorithm stated by a button. Newly generated maze is displayed below. Starting position is marked with ```@``` and goal by ```!```.

![alt text](https://github.com/koedi/tira-loska/blob/main/documentation/maze.png)


## Places for improvements

One of the biggest improvemets for clarity and future expansions would have been to make Maze super class and specific maze generators would inherit from this class. This would allow lifting general structures and methods to super and child classes would only contain algorithm specific implementation. 

GUI is still a bit messy-ish, but this is put under low experience with JavaFX. It is better than my first application in Ohte, but there is still room for improvement.

GUI scaling would have been nice and possibly another way to depict the maze. I think that is is easy to read, but there are better alternatives. At least in one of my peer reviews the maze display was excellent and much easier than I have.

Maze generation / checking could be cleaner and not rely solely on the characters.
