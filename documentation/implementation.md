# Maze generator implementation document

## Structure

## Main functionality

## GUI

GUI is quite simple and easy to understand. 

User can change default size values for the maze and push for new maze using algorithm stated by a button. Newly generated maze is displayed below. Starting position is marked with ```@``` and goal by ```!```.

![alt text](https://github.com/koedi/tira-loska/blob/main/documentation/maze.png)

## Places for improvements

One of the biggest improvemets for clarity and future expansions would have been to make Maze super class and specific maze generators would inherit from this class. This would allow lifting general structures and methods to super and child classes would only contain algorithm specific implementation. 

GUI is still a bit messy-ish, but this is put under low experience with JavaFX. It is better than my first application in Ohte, but there is still room for improvement.

GUI scaling would have been nice and possibly another way to depict the maze. I think that is is easy to read, but there are better alternatives. At least in one of my peer reviews the maze display was excellent and much easier than I have.

Maze generation / checking could be cleaner and not rely solely on the characters.
